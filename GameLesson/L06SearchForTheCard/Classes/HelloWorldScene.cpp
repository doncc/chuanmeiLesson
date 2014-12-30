#include "HelloWorldScene.h"



Scene* HelloWorld::createScene()
{
    // 'scene' is an autorelease object
    auto scene = Scene::create();
    
    // 'layer' is an autorelease object
    auto layer = HelloWorld::create();

    // add layer as a child to scene
    scene->addChild(layer);

    // return the scene
    return scene;
}

// on "init" you need to initialize your instance
bool HelloWorld::init()
{
    //////////////////////////////
    // 1. super init first
    if ( !Layer::init() )
    {
        return false;
    }
    
    initGame();
        
    return true;
}

void HelloWorld::initGame(){
    visibleSize = Director::getInstance()->getVisibleSize();
    pointArr = new PointArray();
    pointArr->initWithCapacity(0);
    cardArr = new Vector<Sprite*>();
    
    imgName[0] = "img1.png";
    imgName[1] = "img2.png";
    imgName[2] = "img3.png";
    imgName[3] = "img4.png";
    imgName[4] = "img5.png";
    
    srand(time(NULL));
    
    int cardWith = visibleSize.width / 5;
    int cardHeight = visibleSize.height / 7;
    
    getAllPoint(cardWith, cardHeight);
    addCard();
    
    auto listener = EventListenerTouchOneByOne::create();
    listener->onTouchBegan = [this](Touch *t, Event *e){
      
        Sprite *sp;
        
        for (auto it = cardArr->begin(); it!=cardArr->end(); it++) {
            
            sp = *it;
            
            if (sp->getBoundingBox().containsPoint(t->getLocation())) {
                
                if (sp->getTag() == rightIndex) {
                    log("yes");
                }else{
                    log("no");
                }
                
                break;
            }
        }
        
        
        return true;
    };
    Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(listener, this);
    
}

void HelloWorld::addCard(){
    
    for (int i = 0; i < 5; i++) {
        addCard(i);
    }
    rightIndex = rand() % 4;
    addCard(rightIndex);
}

void HelloWorld::addCard(int index){
    
    int randIndex = rand() % pointArr->count();
    Vec2 point = pointArr->getControlPointAtIndex(randIndex);
    pointArr->removeControlPointAtIndex(randIndex);
    
    Sprite *card = Sprite::create(imgName[index]);
    card->setAnchorPoint(Vec2::ZERO);
    card->setPosition(point);
    card->setTag(index);
    addChild(card);
    
    cardArr->pushBack(card);
}

void HelloWorld::getAllPoint(int cardWidth, int cardHeight){
    
    for (int y = 0; y < 7; y++) {
        for (int x = 0; x < 5; x++) {
            
            pointArr->addControlPoint(Vec2(x * cardWidth, y * cardHeight));
        }
    }
}



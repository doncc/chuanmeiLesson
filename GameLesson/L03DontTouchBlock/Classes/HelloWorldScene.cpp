#include "HelloWorldScene.h"
#include "CustomRect.h"


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
    lineCount = 0;
    visibleSize = Director::getInstance()->getVisibleSize();
    srand(time(NULL));
    
    addNormalLine();
    
    for (int i = 1; i <= 3; i++) {
        addGameLine(i);
    }
    
    auto listener = EventListenerTouchOneByOne::create();
    listener->onTouchBegan = [this](Touch *t, Event *e){
      
        auto rectArr = CustomRect::getRects();
        CustomRect *rect;
        
        for (auto it = rectArr->begin(); it != rectArr->end(); it++) {
            rect = *it;
            
            if (rect->getBoundingBox().containsPoint(t->getLocation()) &&
                rect->getLineIndex() == 1) {
                
                if (rect->getColor() == Color3B::BLACK) {
                    this->moveRectDown();
                    
                    break;
                }else{
                    MessageBox("you lost!", "");
                }
            }
        }
        return true;
    };
    Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(listener, this);
}

void HelloWorld::moveRectDown(){
    

    if (lineCount < INT_MAX) {
        addGameLine(4);
    }
    
    auto rectArr = CustomRect::getRects();
    CustomRect *rect;
    
    for (auto it = rectArr->begin(); it != rectArr->end(); it++) {
        rect = *it;
        rect->moveRectDown();
    
        if (rect->getLineIndex() < -1) {
            removeChild(rect);
        }
    }
    log("%d", getChildren().size());

}

void HelloWorld::addGameLine(int lineIndex){
    int randomIndex = rand() % 4;
    for (int i = 0; i < 4; i++) {
        CustomRect *rect = CustomRect::createWithArgs(randomIndex == i ? Color3B::BLACK : Color3B::WHITE, Size(visibleSize.width/4-1, visibleSize.height/4-1));
        rect->setPosition(i * visibleSize.width/4, lineIndex * visibleSize.height/4);
        rect->setLineIndex(lineIndex);
        addChild(rect);
    }
    
    lineCount++;
}

void HelloWorld::addNormalLine(){
    
    for (int i = 1; i <= 4; i++) {
        CustomRect *rect = CustomRect::createWithArgs(Color3B::YELLOW, Size(i * visibleSize.width/4-1, visibleSize.height/4-1));
        rect->setLineIndex(0);
        addChild(rect);
    }
}

void HelloWorld::menuCloseCallback(Ref* pSender)
{
#if (CC_TARGET_PLATFORM == CC_PLATFORM_WP8) || (CC_TARGET_PLATFORM == CC_PLATFORM_WINRT)
	MessageBox("You pressed the close button. Windows Store Apps do not implement a close button.","Alert");
    return;
#endif

    Director::getInstance()->end();

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS)
    exit(0);
#endif
}

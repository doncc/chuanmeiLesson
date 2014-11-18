#include "HelloWorldScene.h"
#include "CustomView.h"
USING_NS_CC;

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
    
    Size visibleSize = Director::getInstance()->getVisibleSize();
    
//    auto view = CustomView::create();
//    addChild(view);
    
//    MessageBox("我是内容", "我是标题");
    
//    Label *lab = Label::create();
//    lab->setString("Hello CUC");
//    lab->setPosition(visibleSize.width/2, visibleSize.height/2);
//    lab->setSystemFontSize(36);
//    addChild(lab);
    
//    TextFieldTTF *txtF = TextFieldTTF::textFieldWithPlaceHolder("input text", "黑体", 30);
//    txtF->setPosition(visibleSize.width/2, visibleSize.height/2);
//    addChild(txtF);
    
    Sprite *sp = Sprite::create("HelloWorld.png");
    sp->cocos2d::Node::setPosition(visibleSize.width/2, visibleSize.height/2);
    addChild(sp);
    
    auto lisener = EventListenerTouchOneByOne::create();
    lisener->onTouchBegan = [](Touch *t, Event *e){

//        if (txtF->getBoundingBox().containsPoint(t->getLocation())) {
//            txtF->attachWithIME();
//        }else{
//            txtF->detachWithIME();
//        }
//        Director::getInstance()->replaceScene(CustomView::create());
        Director::getInstance()->replaceScene(TransitionFadeBL::create(2, CustomView::create()));
        
        return true;
    };
    Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(lisener, sp);
    
//    log("this is log!");
    
    
    
    return true;
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

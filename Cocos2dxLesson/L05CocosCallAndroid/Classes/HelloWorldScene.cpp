#include "HelloWorldScene.h"
#include <platform/android/jni/JniHelper.h>
USING_NS_CC;
//#include "CustomCppCallObjc.h"

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
    
//    Size visibleSize = Director::getInstance()->getVisibleSize();
//    
    auto listener = EventListenerTouchOneByOne::create();
    listener->onTouchBegan = [](Touch *t, Event *e){
        
        JniMethodInfo mInfo;
        JniHelper::getStaticMethodInfo(mInfo, "org/cocos2dx/cpp/AppActivity", "showDialog", "(Ljava/lang/String;)V");
        JniHelper::getEnv()->CallStaticVoidMethod(mInfo.classID, mInfo.methodID, JniHelper::getEnv()->NewStringUTF("Hello CUC"));
        
        return true;
    };
    Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(listener, this);


    
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

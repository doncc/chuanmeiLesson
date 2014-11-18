#include "HelloWorldScene.h"

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
    
    //    auto cache =  SpriteFrameCache::getInstance();
    //    cache->addSpriteFramesWithFile("personRun.plist");
    //
    //    Vector<SpriteFrame*> vc;
    //    char imgName[10];
    //    memset(imgName, 0, 10);
    //
    //    for (int i = 0 ; i < 8; i++) {
    //        sprintf(imgName, "img%1d.png", i);
    //        vc.pushBack(cache->getSpriteFrameByName(imgName));
    //    }
    //
    //    Animation *animation = Animation::createWithSpriteFrames(vc, 0.1f);
    //    Animate *animate = Animate::create(animation);
    //
    //    Sprite *sp = Sprite::create();
    //
    //    sp->setPosition(visibleSize.width/2, visibleSize.height/2);
    //    sp->runAction(RepeatForever::create(animate));
    //
    //    addChild(sp);
    Device::setAccelerometerEnabled(true);
    Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(EventListenerAcceleration::create(
                                                                                                                            
                                                                                                                            [](Acceleration *a, Event *e){
                                      
                                                                                                                                log("x:%d y:%d z:%d");
                                                                                                                            }
                                                                                                                            ), this);
    
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

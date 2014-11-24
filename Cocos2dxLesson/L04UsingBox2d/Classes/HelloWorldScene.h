#ifndef __HELLOWORLD_SCENE_H__
#define __HELLOWORLD_SCENE_H__

#include "cocos2d.h"
#include <Box2D/Box2D.h>
#include "AppDelegate.h"
USING_NS_CC;
#define GAMERATIO WIDTH/10

class HelloWorld : public cocos2d::Layer, public b2ContactListener
{
private:
    b2World *world;
    Size visibleSize;
    b2Body *groundBody;
public:
    void initGame();
    virtual void update(float delta);
    void addCustomRect();
    void addGround();
    
    virtual void BeginContact(b2Contact* contact);
    
public:
    // there's no 'id' in cpp, so we recommend returning the class instance pointer
    static cocos2d::Scene* createScene();

    // Here's a difference. Method 'init' in cocos2d-x returns bool, instead of returning 'id' in cocos2d-iphone
    virtual bool init();  
    
    // a selector callback
    void menuCloseCallback(cocos2d::Ref* pSender);
    
    // implement the "static create()" method manually
    CREATE_FUNC(HelloWorld);
};

#endif // __HELLOWORLD_SCENE_H__

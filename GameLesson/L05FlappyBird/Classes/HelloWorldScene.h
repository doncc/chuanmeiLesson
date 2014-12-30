#ifndef __HELLOWORLD_SCENE_H__
#define __HELLOWORLD_SCENE_H__

#include "cocos2d.h"
#include <Box2D/Box2D.h>
USING_NS_CC;

#define WORDRATIO 32
#define SPEED -5

class HelloWorld : public cocos2d::Layer,b2ContactListener
{
public:
    // there's no 'id' in cpp, so we recommend returning the class instance pointer
    static cocos2d::Scene* createScene();

    // Here's a difference. Method 'init' in cocos2d-x returns bool, instead of returning 'id' in cocos2d-iphone
    virtual bool init();
    
    // implement the "static create()" method manually
    CREATE_FUNC(HelloWorld);
    
private:
    b2World *world;
    Size visibleSize;
    b2Body *birdBody;
    
    Sprite *pipeLayer;
    
    bool isGameOver;
    
public:
    void initGame();
    virtual void update(float dur);
    
    void addBird();
    void addGround();
    void addPipe(float dur);
    virtual void BeginContact(b2Contact* contact);
    
    void gameOver();
    void restartGame();
};

#endif // __HELLOWORLD_SCENE_H__

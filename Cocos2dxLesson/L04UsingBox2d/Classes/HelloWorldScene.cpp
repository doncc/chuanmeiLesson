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
    
    visibleSize = Director::getInstance()->getVisibleSize();
    initGame();
    addCustomRect();
    addGround();
    
    return true;
}

void HelloWorld::initGame(){
    world = new b2World(b2Vec2(0, -10));
    world->SetContactListener(this);
    scheduleUpdate();
}

void HelloWorld::BeginContact(b2Contact *contact){
    if (contact->GetFixtureA()->GetBody() == groundBody ||
        contact->GetFixtureB()->GetBody() == groundBody) {
        
        log("YSE");
    }
}

void HelloWorld::addCustomRect(){
    b2BodyDef rectDef;
    //    rectDef.type = b2_kinematicBody;
    //    rectDef.type = b2_staticBody;
    rectDef.type = b2_dynamicBody;
    rectDef.linearVelocity = b2Vec2(3, 6);
    rectDef.position = b2Vec2(0, 3);
    b2Body *rectBody = world->CreateBody(&rectDef);
    
    Sprite *sp = Sprite::create();
    sp->setTextureRect(Rect(0, 0, 1 * GAMERATIO, 1 * GAMERATIO));
    sp->setPosition(rectDef.position.x * GAMERATIO, rectDef.position.y *GAMERATIO);
    addChild(sp);
    
    rectBody->SetUserData(sp);
    
    b2PolygonShape rectShape;
    rectShape.SetAsBox(0.5, 0.5);
    b2FixtureDef rectFixDef;
    rectFixDef.restitution = 0.2;
    rectFixDef.shape = &rectShape;
    rectBody->CreateFixture(&rectFixDef);
}

void HelloWorld::addGround(){
    b2BodyDef groundDef;
    groundDef.type = b2_staticBody;
    groundDef.position = b2Vec2(visibleSize.width, 0);
    groundBody = world->CreateBody(&groundDef);
    
    b2PolygonShape groundShape;
    groundShape.SetAsBox(visibleSize.width, 0);
    b2FixtureDef groundFixDef;
    groundFixDef.shape = &groundShape;
//    groundFixDef.restitution = 0.015;
    groundBody->CreateFixture(&groundFixDef);
    
}

void HelloWorld::update(float delta){
    
    world->Step(delta, 8, 3);
    
    Sprite *sp;
    for (b2Body *body = world->GetBodyList(); body!=NULL; body = body ->GetNext()) {
        
        if (body->GetUserData()) {
            sp = (Sprite*)body->GetUserData();
            sp->setPosition(body->GetPosition().x * GAMERATIO, body->GetPosition().y * GAMERATIO);
        }
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

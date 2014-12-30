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
    
    isGameOver = false;
    visibleSize = Director::getInstance()->getVisibleSize();
    world = new b2World(b2Vec2(0, -25));
    world->SetContactListener(this);
    pipeLayer = Sprite::create();
    addChild(pipeLayer);
    
    addBird();
    addGround();
    schedule(schedule_selector(HelloWorld::addPipe), 1.5);
    
    auto listener = EventListenerTouchOneByOne::create();
    listener->onTouchBegan = [this](Touch *, Event *){
      
        if (isGameOver) {
            this->restartGame();
            return true;
        }
        
        birdBody->SetLinearVelocity(b2Vec2(0, 10));
        
        return true;
    };
    Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(listener, this);
    
    scheduleUpdate();
}

void HelloWorld::restartGame(){
    
    for (b2Body *body = world->GetBodyList(); body!=NULL; body = body->GetNext()) {
        
        world->DestroyBody(body);
    }
    removeAllChildren();
    
    initGame();
}

void HelloWorld::BeginContact(b2Contact *contact){
    if (contact->GetFixtureA()->GetBody() == birdBody ||
        contact->GetFixtureB()->GetBody() == birdBody) {
        gameOver();
    }
}

void HelloWorld::gameOver(){
    
    unschedule(schedule_selector(HelloWorld::addPipe));
    unscheduleUpdate();
    MessageBox("game over!", "");
    isGameOver = true;
}

void HelloWorld::addPipe(float dur){
    
    float randHeight = rand() % 4;
    //add buttom pipe start
    
    b2BodyDef buttomBodyDef;
    buttomBodyDef.type = b2_kinematicBody;
    buttomBodyDef.linearVelocity = b2Vec2(SPEED, 0);
    buttomBodyDef.position = b2Vec2(visibleSize.width / WORDRATIO + 2, 0 + randHeight);
    b2Body *buttomBody = world->CreateBody(&buttomBodyDef);
    Sprite *buttomPipe = Sprite::create("bound_down.png");
    Size buttomSize = buttomPipe->getContentSize();
    
    buttomPipe->setPosition(buttomBodyDef.position.x * WORDRATIO, buttomBodyDef.position.y * WORDRATIO);
    pipeLayer->addChild(buttomPipe);
    
    buttomBody->SetUserData(buttomPipe);
    
    b2PolygonShape buttomShape;
    buttomShape.SetAsBox(buttomSize.width / 2 / WORDRATIO, buttomSize.height / 2 / WORDRATIO);
    b2FixtureDef buttomFixDef;
    buttomFixDef.shape = &buttomShape;
    buttomBody->CreateFixture(&buttomFixDef);
    
    //add buttom pipe end
    
    //add top pipe start

    Sprite *topPipe = Sprite::create("bound_up.png");
    Size topSize = topPipe->getContentSize();
    
    b2BodyDef topBodyDef;
    topBodyDef.type = b2_kinematicBody;
    topBodyDef.linearVelocity = b2Vec2(SPEED, 0);
    topBodyDef.position = b2Vec2(visibleSize.width / WORDRATIO + 2, topSize.height / WORDRATIO + 3 + randHeight);
    b2Body *topBody = world->CreateBody(&topBodyDef);
    
    topPipe->setPosition(topBodyDef.position.x * WORDRATIO, topBodyDef.position.y * WORDRATIO);
    pipeLayer->addChild(topPipe);
    
    topBody->SetUserData(topPipe);
    
    b2PolygonShape topShape;
    topShape.SetAsBox(topSize.width / 2 / WORDRATIO, topSize.height / 2 / WORDRATIO);
    b2FixtureDef topFixDef;
    topFixDef.shape = &topShape;
    topBody->CreateFixture(&topFixDef);
    //add top pipe end
    
}

void HelloWorld::addGround(){
    Sprite *ground = Sprite::create("ground.png");
    Size groundSize = ground->getContentSize();
    
    b2BodyDef groundBodyDef;
    groundBodyDef.type = b2_staticBody;
    groundBodyDef.position = b2Vec2(groundSize.width / 2 / WORDRATIO, groundSize.height / 2 / WORDRATIO);
    b2Body *groundBody = world->CreateBody(&groundBodyDef);
    
    ground->setPosition(groundBodyDef.position.x * WORDRATIO, groundBodyDef.position.y * WORDRATIO);
    addChild(ground);
    
    b2PolygonShape groundShape;
    groundShape.SetAsBox(groundSize.width / 2 / WORDRATIO, groundSize.height / 2 / WORDRATIO);
    b2FixtureDef groundFixDef;
    groundFixDef.shape = &groundShape;
    groundBody->CreateFixture(&groundFixDef);
    
}

void HelloWorld::addBird(){
    
    b2BodyDef birdBodyDef;
    birdBodyDef.type = b2_dynamicBody;
    birdBodyDef.linearVelocity = b2Vec2(0, 10);
    birdBodyDef.position = b2Vec2(visibleSize.width / 2 / WORDRATIO, visibleSize.height / 2 / WORDRATIO);
    birdBody = world->CreateBody(&birdBodyDef);
    Sprite *bird = Sprite::create("bird_blue_0.png");
    Size birdSize = bird->getContentSize();
    
    bird->setPosition(birdBodyDef.position.x * WORDRATIO, birdBodyDef.position.y * WORDRATIO);
    addChild(bird);
    birdBody->SetUserData(bird);
    
    b2PolygonShape birdShape;
    birdShape.SetAsBox(birdSize.width / 2 / WORDRATIO, birdSize.height / 2 / WORDRATIO);
    b2FixtureDef birdFixDef;
    birdFixDef.shape = &birdShape;
    birdBody->CreateFixture(&birdFixDef);
    
}

void HelloWorld::update(float dur){
    
    world->Step(dur, 8, 3);
    Sprite *sp;
    
    for (b2Body *body = world->GetBodyList(); body!=NULL; body = body->GetNext()) {
        
        if (body->GetUserData()) {
            
            sp = (Sprite*)body->GetUserData();
            sp->setPosition(body->GetPosition().x * WORDRATIO, body->GetPosition().y * WORDRATIO);
            
            if (sp->getPositionX() < -2 * WORDRATIO) {
                world->DestroyBody(body);
                removeChild(sp);
                log("remove");
            }
        }
    }
}



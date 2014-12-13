//
//  CustomRect.cpp
//  L03DontTouchBlock
//
//  Created by Pakchoi on 14/12/13.
//
//

#include "CustomRect.h"

CustomRect *CustomRect::createWithArgs(cocos2d::Color3B rectColor, cocos2d::Size rectSize){
    
    CustomRect *rect = new CustomRect();
    rect->initWithArgs(rectColor, rectSize);
    
    rectArr->pushBack(rect);
    rect->autorelease();
    return rect;
}

bool CustomRect::initWithArgs(Color3B rectColor, Size rectSize){
    
    Sprite::init();
    setColor(rectColor);
    setAnchorPoint(Vec2::ZERO);
    setContentSize(rectSize);
    setTextureRect(Rect(0, 0, rectSize.width, rectSize.height));
    
    return true;
}

Vector<CustomRect*> *CustomRect::rectArr = new Vector<CustomRect*>();

Vector<CustomRect*> *CustomRect::getRects(){
    return CustomRect::rectArr;
}

void CustomRect::setLineIndex(int index){
    this->lineIndex = index;
}

int CustomRect::getLineIndex(){
    
    return this->lineIndex;
}

void CustomRect::moveRectDown(){
    
    lineIndex--;
    
    Size visibleSize = Director::getInstance()->getVisibleSize();
    
    runAction(MoveTo::create(0.1f, Vec2(getPositionX(), lineIndex * visibleSize.height/4)));
}

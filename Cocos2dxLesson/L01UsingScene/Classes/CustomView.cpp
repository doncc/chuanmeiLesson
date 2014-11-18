//
//  CustomView.cpp
//  L01UsingScene
//
//  Created by Pakchoi on 14/11/16.
//
//

#include "CustomView.h"

bool CustomView::init(){
    
    Size visibleSize = Director::getInstance()->getVisibleSize();
    
    Sprite *sp = Sprite::create("img.jpg");
    sp->setPosition(visibleSize.width/2, visibleSize.height/2);
    addChild(sp);
    
    return true;
}

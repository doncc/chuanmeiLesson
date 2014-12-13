//
//  CustomRect.h
//  L03DontTouchBlock
//
//  Created by Pakchoi on 14/12/13.
//
//

#ifndef __L03DontTouchBlock__CustomRect__
#define __L03DontTouchBlock__CustomRect__

#include <stdio.h>
#include <cocos2d.h>

USING_NS_CC;

class CustomRect:public Sprite {
    
private:
    
    static Vector<CustomRect*> *rectArr;
    
    int lineIndex;
    
public:
    
    static CustomRect *createWithArgs(Color3B rectColor, Size rectSize);
    
    virtual bool initWithArgs(Color3B rectColor, Size rectSize);
    static Vector<CustomRect*> *getRects();
    
    void setLineIndex(int index);
    int getLineIndex();
    
    void moveRectDown();
};




#endif /* defined(__L03DontTouchBlock__CustomRect__) */

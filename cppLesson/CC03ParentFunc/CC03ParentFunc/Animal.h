//
//  Animal.h
//  CC03ParentFunc
//
//  Created by Pakchoi on 14/9/27.
//
//

#ifndef __CC03ParentFunc__Animal__
#define __CC03ParentFunc__Animal__

#include <iostream>

class Animal {
    
    
public:
    
    virtual void run();
    virtual void voice()=0;
};

#endif /* defined(__CC03ParentFunc__Animal__) */

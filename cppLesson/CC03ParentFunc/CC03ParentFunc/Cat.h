//
//  Cat.h
//  CC03ParentFunc
//
//  Created by Pakchoi on 14/9/27.
//
//

#ifndef __CC03ParentFunc__Cat__
#define __CC03ParentFunc__Cat__

#include <iostream>
#include "Animal.h"

class Cat:public Animal {
    
    
public:
    
    virtual void run();
    virtual void voice();
};

#endif /* defined(__CC03ParentFunc__Cat__) */

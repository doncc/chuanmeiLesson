//
//  main.cpp
//  CC03ParentFunc
//
//  Created by Pakchoi on 14/9/27.
//
//

#include <iostream>
#include "Cat.h"

int main(int argc, const char * argv[])
{

//    // insert code here...
//    std::cout << "Hello, World!\n";
    
    Animal *ani = new Cat();
    ani->run();
    ani->voice();
    return 0;
}


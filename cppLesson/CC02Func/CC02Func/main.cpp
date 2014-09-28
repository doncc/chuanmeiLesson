//
//  main.cpp
//  CC02Func
//
//  Created by Pakchoi on 14/9/27.
//
//

#include <iostream>

class Animal {
    
    
public:
    
    Animal(){
        printf("构造函数\n");
    }
    
    ~Animal(){
        printf("析构函数\n");
    }
};

int main(int argc, const char * argv[])
{

    // insert code here...
//    std::cout << "Hello, World!\n";
    
    
//    Animal *ani = new Animal();
//    delete ani;
    Animal ani;
    
    return 0;
}


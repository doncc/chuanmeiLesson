//
//  main.cpp
//  CC04UsingNamespace
//
//  Created by Pakchoi on 14/9/27.
//
//

#include <iostream>

namespace chuanmei {
    
    class Animal {
    
    public:
        void run(){
            printf("run \n");
        }
    };
    
}

int main(int argc, const char * argv[])
{
    
    // insert code here...
    //    std::cout << "Hello, World!\n";
    
    chuanmei::Animal *ani =new chuanmei::Animal();
    ani->run();
    return 0;
}


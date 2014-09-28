//
//  main.cpp
//  CC05UsingString
//
//  Created by Pakchoi on 14/9/27.
//
//

#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main(int argc, const char * argv[])
{

//    // insert code here...
//    std::cout << "Hello, World!\n";
    
    string str;
    str+= "Hello ";
    str+= "chuanmei \n";
    cout << str;
    
    stringstream ss;
    ss << 1;
    ss << "shuaige \n";
    cout << ss.str();
    
    return 0;
}


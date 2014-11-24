//
//  ViewController.m
//  L06IOSCallCpp
//
//  Created by Pakchoi on 14/11/22.
//
//

#import "ViewController.h"
#include "Cat.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    Cat *cat = new Cat();
    cat->catRun();
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end

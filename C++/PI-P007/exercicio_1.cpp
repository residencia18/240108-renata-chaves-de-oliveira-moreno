#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
using namespace std;

int main()
{ 
    int i;

    for(i = 1; i <= 100; i++)
   
    {
        if(i % 3== 0)
        {
          cout<<"Fizz"<<endl;  
        }
        if(i % 5 == 0)
        {
            cout<<"Buzz"<<endl;
        }
        if((i % 3== 0)&&(i % 5 == 0))
        {
            cout<<"FizzBuzz"<<endl;
        }
        else
        {
           cout<<i<<endl;
        }
    }
    
  



    return 0;
}


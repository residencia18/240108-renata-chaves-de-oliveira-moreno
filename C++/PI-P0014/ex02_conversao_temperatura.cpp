#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <algorithm>
#include <string>
using namespace std;

float Conversao(float c)
{
    int f;
    f = (c * 9/5) + 32;

    return f;
}

int main()
{
    float celsius,fahrenheit;

    cout<<"Informe a temperatura em C: ";
    cin>>celsius;

    fahrenheit = Conversao(celsius);
    cout<<celsius<<" graus Celsius "<<"convertida em Fahrenheit e "<<fahrenheit;
    

 return 0;   
}
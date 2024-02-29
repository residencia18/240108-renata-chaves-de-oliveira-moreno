#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <algorithm>
#include <string>
using namespace std;

struct Fatorial
{
   int num1,num2,num3,fato_rial;
}fat[3];


int Fat(int numero)
{
    int fatorial = 1;
    for(int i = 1; i <= numero; i++) //laço para ir de 1 até o numero digitado
    {
    fatorial *= i; //realiza o calculo de 1 ate o numero digitado
    }

    return fatorial;
}

int main()
{
    
    int x = 0;
    int y = 0;

    cout<<"Digite um numero: ";
    cin>>fat[x].num1;
    cout<<endl;
    cout<<"Digite um numero: ";
    cin>>fat[x].num2;
    cout<<endl;
    cout<<"Digite um numero: ";
    cin>>fat[x].num3;
    cout<<endl;
       
    x++;
    
    for(y=0; y<x; y++)
    {
    cout<<"O fatorial de "<<fat[y].num1<<" e "<<(fat[y].fato_rial = Fat(fat[y].num1))<<endl;
    cout<<"O fatorial de "<<fat[y].num2<<" e "<<(fat[y].fato_rial = Fat(fat[y].num2))<<endl;
    cout<<"O fatorial de "<<fat[y].num3<<" e "<<(fat[y].fato_rial = Fat(fat[y].num3))<<endl;
    }

    return 0;
}

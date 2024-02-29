#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string>
#include <vector>
using namespace std;

int main()
{
     
     int numero,i;
     int soma = 0;

     cout<<"Digite um numero: ";
     cin>>numero;
     cout<<endl;

     for (i = 1; i <= numero / 2; i++) //encontra os divisores e faz o calculo
     {
        if (numero % i == 0) 
        {
            soma += i;
        }
     }

     if(soma == numero) //compara e diz se é ou não perfeito
     {
        cout<<numero<<" e um numero perfeito!"<<endl;
     }
     else
     {
        cout<<numero<<" nao e um numero perfeito!"<<endl;
     }
    
    return 0;
}

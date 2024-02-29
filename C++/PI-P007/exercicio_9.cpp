#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string>
#include <vector>
using namespace std;

int main()
{
     
     int numero,proximo;
     int anterior = 0,atual = 1;

     cout<<"Digite um numero: ";
     cin>>numero;
     cout<<endl;
     
     cout<<"Sequencia de Fibonacci ate "<<numero<<endl;

     while(anterior <= numero)
     {
        cout<<anterior<<" ";

        proximo = anterior + atual;
        anterior = atual;
        atual = proximo;
     }
     
    
    return 0;
}

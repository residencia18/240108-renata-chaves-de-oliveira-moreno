#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
using namespace std;

int main()
{
    int aleatorio = rand() % 100 + 1; //gerador do numero aleatorio  de 1 a 100
    int numero;
    
do
{
   cout<<"Digite o numero da adivinhacao: ";
   cin>>numero;

   if(numero > aleatorio)
   {
    cout<<"# Seu palpite esta alto! #"<<endl;
   }
   if(numero < aleatorio)
   {
    cout<<"# Seu palpite esta baixo! #"<<endl;
   }
   if(numero == aleatorio)
   {
    cout<<" * * * * * PARABENS! Voce acertou o numero! * * * * * "<<endl;
   }

} while(numero != aleatorio); //enquanto numero digitado for diferente do aleatorio,ele executa o bloco ate acertar

    

    return 0;
}

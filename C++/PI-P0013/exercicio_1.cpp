#include <iostream>
#include <vector>
#include <string>
#include <ctime>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

struct Passageiro
{
    string cpf;
    string nome;
    int idade;
}passageiro[40];

struct Data
{
    int dia,mes,ano;
}data[40];


struct Passagem
{
    int numAssento;
    string hora;
    double valorPassagem = 80.00;
}passagem[40];


int main()
{
    int i =0,j=0;
    double total;
    string resposta;

    do
    {
    cout<<"Informe o CPF do passageiro: ";
    cin>>passageiro[i].cpf;
    cout<<endl;
   
    cout<<"Informe o NOME do passageiro: ";
    cin>>passageiro[i].nome;
    cout<<endl;
    
    cout<<"Informe a IDADE do passageiro: ";
    cin>>passageiro[i].idade;
    cout<<endl;
   
    cout<<"Informe o NUMERO do assento: ";
    cin>>passagem[i].numAssento;
    cout<<endl;
    
    cout<<"Informe a DATA da viagem: ";
    cin>>data[i].dia;
    cin>>data[i].mes;
    cin>>data[i].ano;
    cout<<endl;
    
    cout<<"Informe a HORA da viagem: ";
    cin>>passagem[i].hora;
    cout<<endl;
    
    cout<<"Valor da passagem: R$ "<<passagem[i].valorPassagem;
    cout<<endl;

    total = total + passagem[i].valorPassagem;
    i++;

    cout<<"Cadastrar nova viagem? S/N ";
    cin>>resposta;
    cout<<endl;

    if (resposta == "n" || resposta == "N")
    {
     
     cout<<"Total arrecadado: R$ "<<total<<endl; 
     cout<<"Total arrecadado no mes: R$ "<<data[i].mes<<endl;

    }
     
    
    }while(resposta == "s" || resposta == "S");


    return 0;
}


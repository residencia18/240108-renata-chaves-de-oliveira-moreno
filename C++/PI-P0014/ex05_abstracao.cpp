#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <cmath>
#include <algorithm>
#include <string>
using namespace std;

struct Carro
{
    string cor;
    string marca,modelo;
    double preco;
    int ano;
}carro;


int main()
{
    cout<<"Informe a cor do carro: ";
    cin>>carro.cor;
    cout<<"Informe a marca do carro: ";
    cin>>carro.marca;
    cout<<"Informe o modelo do carro: ";
    cin>>carro.modelo;
    cout<<"Informe o preco do carro: ";
    cin>>carro.preco;
    cout<<"Informe o ano do carro: ";
    cin>>carro.ano;
    cout<<endl;

    cout<<"- CARRO -"<<endl;
    cout<<"Cor: "<<carro.cor<<endl;
    cout<<"Marca: "<<carro.marca<<endl;
    cout<<"Modelo: "<<carro.modelo<<endl;
    cout<<"Preco: "<<carro.preco<<endl;
    cout<<"Ano: "<<carro.ano<<endl;



    return 0;
}

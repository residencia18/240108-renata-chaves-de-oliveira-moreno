#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <cmath>
#include <algorithm>
#include <string>
using namespace std;

struct Ponto
{
    double x1,x2,y1,y2;
}ponto;



int main() 
{
  
    cout << "Digite as coordenadas do primeiro ponto (x1 y1): ";
    cin >> ponto.x1 >> ponto.y1;

    cout << "Digite as coordenadas do segundo ponto (x2 y2): ";
    cin >> ponto.x2 >> ponto.y2;

    double distancia = sqrt(pow(ponto.x2 - ponto.x1, 2) + pow(ponto.y2 - ponto.y1, 2));

    cout << "A distancia entre os dois pontos e: "<< distancia <<endl;

    return 0;
}

   
  





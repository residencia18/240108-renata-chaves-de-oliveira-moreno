#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <cmath>
#include <algorithm>
#include <string>
using namespace std;


class Ponto 
{
private:
    double x;
    double y;

public:
    
    Ponto() : x(0.0), y(0.0) {}

    
    Ponto(double xCoord, double yCoord) : x(xCoord), y(yCoord) {}

    
    void setCoordenadas(double xCoord, double yCoord) 
    {
        x = xCoord;
        y = yCoord;
    }

    
    double getX() const 
    {
        return x;
    }

    double getY() const 
    {
        return y;
    }

   
    double calcularDistanciaOrigem() const 
    {
        return sqrt(x * x + y * y);
    }
};

int main() {
    
    Ponto ponto1(3.0, 4.0);

    
    cout << "Coordenadas do ponto: (" << ponto1.getX() << ", " << ponto1.getY() << ")" <<endl;

   
    double distancia = ponto1.calcularDistanciaOrigem();
    cout << "Distancia ate a origem: " << distancia << endl;

    return 0;
}

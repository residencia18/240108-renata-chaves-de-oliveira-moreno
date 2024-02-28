# Aula19

#include <string>


class Ponto {
private: int x;
         int y;

public:

Ponto (int_x, int_y);
    void set_x(int_x);
    void set_y(int_y);
    int  get_x(void);
    int  get_y(void);
    void operator = (string dados);
};

void Ponto::set_x (int_x)
{
    x=_x;

}

void Ponto::set_y (int_Y)
{
    x=_y;

}

int Ponto::get_x(void){
    return x;
}

int Ponto::get_y(void){
    return y;
}

Ponto::Ponto(int_x, int_y)
{
    x=_x 
    y=_y 
}

void Ponto::operator=(string dados)
{
    x=(int) dados [1];
    y=(int) dadps [3];
}

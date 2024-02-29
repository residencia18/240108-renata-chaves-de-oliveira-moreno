#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;



int main() 
{
    // Inicialize o gerador de números aleatórios com o tempo atual
    srand(time(0));

    //A: Preencha um array com 100 elementos de int
    const int tamanhoVetor = 100;
    int vetor[tamanhoVetor];

    for (int i = 0; i < tamanhoVetor; i++) 
    {
        vetor[i] = 1 + rand() % 20; // Gera números aleatórios entre 1 e 20
    }

    //B: Use um array de 20 posições para contar as ocorrências
    int contador[20] = {0};

    for (int i = 0; i < tamanhoVetor; i++) 
    {
        contador[vetor[i] - 1]++; // Incrementa o contador correspondente
    }

    //C: Determine qual ou quais números aparecem mais vezes
    int maxOcorrencias = 0;

    for (int i = 0; i < 20; i++) 
    {
        if (contador[i] > maxOcorrencias) 
        {
            maxOcorrencias = contador[i];
        }
    }

    cout << "Numeros que mais vezes aparecem: ";

    for (int i = 0; i < 20; i++) 
    {
        if (contador[i] == maxOcorrencias) 
        {
           cout << i + 1 << " ";
        }
    }

    cout << "aparecem " << maxOcorrencias << " vezes." <<endl;

    return 0;
}

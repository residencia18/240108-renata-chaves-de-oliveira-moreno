#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main() {
    // Inicializa a semente para a função rand() com base no tempo atual
    srand(static_cast<unsigned int>(time(nullptr)));

    // Número de estações meteorológicas
    const int numEstacoes = 250;
    
    // Cria um array para armazenar as temperaturas
    double temperaturas[numEstacoes];

    // Preenche o array com temperaturas aleatórias entre 10 e 40 graus
    for (int i = 0; i < numEstacoes; i++) 
    {
        temperaturas[i] = 10 + 30.0 * (rand() % 100) / 3000.0;
    }

    // Determina a temperatura máxima e mínima reportadas
    double temperaturaMaxima = temperaturas[0];
    double temperaturaMinima = temperaturas[0];

    for (int i = 1; i < numEstacoes; i++) 
    {
        if (temperaturas[i] > temperaturaMaxima) 
        {
            temperaturaMaxima = temperaturas[i];
        }
        if (temperaturas[i] < temperaturaMinima) 
        {
            temperaturaMinima = temperaturas[i];
        }
    }

    // Determina a temperatura média entre as 250 estações
    double somaTemperaturas = 0.0;
    for (int i = 0; i < numEstacoes; i++) 
    {
        somaTemperaturas += temperaturas[i];
    }
    double temperaturaMedia = somaTemperaturas / numEstacoes;

    // Atualiza as temperaturas de acordo com o modelo de predição
    for (int i = 0; i < numEstacoes; i++) 
    {
        if (temperaturas[i] > temperaturaMedia) 
        {
            temperaturas[i] += 1.0; // Estações acima da média ficam 1 grau mais quentes
        }
         else
        {
            temperaturas[i] -= 2.0; // Estações abaixo da média ficam 2 graus mais frias
        }
    }

    // Imprime os resultados
    cout << "Temperatura maxima reportada: " << temperaturaMaxima << " graus" << endl;
    cout << "Temperatura minima reportada: " << temperaturaMinima << " graus" << endl;
    cout << "Temperatura media reportada: " << temperaturaMedia << " graus" << endl;

    // Você pode imprimir as temperaturas atualizadas aqui se desejar

    return 0;
}

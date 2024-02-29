#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
using namespace std;


#define NUM_ALUNOS 15

int main() {
    // Inicializa a semente para a função rand() com base no tempo atual
    srand(time(NULL));

    // Arrays para armazenar as notas das duas avaliações e as médias
    float notasAvaliacao1[NUM_ALUNOS];
    float notasAvaliacao2[NUM_ALUNOS];
    float medias[NUM_ALUNOS];

    // Preenche os arrays com notas aleatórias entre 0 e 10
    for (int i = 0; i < NUM_ALUNOS; i++) 
    {
        notasAvaliacao1[i] = ((float)rand() / RAND_MAX) * 10;
        notasAvaliacao2[i] = ((float)rand() / RAND_MAX) * 10;
    }

    // Compara as notas e imprime as mensagens
    cout<<"Desempenho dos alunos na segunda avaliacao:"<<endl;
    for (int i = 0; i < NUM_ALUNOS; i++) 
    {
        if (notasAvaliacao2[i] > notasAvaliacao1[i]) 
        {
            cout<<"Aluno: Melhorou "<< i + 1<<endl;
        } 
        else if (notasAvaliacao2[i] < notasAvaliacao1[i]) 
        {
            cout<<"Aluno: Piorou "<< i + 1<<endl;
        } 
        else 
        {
            cout<<"Aluno: Manteve a nota "<< i + 1<<endl;
        }
    }

    // Calcula as médias das duas avaliações e preenche o terceiro array
    for (int i = 0; i < NUM_ALUNOS; i++) 
    {
        medias[i] = (notasAvaliacao1[i] + notasAvaliacao2[i]) / 2.0;
    }

    // Imprime as médias dos alunos
    cout<<endl;
    cout<<"Médias dos alunos:"<<endl;
    for (int i = 0; i < NUM_ALUNOS; i++) 
    {
        cout<<"Aluno: "<< i + 1<<medias[i]<<endl;
    }

    return 0;
}

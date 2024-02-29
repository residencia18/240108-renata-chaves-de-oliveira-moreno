#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>

using namespace std;

int main() {
    // Inicializa a semente para a função rand() com base no tempo atual
    srand(static_cast<unsigned int>(time(nullptr)));

    // Tamanho da imagem (640x480)
    const int largura = 640;
    const int altura = 480;

    // Matriz para representar a imagem (intensidades de iluminação)
    vector<vector<int>> imagem(altura, vector<int>(largura));

    // Preenche a matriz da imagem com valores aleatórios de 0 a 255
    for (int i = 0; i < altura; i++) 
    {
        for (int j = 0; j < largura; j++) 
        {
            imagem[i][j] = rand() % 256;
        }
    }

    // Cria um vetor para armazenar o histograma (inicializado com zeros)
    vector<int> histograma(256, 0);

    // Calcula o histograma da imagem
    for (int i = 0; i < altura; i++) 
    {
        for (int j = 0; j < largura; j++) 
        {
            histograma[imagem[i][j]]++;
        }
    }

    // Imprime o histograma
    cout << "Histograma da imagem:" << endl;
    for (int i = 0; i < 256; i++) 
    {
        cout << "Intensidade " << i << ": " << histograma[i] << " pixels" << endl;
    }

    return 0;
}

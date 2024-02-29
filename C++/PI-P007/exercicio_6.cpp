#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string>
#include <vector>
using namespace std;


struct Alunos
{
    string matricula;
    double nota1,nota2,nota3,media;
}aluno[10]; //tamanho 10,mas pode ser o tamanho que for necessario


int main()
{
    int i=0,j=0;
    string resposta;
    
do
{ 
   
   cout<<"Matricula: ";
   cin>>aluno[i].matricula;

   cout<<"Nota 1: ";
   cin>>aluno[i].nota1;

   cout<<"Nota 2: ";
   cin>>aluno[i].nota2;

   cout<<"Nota 3: ";
   cin>>aluno[i].nota3;
   cout<<endl;
   
   //calcula a media do aluno cadastrado e armazena no vetor aluno da struct
   aluno[i].media = (aluno[i].nota1 + aluno[i].nota2 + aluno[i].nota3) / 3.0;
   
   i++; //lê os dados e armazena no vetor aluno.
    
    cout<<"Deseja continuar?";
    cin>>resposta; 
    cout<<endl; 

    if(resposta == "n" || resposta == "N")
    {
    for(j = 0; j < i; j++) //acessa os dados cadastrados e imprime na tela
    {
    cout << "MATRICULA    NOTA 1     NOTA 2     NOTA 3    MEDIA" <<endl;
    cout<<"====================================================="<<endl;
    cout<<"   "<<aluno[j].matricula<< "        "<<aluno[j].nota1<<"          "<<aluno[j].nota2<<"          "<<aluno[j].nota3<<"       "<<aluno[j].media<<endl<<endl;
    }
    }

} while((resposta == "s") || (resposta == "s"));

return 0;

}



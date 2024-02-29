#include <iostream>
#include <vector>
#include <string>
#include <ctime>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

struct Empregado
{
    string nome,sobrenome,RG,anoAdmissao;
    double salario,reajuste = 0;
}empregado[50];

void reajusta_dez_porcento(Empregado empregado[50])
{
    int i = 0, j = 0;
    string resposta;

    do
    {
    cout<<"Nome: ";
    cin>>empregado[i].nome; 
    cout<<"Sobrenome: ";
    cin>>empregado[i].sobrenome; 
    cout<<"RG: ";
    cin>>empregado[i].RG;
    cout<<"Ano de admissao: ";
    cin>>empregado[i].anoAdmissao;
    cout<<"Salario: ";
    cin>>empregado[i].salario;
    
    empregado[i].reajuste = empregado[i].salario + (empregado[i].salario * 0.10);
    i++;
     
    cout<<"Deseja reajustar o salario de outro empregado?";
    cin>>resposta; 
    cout<<endl;
    
    if(resposta == "n" || resposta == "N")
    {
    cout<<"* * * SALARIOS ATUALIZADOS * * *"<<endl<<endl;
    
    for(j = 0; j < i; j++)
    {
    cout<<"EMPREGADO: "<<endl<<empregado[j].nome<<" "<<empregado[j].sobrenome<<endl
    <<"Recebia: R$"<<empregado[j].salario<<endl<<"Agora recebe R$ "<<empregado[j].reajuste
    <<endl<<endl;
    }
    }

    }while(resposta == "s" || resposta == "S");
    
}

int main()
{
    cout<<"****** REAJUSTE DE CADA EMPREGADO ******"<<endl<<endl;
    
    reajusta_dez_porcento(empregado);

 
    return 0;
}

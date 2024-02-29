#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <ctime>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

struct  Produtos 
    {
       char nome[20];
       char codigo[13];
       float preco;
    }produto[300];


int main()
{
    int opcao, i = 0, j;

     cout<<"--------Gerenciamento de Produtos--------"<<endl;

    do
    {
     cout<<"Digite a opcao desejada: "<<endl;

     cout<<"1-Cadastrar produto"<<endl;
      
     cout<<"2-Excluir produto pelo codigo"<<endl;

     cout<<"3-Listar produtos"<<endl;

     cout<<"4-Consultar produto pelo codigo"<<endl;

     cout<<"0-SAIR"<<endl;

     cin>>opcao;

     switch(opcao)
     {
         case 1:
         {
         
          cout<<"Informe o codigo do produto: ";
          cin>>produto[i].codigo;
          
          cout<<"Informe o nome do produto: ";
          cin>>produto[i].nome;

          cout<<"Informe o preco do produto: ";
          cin>>produto[i].preco;
          cout<<endl;
          i++;
          cout<<"**** Produto cadastrado com sucesso! ****"<<endl<<endl;
         
          break;
          } 
 
         case 2:
		 {
          string remove;
                    
          cout<<"Digite o codigo do produto a ser removido: ";
          cin>>remove;
          
          for (j = 0; j < i; j++)
          {
          if(remove == produto[j].codigo)
          {
          cout<<"Codigo do produto.......: "<<produto[j].codigo<<endl;
          cout<<"Nome do produto.......: "<<produto[j].nome<<endl;
          cout<<"Preco do produto.......: "<<produto[j].preco<<endl;	
          strcpy(produto[j].codigo, "");
          strcpy(produto[j].nome, "");
          produto[j].preco = 0.0;
		  cout<<"Produto removido com sucesso!"<<endl<<endl;   
		  }
	      }

		  break;
		 }

         case 3:
         {
           for(j = 0; j < i; j++)
           {
            cout<<"Nome do produto.......: "<<produto[j].nome<<endl;
            cout<<"Codigo do produto.......: "<<produto[j].codigo<<endl;
            cout<<"Preco do produto.......: "<<produto[j].preco<<endl<<endl;
           }
		 break;
         }

		 case 4:
	 	{   
          string busca;

			cout<<"Informe o codigo do produto: ";
            cin>>busca;

            for (j = 0;  j < i; j++)
            {
			if(busca == produto[j].codigo)
			{
			cout<<"Nome do produto.......: "<<produto[j].nome<<endl;
            cout<<"Preco do produto.......: "<<produto[j].preco<<endl<<endl;
            }
            }
		 break;
		}
         
         case 0:
         {
         exit;
         }
      }
    }
    while(opcao != 0);
return 0;
}










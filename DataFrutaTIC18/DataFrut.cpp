#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Data
{
	int dia, mes, ano;

public:
	static int compara(Data d1, Data d2)
	{
		if (d1.ano < d2.ano || (d1.ano == d2.ano && (d1.mes < d2.mes || (d1.mes == d2.mes && d1.dia < d2.dia))))
		{
			return -1;
		}
		else if (d1.ano == d2.ano && d1.mes == d2.mes && d1.dia == d2.dia)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}

	Data(int _dia, int _mes, int _ano)
	{
		dia = _dia;
		mes = _mes;
		ano = _ano;
	}
	string toString()

	{
		string ret = "";
		ret.append(to_string(dia));
		ret.append("/");
		ret.append(to_string(mes));
		ret.append("/");
		ret.append(to_string(ano));
		return ret;
	}
};

class Lista
{
public:
	virtual void entradaDeDados() = 0;
	virtual void mostraMediana() = 0;
	virtual void mostraMenor() = 0;
	virtual void mostraMaior() = 0;
	virtual void listarEmOrdem() = 0;
};

class ListaNomes : public Lista
{
	vector<string> lista;

public:
	void entradaDeDados()
	{

		int n;
		cout << "Quantos nomes serao incluidos? " << endl;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			string nome;
			cout << "Digite um nome: ";
			cin >> nome;
			lista.push_back(nome);
		}
		sort(lista.begin(), lista.end());
	}

	void mostraMediana()
	{
		if (lista.empty())
		{
			cout << "A lista de nome esta vazia." << endl;
		}
		else
		{
			if (lista.size() % 2 == 0)
			{
				cout << "A mediana da lista de nomes e: " << lista[lista.size() / 2 - 1] << endl;
			}
			else
			{
				cout << "A mediana da lista de nomes e: " << lista[lista.size() / 2] << endl;
			}
		}
	}

	void mostraMenor()
	{
		if (lista.empty())
		{
			cout << "A lista de nome esta vazia." << endl;
		}
		else
		{
			cout << "O primeiro nome alfabeticamente e: " << lista[0] << endl;
		}
	}
	void mostraMaior()
	{
		if (lista.empty())
		{
			cout << "A lista de nome esta vazia." << endl;
		}
		else
		{
			cout << "O ultimo nome alfabeticamente e: " << lista[lista.size() - 1] << endl;
		}
	}
	void listarEmOrdem()
	{
		if (lista.empty())
		{
			cout << "A lista de nome esta vazia." << endl;
		}
		else
		{
			cout << "A lista em ordem alfabetica "<< endl;
			for (const string& nome:lista){
			cout << nome << endl;
		}
		}
	}
};

class ListaDatas : public Lista

{
	vector<Data> lista;

public:
	void entradaDeDados()
	{
		int n;
		cout << "Quantas datas serao incluidas? " << endl;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			int dia, mes, ano;
			cout << endl
				 << "Digite uma data no formato (dia mes ano): " << endl;
			cin >> dia >> mes >> ano;
			Data data(dia, mes, ano);
			lista.push_back(data);
		}
		sort(lista.begin(), lista.end(), [](Data d1, Data d2)
			 { return Data::compara(d1, d2) == -1; });
	}

	void mostraMediana()
	{
		if (lista.empty())
		{
			cout << "A lista de datas esta vazia." << endl;
		}
		else
		{
			int meio = lista.size() / 2;
			if (lista.size() % 2 == 0)
			{
				cout << "A mediana da lista de datas e: " << lista[meio - 1].toString() << endl;
			}
			else
			{
				cout << "A mediana da lista de datas e: " << lista[meio].toString() << endl;
			}
		}
	}

	void mostraMenor()
	{
		if (lista.empty())
		{
			cout << "A lista de datas esta vazia." << endl;
		}
		else
		{
			cout << "A data mais antiga e: " << lista[0].toString() << endl;
		}
	}
	void mostraMaior()
	{
		if (lista.empty())
		{
			cout << "A lista de datas esta vazia." << endl;
		}
		else
		{
			int maior = lista.size() - 1;
			cout << "A data mais recente e: " << lista[maior].toString() << endl;
		}
	}
	void listarEmOrdem()
	{
			if (lista.empty()) {
            cout << "A lista de datas esta vazia." << endl;
        } else {
            cout << "Lista de datas em ordem:" << endl;
            for (Data& data : lista) {
                cout << data.toString() << endl;
            }
        }
    }

};

class ListaSalarios : public Lista
{
	vector<float> lista;

public:
	void entradaDeDados()
	{
		int n;
		float salario;
		cout << "Quantos salarios serao incluidos? " << endl;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cout << "Digite um salario: " << endl;
			cin >> salario;
			lista.push_back(salario);
		}
		sort(lista.begin(), lista.end());
	}

	void mostraMediana()
	{
		if (lista.empty())
		{
			cout << "A lista de salarios esta vazia." << endl;
		}
		else
		{
			if (lista.size() % 2 == 0)
			{
				cout << "A mediana da lista de salarios e: " << (lista[lista.size() / 2] + lista[lista.size() / 2 - 1]) / 2 << endl;
			}
			else
			{
				cout << "A mediana da lista de salarios e: " << lista[lista.size() / 2] << endl;
			}
		}
	}

	void mostraMenor()
	{
		if (lista.empty())
		{
			cout << "A lista de salarios esta vazia." << endl;
		}
		else
		{
			cout << "O menor salario e: " << lista[0] << endl;
		}
	}
	void mostraMaior()
	{
		if (lista.empty())
		{
			cout << "A lista de salarios esta vazia." << endl;
		}
		else
		{
			cout << "O maior salario e: " << lista[lista.size() - 1] << endl;
		}
	}
	void listarEmOrdem(){
		if (lista.empty()){
			cout << "A lista de salarios esta vazia" << endl;
		}
		else{
			cout << " Lista de salarios em ordem crescente" << endl;
			for (const float salario : lista){
				cout << salario << endl;
			}
		}
	}
};

class ListaIdades : public Lista
{
	vector<int> lista;
	

public:
	void entradaDeDados()
	{
		int n, idade;
		cout << "Quantas idades serao incluidas? " << endl;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cout << "Digite uma idade: " << endl;
			cin >> idade;
			lista.push_back(idade);
		}
		sort(lista.begin(), lista.end());
	}

	void mostraMediana()
	{
		if (lista.empty())
		{
			cout << "A lista de idade esta vazia." << endl;
		}
		else
		{
			if (lista.size() % 2 == 0)
			{
				cout << "A mediana da lista de idade e: " << (lista[lista.size() / 2] + lista[lista.size() / 2 - 1]) / 2 << endl;
			}
			else
			{
				cout << "A mediana da lista de idade e: " << lista[lista.size() / 2] << endl;
			}
		}
	}

	void mostraMenor()
	{
		if (lista.empty())
		{
			cout << "A lista de idade esta vazia." << endl;
		}
		else
		{
			cout << "A menor idade e: " << lista[0] << endl;
		}
	}
	void mostraMaior()
	{
		if (lista.empty())
		{
			cout << "A lista de idade esta vazia." << endl;
		}
		else
		{
			cout << "A maior idade e: " << lista[lista.size() - 1] << endl;
		}
	}
	void listarEmOrdem(){
		if (lista.empty()){
			cout << "A lista de idades esta vazia" << endl;
		}
		else{
			cout << " Lista de idade em ordem crescente" << endl;
			for (const int idade : lista){
				cout << idade << endl;
			}
		}
	}
};

int main()
{
	
	vector<Lista *> listaDeListas;

	ListaNomes listaNomes;
	listaNomes.entradaDeDados();
	listaDeListas.push_back(&listaNomes);

	ListaDatas listaDatas;
	listaDatas.entradaDeDados();
	listaDeListas.push_back(&listaDatas);

	ListaSalarios listaSalarios;
	listaSalarios.entradaDeDados();
	listaDeListas.push_back(&listaSalarios);

	ListaIdades listaIdades;
	listaIdades.entradaDeDados();
	listaDeListas.push_back(&listaIdades);

	for (Lista *l : listaDeListas)
	{
		l->mostraMediana();
		l->mostraMenor();
		l->mostraMaior();
		l->listarEmOrdem();
	}
}

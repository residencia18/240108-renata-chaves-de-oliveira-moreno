# Índice

1. [O que é uma classe em Java e qual é a diferença entre uma classe e um objeto?](#1-o-que-é-uma-classe-em-java-e-qual-é-a-diferença-entre-uma-classe-e-um-objeto)
2. [Como você declara uma variável em Java e quais são os tipos de dados primitivos mais comuns?](#2-como-você-declara-uma-variável-em-java-e-quais-são-os-tipos-de-dados-primitivos-mais-comuns)
3. [Explique o conceito de herança em Java e como você pode criar uma subclasse a partir de uma classe existente.](#3-explique-o-conceito-de-herança-em-java-e-como-você-pode-criar-uma-subclasse-a-partir-de-uma-classe-existente)
4. [Quando declaramos uma variável em Java, temos, na verdade, um ponteiro. Em C++ é diferente.](#4-quando-declaramos-uma-variável-em-java-temos-na-verdade-um-ponteiro-em-c-é-diferente)

---

# 1. O que é uma classe em Java e qual é a diferença entre uma classe e um objeto?

### Classe em Java:

Em Java, uma classe é uma estrutura que define o comportamento e os atributos de objetos. Ela serve como um modelo para a criação de objetos, encapsulando dados e métodos relacionados.

### Diferença entre Classe e Objeto:

- **Classe:** É a estrutura que define os atributos e métodos comuns a um conjunto de objetos.
- **Objeto:** É uma instância específica de uma classe, criada a partir do modelo fornecido pela classe.

### Exemplos em C++ e Java:

#### Java:

class Carro {

​ public:

​ string modelo;

​ int ano;

​ Carro(string modelo, int ano) : modelo(modelo), ano(ano) { }

};

---
# 2. Como você declara uma variável em Java e quais são os tipos de dados primitivos mais comuns?

## Declaração de Variável em Java:

Exemplo em Java:

// Declaração de variável em Java

int idade = 25;

// Tipos de dados primitivos comuns em Java

float altura = 1.75f;

boolean isEstudante = true;

char letra = 'A';

# Tipos de Dados Primitivos Comuns em Java:

1. **int:** Armazena números inteiros.
2. **double:** Armazena números de ponto flutuante de dupla precisão.
3. **boolean:** Armazena valores verdadeiro ou falso.
4. **char:** Armazena caracteres Unicode.
5. **String:** Armazena sequências de caracteres.

Estes são alguns dos tipos de dados primitivos mais comuns em Java, cada um projetado para armazenar diferentes tipos de valores. O uso de um tipo específico depende do contexto e da natureza dos dados que você está manipulando em seu programa.

# 3. Explique o conceito de herança em Java e como você pode criar uma subclasse a partir de uma classe existente.

## Conceito de Herança em Java:

Em Java, herança é um conceito fundamental que permite que uma classe (subclasse) herde atributos e métodos de outra classe (superclasse). A subclasse pode estender ou modificar o comportamento da superclasse.

#### Exemplo em Java:

Exemplo em Java:

// Classe base

class Animal {

​ void fazerSom() {

​ System.out.println("Barulho genérico de animal");

​ }

}

// Subclasse em Java

class Cachorro extends Animal {

​ void latir() {

​ System.out.println("Au au!");

​ }

}

Em C++, a herança é semelhante, mas a palavra-chave é : public ou : private.

Exemplo em C++:

// Classe base

class Animal {

​ public:

​ void fazerSom() {

​ cout << "Barulho genérico de animal" << endl;

​ }

};

// Subclasse em C++

class Cachorro : public Animal {

​ public:

​ void latir() {

​ cout << "Au au!" << endl;

​ }

};

# 4. Quando declaramos uma variável em Java, temos, na verdade, um ponteiro.Em C++ é diferente. Discorra sobre esse aspecto.

## Em Java:

Em Java, quando declaramos uma variável de um tipo de objeto (não um tipo primitivo), estamos, na verdade, criando uma referência para esse objeto. Essa referência age de forma semelhante a um ponteiro, pois aponta para a posição de memória onde o objeto está armazenado. No entanto, ao contrário de um ponteiro em C++, em Java, a manipulação direta de endereços de memória não é permitida. Exemplo:

Exemplo em Java:

// Declaração de variável de objeto em Java

Carro meuCarro;

meuCarro = new Carro("Fusca", 1970);

Em C++, as variáveis de objeto são instâncias reais dos objetos. Não há a mesma distinção entre referência e objeto como em Java. Em C++, você pode ter ponteiros que apontam para objetos, mas a semântica é diferente.

Exemplo em C++:

// Declaração e inicialização de objeto em C++

Carro meuCarro("Fusca", 1970);

// Declaração de ponteiro para objeto em C++

Carro* ponteiroCarro;

ponteiroCarro = &meuCarro;

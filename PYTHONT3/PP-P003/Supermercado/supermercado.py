# main.py

# Lista de produtos (dicionários)
produtos = []

def inserir_produto():
    codigo = input("Digite o código do produto (13 dígitos): ")
    while len(codigo) != 13 or not codigo.isdigit():
        print("Código inválido. Deve conter 13 dígitos numéricos.")
        codigo = input("Digite o código do produto (13 dígitos): ")

    nome = input("Digite o nome do produto (começando com letra maiúscula): ")
    while not nome[0].isupper():
        print("Nome inválido. Deve começar com uma letra maiúscula.")
        nome = input("Digite o nome do produto (começando com letra maiúscula): ")

    preco = input("Digite o preço do produto (com duas casas decimais): ")
    while not preco.replace('.', '', 1).isdigit():
        print("Preço inválido. Deve ser um número real com duas casas decimais.")
        preco = input("Digite o preço do produto (com duas casas decimais): ")

    produto = {
        'codigo': codigo,
        'nome': nome,
        'preco': float(preco)
    }

    produtos.append(produto)
    print("Produto inserido com sucesso!")

def excluir_produto():
    codigo = input("Digite o código do produto a ser excluído: ")
    for produto in produtos:
        if produto['codigo'] == codigo:
            produtos.remove(produto)
            print("Produto excluído com sucesso!")
            return
    print("Produto não encontrado.")

def listar_produtos():
    print("\nLista de produtos:")
    for produto in produtos:
        print(f"Código: {produto['codigo']}, Nome: {produto['nome']}, Preço: R${produto['preco']:.2f}")
    print()

def consultar_preco():
    codigo = input("Digite o código do produto para consultar o preço: ")
    for produto in produtos:
        if produto['codigo'] == codigo:
            print(f"O preço do produto {produto['nome']} é R${produto['preco']:.2f}")
            return
    print("Produto não encontrado.")

def menu():
    print("=== Sistema de Supermercado ===")
    while True:
        print("\nMenu de Opções:")
        print("1. Inserir novo produto")
        print("2. Excluir produto cadastrado")
        print("3. Listar todos os produtos")
        print("4. Consultar preço de um produto")
        print("5. Sair")

        opcao = input("Escolha uma opção (1-5): ")
        
        if opcao == '1':
            inserir_produto()
        elif opcao == '2':
            excluir_produto()
        elif opcao == '3':
            listar_produtos()
        elif opcao == '4':
            consultar_preco()
        elif opcao == '5':
            print("Saindo do programa. Até mais!")
            break
        else:
            print("Opção inválida. Escolha uma opção de 1 a 5.")

if __name__ == "__main__":
    menu()

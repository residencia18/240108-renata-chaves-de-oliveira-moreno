# empresa.py

# Função para reajustar o salário em 10%
def reajusta_dez_porcento(empregados):
    for empregado in empregados:
        empregado['salario'] *= 1.10  # Aumenta o salário em 10%

# Função para imprimir os dados dos empregados
def imprimir_dados(empregados):
    print("\nDados dos Empregados:")
    for empregado in empregados:
        print(f"Nome: {empregado['nome']} {empregado['sobrenome']}")
        print(f"Ano de Nascimento: {empregado['ano_nascimento']}")
        print(f"RG: {empregado['rg']}")
        print(f"Ano de Admissão: {empregado['ano_admissao']}")
        print(f"Salário: R${empregado['salario']:.2f}")
        print()

# Função principal para testar o reajuste de salário
def main():
    # Simula a leitura dos dados de um arquivo
    dados_arquivo = [
        {'nome': 'José', 'sobrenome': 'Silva', 'ano_nascimento': 1990, 'rg': '123456', 'ano_admissao': 2010, 'salario': 5000.00},
        {'nome': 'Antonieta', 'sobrenome': 'Souza', 'ano_nascimento': 1985, 'rg': '789012', 'ano_admissao': 2015, 'salario': 6000.00},
        # Adicione mais empregados conforme necessário
    ]

    # Lista para armazenar os dados dos empregados
    empregados = dados_arquivo

    # Imprime os dados antes do reajuste
    print("Antes do Reajuste:")
    imprimir_dados(empregados)

    # Aplica o reajuste de 10%
    reajusta_dez_porcento(empregados)

    # Imprime os dados após o reajuste
    print("Após o Reajuste:")
    imprimir_dados(empregados)

if __name__ == "__main__":
    main()

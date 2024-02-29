package energiaCoelho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Imovel> imoveis = new ArrayList<>();
    private static List<Fatura> faturas = new ArrayList<>();
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenuPrincipal();

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

                switch (opcao) {
                    case 1:
                        gerenciarClientes(scanner);
                        break;
                    case 2:
                        gerenciarImoveis(scanner);
                        break;
                    case 3:
                        gerenciarFaturas(scanner);
                        break;
                    case 4:
                        System.out.println("Saindo do programa. Obrigado!");
                        scanner.close(); // Fechar o scanner antes de sair
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
                scanner.nextLine(); // Limpar o buffer do scanner para evitar loop infinito
            }
        }
    }

    // Métodos auxiliares para gestão de clientes
    private static void gerenciarClientes(Scanner scanner) {
        while (true) {
            exibirMenuClientes();

            try {
                int opcaoCliente = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

                switch (opcaoCliente) {
                    case 1:
                        incluirCliente(scanner);
                        break;
                    case 2:
                        consultarCliente(scanner);
                        break;
                    case 3:
                        listarClientes();
                        break;
                    case 4:
                        excluirCliente(scanner);
                        break;
                    case 5:
                        alterarCliente(scanner);
                        break;
                    case 6:
                        return; // Voltar ao menu principal
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
                scanner.nextLine(); // Limpar o buffer do scanner para evitar loop infinito
            }
        }
    }

    private static void exibirMenuClientes() {
        System.out.println("========================");
        System.out.println("Menu Clientes:");
        System.out.println("========================");
        System.out.println("1. Incluir Cliente");
        System.out.println("2. Consultar Cliente");
        System.out.println("3. Listar Clientes");
        System.out.println("4. Excluir Cliente");
        System.out.println("5. Alterar Cliente");
        System.out.println("6. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void incluirCliente(Scanner scanner) {
        System.out.println("Incluir Cliente selecionado.");

        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();

        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.nextLine();

        Cliente novoCliente = new Cliente(cpf, nome);
        clientes.add(novoCliente);

        System.out.println("Cliente incluído com sucesso.");
    }

    private static void consultarCliente(Scanner scanner) {
        System.out.println("Consultar Cliente selecionado.");

        System.out.print("Informe o CPF do cliente a ser consultado: ");
        String cpf = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Cliente encontrado:");
                System.out.println(cliente);
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    private static void listarClientes() {
        System.out.println("Listar Clientes selecionado.");

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Clientes cadastrados:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void excluirCliente(Scanner scanner) {
        System.out.println("Excluir Cliente selecionado.");

        System.out.print("Informe o CPF do cliente a ser excluído: ");
        String cpf = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clientes.remove(cliente);
                System.out.println("Cliente excluído com sucesso.");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    private static void alterarCliente(Scanner scanner) {
        System.out.println("Alterar Cliente selecionado.");

        System.out.print("Informe o CPF do cliente a ser alterado: ");
        String cpf = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.print("Informe o novo nome do cliente: ");
                String novoNome = scanner.nextLine();
                cliente.setNome(novoNome);
                System.out.println("Nome do cliente atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    // Métodos auxiliares para gestão de imóveis
    private static void gerenciarImoveis(Scanner scanner) {
        while (true) {
            exibirMenuImoveis();

            try {
                int opcaoImovel = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

                switch (opcaoImovel) {
                    case 1:
                        incluirImovel(scanner);
                        break;
                    case 2:
                        consultarImovel(scanner);
                        break;
                    case 3:
                        listarImoveis();
                        break;
                    case 4:
                        excluirImovel(scanner);
                        break;
                    case 5:
                        alterarImovel(scanner);
                        break;
                    case 6:
                        return; // Voltar ao menu principal
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
                scanner.nextLine(); // Limpar o buffer do scanner para evitar loop infinito
            }
        }
    }

    private static void exibirMenuImoveis() {
        System.out.println("========================");
        System.out.println("Menu Imóveis:");
        System.out.println("========================");
        System.out.println("1. Incluir Imóvel");
        System.out.println("2. Consultar Imóvel");
        System.out.println("3. Listar Imóveis");
        System.out.println("4. Excluir Imóvel");
        System.out.println("5. Alterar Imóvel");
        System.out.println("6. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void incluirImovel(Scanner scanner) {
        System.out.println("Incluir Imóvel selecionado.");

        System.out.print("Informe o endereço do imóvel: ");
        String endereco = scanner.nextLine();

        // Aqui você pode adicionar lógica para obter outros detalhes do imóvel, como leituras, etc.

        Imovel novoImovel = new Imovel(endereco);
        imoveis.add(novoImovel);

        System.out.println("Imóvel incluído com sucesso.");
    }

    private static void consultarImovel(Scanner scanner) {
        System.out.println("Consultar Imóvel selecionado.");

        System.out.print("Informe o endereço do imóvel a ser consultado: ");
        String endereco = scanner.nextLine();

        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equals(endereco)) {
                System.out.println("Imóvel encontrado:");
                System.out.println(imovel);
                return;
            }
        }

        System.out.println("Imóvel não encontrado.");
    }

    private static void listarImoveis() {
        System.out.println("Listar Imóveis selecionado.");

        if (imoveis.isEmpty()) {
            System.out.println("Não há imóveis cadastrados.");
        } else {
            System.out.println("Imóveis cadastrados:");
            for (Imovel imovel : imoveis) {
                System.out.println(imovel);
            }
        }
    }

    private static void excluirImovel(Scanner scanner) {
        System.out.println("Excluir Imóvel selecionado.");

        System.out.print("Informe o endereço do imóvel a ser excluído: ");
        String endereco = scanner.nextLine();

        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equals(endereco)) {
                imoveis.remove(imovel);
                System.out.println("Imóvel excluído com sucesso.");
                return;
            }
        }

        System.out.println("Imóvel não encontrado.");
    }

    private static void alterarImovel(Scanner scanner) {
        System.out.println("Alterar Imóvel selecionado.");

        System.out.print("Informe o endereço do imóvel a ser alterado: ");
        String endereco = scanner.nextLine();

        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equals(endereco)) {
                System.out.print("Informe o novo endereço do imóvel: ");
                String novoEndereco = scanner.nextLine();
                imovel.setEndereco(novoEndereco);
                System.out.println("Endereço do imóvel atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Imóvel não encontrado.");
    }

    // Métodos auxiliares para gestão de faturas
    private static void gerenciarFaturas(Scanner scanner) {
        while (true) {
            exibirMenuFaturas();

            try {
                int opcaoFatura = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

                switch (opcaoFatura) {
                    case 1:
                        incluirFatura(scanner);
                        break;
                    case 2:
                        consultarFatura(scanner);
                        break;
                    case 3:
                        listarFaturas();
                        break;
                    case 4:
                        excluirFatura(scanner);
                        break;
                    case 5:
                        alterarFatura(scanner);
                        break;
                    case 6:
                        return; // Voltar ao menu principal
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
                scanner.nextLine(); // Limpar o buffer do scanner para evitar loop infinito
            }
        }
    }

    private static void alterarFatura(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

    private static void exibirMenuFaturas() {
        System.out.println("========================");
        System.out.println("Menu Faturas:");
        System.out.println("========================");
        System.out.println("1. Incluir Fatura");
        System.out.println("2. Listar Todas as Faturas");
        System.out.println("3. Listar Faturas em Aberto");
        System.out.println("4. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }


	private static void incluirFatura(Scanner scanner) {
	    System.out.println("Incluir Fatura selecionado.");

	    // Solicitar informações necessárias para criar a fatura
	    System.out.print("Informe o CPF do cliente: ");
	    String cpfCliente = scanner.nextLine();

	    System.out.print("Informe o endereço do imóvel: ");
	    String enderecoImovel = scanner.nextLine();

	    // Encontrar o cliente pelo CPF
	    Cliente cliente = encontrarClientePorCPF(cpfCliente);
	    if (cliente == null) {
	        System.out.println("Cliente não encontrado. Não é possível criar a fatura.");
	        return;
	    }

	    // Encontrar o imóvel pelo endereço
	    Imovel imovel = encontrarImovelPorEndereco(enderecoImovel);
	    if (imovel == null) {
	        System.out.println("Imóvel não encontrado. Não é possível criar a fatura.");
	        return;
	    }

	    // Calcular o valor da fatura com base nas leituras do imóvel
	    double valor = calcularValorFatura(imovel);

	    // Criar uma nova instância de Fatura e adicionar à lista de faturas
	    Fatura novaFatura = new Fatura(cpfCliente, enderecoImovel, valor);
	    faturas.add(novaFatura);

	    System.out.println("Fatura incluída com sucesso.");
	}

	private static Cliente encontrarClientePorCPF(String cpfCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Imovel encontrarImovelPorEndereco(String enderecoImovel) {
		// TODO Auto-generated method stub
		return null;
	}

	private static double calcularValorFatura(Imovel imovel) {
	    // Implemente a lógica para calcular o valor da fatura com base nas leituras do imóvel
	    // Neste exemplo, vamos assumir um cálculo simples: valor = (últimaLeitura - penultimaLeitura) * custoPorKWh
	    double custoPorKWh = 10.0; // Exemplo de custo por kWh
	    return (imovel.getUltimaLeitura() - imovel.getPenultimaLeitura()) * custoPorKWh;
	}


	private static void consultarFatura(Scanner scanner) {
	    System.out.println("Consultar Fatura selecionado.");

	    System.out.print("Informe o CPF do cliente: ");
	    String cpfCliente = scanner.nextLine();

	    System.out.print("Informe o endereço do imóvel: ");
	    String enderecoImovel = scanner.nextLine();

	    for (Fatura fatura : faturas) {
	        if (fatura.getCpfCliente().equals(cpfCliente) && fatura.getEnderecoImovel().equals(enderecoImovel)) {
	            System.out.println("Fatura encontrada:");
	            System.out.println(fatura);
	            return;
	        }
	    }

	    System.out.println("Fatura não encontrada.");
	}

	private static void listarFaturas() {
	    System.out.println("Listar Faturas selecionado.");

	    if (faturas.isEmpty()) {
	        System.out.println("Não há faturas cadastradas.");
	    } else {
	        System.out.println("Faturas cadastradas:");
	        for (Fatura fatura : faturas) {
	            System.out.println(fatura);
	        }
	    }
	}
	
	private static void listarFaturasEmAberto() {
	    System.out.println("Listar Faturas em Aberto selecionado.");

	    if (faturas.isEmpty()) {
	        System.out.println("Não há faturas cadastradas.");
	    } else {
	        System.out.println("Faturas em aberto:");

	        for (Fatura fatura : faturas) {
	            if (!fatura.isQuitado()) {
	                System.out.println(fatura);
	            }
	        }
	    }
	}



	private static void excluirFatura(Scanner scanner) {
	    System.out.println("Excluir Fatura selecionado.");

	    System.out.print("Informe o CPF do cliente: ");
	    String cpfCliente = scanner.nextLine();

	    System.out.print("Informe o endereço do imóvel: ");
	    String enderecoImovel = scanner.nextLine();

	    for (Fatura fatura : faturas) {
	        if (fatura.getCpfCliente().equals(cpfCliente) && fatura.getEnderecoImovel().equals(enderecoImovel)) {
	            faturas.remove(fatura);
	            System.out.println("Fatura excluída com sucesso.");
	            return;
	        }
	    }

	    System.out.println("Fatura não encontrada.");
	}

	private static void alterarFatura1(Scanner scanner) {
	    System.out.println("Alterar Fatura selecionado.");

	    System.out.print("Informe o CPF do cliente: ");
	    String cpfCliente = scanner.nextLine();

	    System.out.print("Informe o endereço do imóvel: ");
	    String enderecoImovel = scanner.nextLine();

	    for (Fatura fatura : faturas) {
	        if (fatura.getCpfCliente().equals(cpfCliente) && fatura.getEnderecoImovel().equals(enderecoImovel)) {
	            System.out.print("Informe o novo valor da fatura: ");
	            double novoValor = scanner.nextDouble();
	            fatura.setValor(novoValor);
	            System.out.println("Valor da fatura atualizado com sucesso.");
	            return;
	        }
	    }

	    System.out.println("Fatura não encontrada.");
	}



    private static void exibirMenuPrincipal() {
        System.out.println("========================");
        System.out.println("Menu Principal:");
        System.out.println("========================");
        System.out.println("1. Gestão de Clientes");
        System.out.println("2. Gestão de Imóveis");
        System.out.println("3. Gestão de Faturas");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }
}

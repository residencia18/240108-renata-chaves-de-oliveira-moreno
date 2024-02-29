package ContaBancaria;

public class TesteContaBancaria {

    public static void main(String[] args) {
        // Exemplo de uso da classe ContaBancaria
        ContaBancaria conta1 = new ContaBancaria("123.456.789-00");
        ContaBancaria conta2 = new ContaBancaria("987.654.321-00");

        conta1.depositar(1000);
        conta1.sacar(500);

        conta1.transferir(conta2, 200);

        System.out.println("Teste concluído. Sem exibir saldos.");
    }
}

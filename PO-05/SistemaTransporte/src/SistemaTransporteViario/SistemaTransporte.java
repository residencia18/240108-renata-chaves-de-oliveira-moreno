package SistemaTransporteViario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaTransporte {
    public static void main(String[] args) {
        // Exemplo de utilização das classes
        Veiculo veiculo = new Veiculo("ABC123", "Ônibus Modelo X");
        Motorista motorista = new Motorista("João Silva", "123456");
        Cobrador cobrador = new Cobrador("Maria Oliveira");
        Passageiro passageiro = new Passageiro("Carlos Santos", "CartaoEstudante");
        PontoDeParada pontoDeParada = new PontoDeParada("Ponto A");

        Trecho trecho = new Trecho(pontoDeParada, pontoDeParada, 30);
        List<Trecho> trechos = new ArrayList<>();
        trechos.add(trecho);

        Trajeto trajeto = new Trajeto(trechos);
        Date inicio = new Date();
        Date fim = new Date();

        Jornada jornada = new Jornada(motorista, cobrador, veiculo, trajeto, inicio, fim);
        PassageiroEmbarque passageiroEmbarque = new PassageiroEmbarque(passageiro, pontoDeParada.getNome(), passageiro.getTipoCartao(), new Date());

        // Exibir informações (pode ser substituído por lógica de apresentação de interface gráfica ou console)
        System.out.println("Sistema de Transporte Viário");
        System.out.println("======================================");
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Motorista: " + motorista.getNome());
        System.out.println("Cobrador: " + cobrador.getNome());
        System.out.println(trajeto);
        System.out.println("Jornada Início: " + inicio);
        System.out.println("Jornada Fim: " + fim);
        System.out.println("Passageiro: " + passageiro.getNome());
        System.out.println("Ponto de Parada: " + pontoDeParada.getNome());
        System.out.println("Passageiro Embarque: " + passageiroEmbarque.getPontoEmbarque());
    }
}

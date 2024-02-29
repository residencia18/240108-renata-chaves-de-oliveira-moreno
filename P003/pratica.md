# DESENVOLVER CONCEITOS INICIAIS DE PROGRAMAÇÃO EM JAVA - RESPOSTAS

## 1. Exceções em Java e seu Propósito

Em Java, uma exceção é um evento que ocorre durante a execução do programa, interrompendo o fluxo normal de instruções. O propósito das exceções é lidar com erros e condições excepcionais de forma organizada.

## 2. Exceções Verificadas e Não Verificadas

- **Exceções Verificadas:** Obrigam o tratamento ou lançamento e derivam de `Exception`, como `IOException`.
- **Exceções Não Verificadas:** Não exigem tratamento obrigatório e derivam de `RuntimeException`, como `NullPointerException`.

## 3. Lidando com Exceções em Java

Palavras-chave como `try`, `catch`, `finally`, e `throw` são usadas para lidar com exceções. O bloco `try-catch` é essencial para capturar e tratar exceções, melhorando a robustez do programa.

```java
try {
    // Código que pode lançar uma exceção
} catch (TipoDeExcecao e) {
    // Tratamento da exceção
} finally {
    // Código a ser executado sempre, com ou sem exceção
}

```
## 4. Bloco "try-catch" em Detalhes
O bloco try-catch envolve o código que pode gerar exceções, permitindo o tratamento adequado. É crucial para prevenir interrupções abruptas na execução do programa.

## 5. Exceções Personalizadas em Java

Ao desenvolver software mais robusto e compreensível, você pode criar suas próprias exceções personalizadas. Estas são classes que estendem `Exception` e são usadas para representar erros específicos do seu domínio de aplicação.

```java
public class MinhaExcecaoPersonalizada extends Exception {
    public MinhaExcecaoPersonalizada(String mensagem) {
        super(mensagem);
    }
}

// Uso
try {
    throw new MinhaExcecaoPersonalizada("Isso é um erro específico!");
} catch (MinhaExcecaoPersonalizada e) {
    // Tratamento da exceção personalizada
    System.out.println(e.getMessage());
}

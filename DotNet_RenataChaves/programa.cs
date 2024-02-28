using System;
using System.Numerics;

class Program
{
    static void Main()
    {
        // Chame as funções correspondentes a cada problema
        TiposDados();
        ConversaoTiposDados();
        OperadoresAritmeticos();
        OperadoresComparacao();
        OperadoresIgualdade();
        OperadoresLogicos();
        DesafioMisturaOperadores();
    }

    #region 2. Tipos de Dados:

    static void TiposDados()
    {
        Console.WriteLine("Solução para Tipos de Dados...");

        // sbyte
        sbyte mySByte = 42;
        Console.WriteLine(mySByte);

        // byte
        byte myByte = 200;
        Console.WriteLine(myByte);

        // short
        short myShort = 30000;
        Console.WriteLine(myShort);

        // ushort
        ushort myUShort = 60000;
        Console.WriteLine(myUShort);

        // int
        int myInt = 2000000000;
        Console.WriteLine(myInt);

        // uint
        uint myUInt = 4000000000;
        Console.WriteLine(myUInt);

        // long
        long myLong = 9000000000000000000;
        Console.WriteLine(myLong);

        // ulong
        ulong myULong = 18000000000000000000;
        Console.WriteLine(myULong);

        // BigInteger
        BigInteger myBigInteger = BigInteger.Parse("1234567890123456789012345678901234567890");
        Console.WriteLine(myBigInteger);
    }

    #endregion

    #region 3. Conversão de Tipos de Dados:

    static void ConversaoTiposDados()
    {
        Console.WriteLine("Solução para Conversão de Tipos de Dados...");

        // Exemplo de uma conversão direta onde a parte fracionária seria perdida:
        double exDouble = 10.75;
        int exInt = (int)exDouble;
        Console.WriteLine(exInt);

        // Exemplo de uma conversão onde o inteiro vai ser arredondado de acordo com a parte fracionária:
        double exDouble2 = 10.75;
        int exInt2 = (int)Math.Round(exDouble2);
        Console.WriteLine(exInt2);

        // Tem como controlar como o arrendondamento vai ser feito, por exemplo:
        // Arredondando para baixo
        double exDouble3 = 10.75;
        int exInt3 = (int)Math.Floor(exDouble3);
        Console.WriteLine(exInt3);

        // Arredondando para cima
        double exDouble4 = 10.75;
        int exInt4 = (int)Math.Ceiling(exDouble4);
        Console.WriteLine(exInt4);
    }

    #endregion

    #region 4. Operadores Aritméticos:

    static void OperadoresAritmeticos()
    {
        Console.WriteLine("Solução para Operadores Aritméticos...");

        int x = 10;
        int y = 3;

        // Adição:
        Console.WriteLine($"Adição: {x + y}");

        // Subtração:
        Console.WriteLine($"Subtração: {x - y}");

        // Multiplicação:
        Console.WriteLine($"Multiplicação: {x * y}");

        // Divisão:
        Console.WriteLine($"Divisão: {x / y}");
    }

    #endregion

    #region 5. Operadores de Comparação:

    static void OperadoresComparacao()
    {
        Console.WriteLine("Solução para Operadores de Comparação...");

        int a = 5;
        int b = 8;

        string resultado5 = a > b ? "a é maior que b" : "a não é maior que b";
        Console.WriteLine(resultado5);
    }

    #endregion

    #region 6. Operadores de Igualdade:

    static void OperadoresIgualdade()
    {
        Console.WriteLine("Solução para Operadores de Igualdade...");

        string str1 = "Hello";
        string str2 = "World";

        string resultado6 = str1 == str2 ? "str1 é igual a str2" : "str1 é diferente da str2";
        Console.WriteLine(resultado6);
    }

    #endregion

    #region 7. Operadores Lógicos:

    static void OperadoresLogicos()
    {
        Console.WriteLine("Solução para Operadores Lógicos...");

        bool condicao1 = true;
        bool condicao2 = false;

        string resultado7 = condicao1 && condicao2 == true ? "condicao1 e condicao2 são verdadeiras" : "uma das condições ou as duas são falsas";
        Console.WriteLine(resultado7);
    }

    #endregion

    #region 8. Desafio de Mistura de Operadores:

    static void DesafioMisturaOperadores()
    {
        Console.WriteLine("Solução para o Desafio de Mistura de Operadores...");

        int num1 = 7;
        int num2 = 3;
        int num3 = 10;

        string resultado8 = num1 > num2 ? "num1 é maior que o num2" : "num1 não é maior que o num2";
        string resultado9 = num3 == num1 + num2 ? "num3 é igual a soma do num1 com o num2" : "num3 não é igual a soma do num1 com o num2";

        Console.WriteLine(resultado8);
        Console.WriteLine

}
#endregion


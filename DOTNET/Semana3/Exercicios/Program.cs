
using System;

class Program
{
    #region Função CriarTuplaNomeIdade
    static Tuple<string, int> CriarTuplaNomeIdade(string nome, int idade)
    {
        return Tuple.Create(nome, idade);
    }
    #endregion

    #region Método Main
    static void Main()
    {
        // Chamando a função com diferentes valores
        var resultado1 = CriarTuplaNomeIdade("João", 25);
        var resultado2 = CriarTuplaNomeIdade("Maria", 30);
        var resultado3 = CriarTuplaNomeIdade("Carlos", 22);

        // Exibindo os resultados
        Console.WriteLine(resultado1);
        Console.WriteLine(resultado2);
        Console.WriteLine(resultado3);
    }
    #endregion
}


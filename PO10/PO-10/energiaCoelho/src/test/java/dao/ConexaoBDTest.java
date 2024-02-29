package dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class ConexaoBDTest {

    @Test
    public void testarConexao() {
        try {
            Connection conexao = ConexaoBD.getConnection();
            assertNotNull(conexao); 
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            conexao.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

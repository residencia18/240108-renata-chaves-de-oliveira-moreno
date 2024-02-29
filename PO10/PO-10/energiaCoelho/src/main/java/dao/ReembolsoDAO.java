package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import energiaCoelho.Reembolso;

public class ReembolsoDAO {
    public void adicionarReembolso(Reembolso reembolso) {
        String sql = "INSERT INTO Reembolso (valor, data, descricao, id_funcionario) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDouble(1, reembolso.getValor());
            stmt.setDate(2, new java.sql.Date(reembolso.getData().getTime()));
            stmt.setString(3, reembolso.getDescricao());
            stmt.setInt(4, reembolso.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

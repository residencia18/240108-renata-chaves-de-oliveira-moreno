package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import energiaCoelho.Pagamento;
import util.ConexaoBD;

public class PagamentoDAO {
    private Connection conexao;

    public PagamentoDAO() {
        this.conexao = ConexaoBD.getConnection();
    }

    public void adicionarPagamento(Pagamento pagamento) {
        String sql = "INSERT INTO Pagamento (valor, data, descricao, id_cliente) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, pagamento.getValor());
            stmt.setDate(2, new java.sql.Date(pagamento.getData().getTime()));
            stmt.setString(3, pagamento.getDescricao());
            stmt.setInt(4, pagamento.getIdCliente());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos para listar, atualizar e excluir pagamentos
}

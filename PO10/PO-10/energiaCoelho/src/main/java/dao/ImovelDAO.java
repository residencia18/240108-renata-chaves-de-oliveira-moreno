package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Imovel;
import util.ConexaoBD;

public class ImovelDAO {
    private Connection conexao;

    public ImovelDAO() {
        this.conexao = ConexaoBD.getConnection();
    }

    public void adicionarImovel(Imovel imovel) {
        String sql = "INSERT INTO Imovel (endereco) VALUES (?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, imovel.getEndereco());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Imovel> listarImoveis() {
        String sql = "SELECT * FROM Imovel";
        List<Imovel> imoveis = new ArrayList<>();

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setId(rs.getInt("id"));
                imovel.setEndereco(rs.getString("endereco"));
                imoveis.add(imovel);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return imoveis;
    }

    // Métodos para atualizar, buscar e excluir imóveis
}

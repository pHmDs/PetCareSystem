package petcaresystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // INSERT — salva um novo cliente
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, telefone) VALUES (?, ?, ?)";
        try (Connection con = ConexaoMySQL.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cliente: " + e.getMessage(), e);
        }
    }

    // SELECT — lista todos os clientes
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection con = ConexaoMySQL.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"));
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage(), e);
        }
        return lista;
    }
}
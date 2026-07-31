package petcaresystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    // INSERT — a consulta guarda o id do pet (chave estrangeira)
    public void inserir(Consulta consulta) {
        String sql = "INSERT INTO consulta (data, valor, id_pet) VALUES (?, ?, ?)";
        try (Connection con = ConexaoMySQL.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, consulta.getData());
            stmt.setDouble(2, consulta.getValor());
            stmt.setInt(3, consulta.getPet().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir consulta: " + e.getMessage(), e);
        }
    }

    // SELECT — traz a consulta com pet e dono (dois JOINs encadeados)
    public List<Consulta> listar() {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT co.id, co.data, co.valor, "
                   + "p.id AS pid, p.nome AS pnome, p.especie, "
                   + "c.id AS cid, c.nome AS cnome, c.cpf, c.telefone "
                   + "FROM consulta co "
                   + "JOIN pet p ON co.id_pet = p.id "
                   + "JOIN cliente c ON p.id_cliente = c.id";
        try (Connection con = ConexaoMySQL.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente dono = new Cliente(
                        rs.getInt("cid"), rs.getString("cnome"),
                        rs.getString("cpf"), rs.getString("telefone"));
                Pet pet = new Pet(
                        rs.getInt("pid"), rs.getString("pnome"),
                        rs.getString("especie"), dono);
                Consulta co = new Consulta(
                        rs.getInt("id"), rs.getString("data"),
                        rs.getDouble("valor"), pet);
                lista.add(co);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar consultas: " + e.getMessage(), e);
        }
        return lista;
    }
}
package petcaresystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

    // INSERT — o pet guarda o id do dono (chave estrangeira)
    public void inserir(Pet pet) {
        String sql = "INSERT INTO pet (nome, especie, id_cliente) VALUES (?, ?, ?)";
        try (Connection con = ConexaoMySQL.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getEspecie());
            stmt.setInt(3, pet.getDono().getId());   // RN01: pet vinculado a um cliente
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir pet: " + e.getMessage(), e);
        }
    }

    // SELECT — traz o pet já com os dados do dono (JOIN com cliente)
    public List<Pet> listar() {
        List<Pet> lista = new ArrayList<>();
        String sql = "SELECT p.id, p.nome, p.especie, "
                   + "c.id AS cid, c.nome AS cnome, c.cpf, c.telefone "
                   + "FROM pet p "
                   + "JOIN cliente c ON p.id_cliente = c.id";
        try (Connection con = ConexaoMySQL.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente dono = new Cliente(
                        rs.getInt("cid"),
                        rs.getString("cnome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"));
                Pet p = new Pet(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        dono);
                lista.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pets: " + e.getMessage(), e);
        }
        return lista;
    }
}

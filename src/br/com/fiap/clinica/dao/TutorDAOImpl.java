package br.com.fiap.clinica.dao;

import br.com.fiap.clinica.model.Tutor;
import br.com.fiap.clinica.util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorDAOImpl implements TutorDAO {
    public boolean incluirTutor(Tutor tutor) {
        String sql = "INSERT INTO tutor (nome, email, especialidade, senha, ativo) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            // Definir os valores dos parâmetros na consulta SQL
            stmt.setString(1, tutor.getNome());
            stmt.setString(2, tutor.getEmail());
            stmt.setString(3, tutor.getEspecialidade());
            stmt.setString(4, tutor.getSenha());
            stmt.setBoolean(5, tutor.isAtivo());

            // Executar a instrução SQL de inserção
            int linhasAfetadas = stmt.executeUpdate();

            // Retorna true se a inserção foi bem-sucedida (pelo menos uma linha foi afetada)
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tutor buscarPorId(int id) {
        String sql = "SELECT * FROM tutor WHERE id = ?";
        Tutor tutor = null;

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                tutor = new Tutor();
                tutor.setId(resultSet.getInt("id"));
                tutor.setNome(resultSet.getString("nome"));
                tutor.setEmail(resultSet.getString("email"));
                tutor.setEspecialidade(resultSet.getString("especialidade"));
                tutor.setSenha(resultSet.getString("senha"));
                tutor.setAtivo(resultSet.getBoolean("ativo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tutor;
    }

    @Override
    public boolean atualizarTutor(Tutor tutor) {
        String sql = "UPDATE tutor SET nome = ?, email = ?, especialidade = ?, senha = ?, ativo = ? WHERE id = ?";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, tutor.getNome());
            stmt.setString(2, tutor.getEmail());
            stmt.setString(3, tutor.getEspecialidade());
            stmt.setString(4, tutor.getSenha());
            stmt.setBoolean(5, tutor.isAtivo());
            stmt.setInt(6, tutor.getId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se a atualização for bem-sucedida

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletarTutor(int id) {
        String sql = "DELETE FROM tutor WHERE id = ?";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se a exclusão for bem-sucedida

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Tutor> listarTodos() {
        String sql = "SELECT * FROM tutor";
        List<Tutor> listaTutores = new ArrayList<>();

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Tutor tutor = new Tutor();
                tutor.setId(resultSet.getInt("id"));
                tutor.setNome(resultSet.getString("nome"));
                tutor.setEmail(resultSet.getString("email"));
                tutor.setEspecialidade(resultSet.getString("especialidade"));
                tutor.setSenha(resultSet.getString("senha"));
                tutor.setAtivo(resultSet.getBoolean("ativo"));

                listaTutores.add(tutor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaTutores;
    }
}

package br.com.fiap.clinica.dao;

import br.com.fiap.clinica.model.Residente;
import br.com.fiap.clinica.util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResidenteDAOImpl implements ResidenteDAO{
    public ResidenteDAOImpl() {

    }

    @Override
    public boolean incluirResidente(Residente residente) {

        String sql = "INSERT INTO residente (nome, email, data_nascimento, ano_residencia, senha, ativo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            // Definir os parâmetros na ordem correta:
            stmt.setString(1, residente.getNome());                // nome é String
            stmt.setString(2, residente.getEmail());               // email é String
            stmt.setString(3, residente.getDataNascimento());      // data_nascimento é String
            stmt.setInt(4, residente.getAnoResidencia());          // ano_residencia é int
            stmt.setString(5, residente.getSenha());               // senha é String
            stmt.setBoolean(6, residente.isAtivo());               // ativo é boolean

            // Executar a consulta SQL
            int linhasAfetadas = stmt.executeUpdate();

            // Retorna true se a inserção for bem-sucedida
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Residente buscarPorId(int id) {
        String sql = "SELECT * FROM residente WHERE id = ?";
        Residente residente = null;

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                residente = new Residente();
                residente.setId(resultSet.getInt("id"));
                residente.setNome(resultSet.getString("nome"));
                residente.setEmail(resultSet.getString("email"));
                residente.setDataNascimento(resultSet.getString("data_nascimento"));
                residente.setAnoResidencia(resultSet.getInt("ano_residencia"));
                residente.setSenha(resultSet.getString("senha"));
                residente.setAtivo(resultSet.getBoolean("ativo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return residente;
    }

    @Override
    public boolean atualizarResidente(Residente residente) {
        String sql = "UPDATE residente SET nome = ?, email = ?, data_nascimento = ?, ano_residencia = ?, senha = ?, ativo = ? WHERE id = ?";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, residente.getNome());
            stmt.setString(2, residente.getEmail());
            stmt.setString(3, residente.getDataNascimento());
            stmt.setInt(4, residente.getAnoResidencia());
            stmt.setString(5, residente.getSenha());
            stmt.setBoolean(6, residente.isAtivo());
            stmt.setInt(7, residente.getId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se a atualização for bem-sucedida

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletarResidente(int id) {
        String sql = "DELETE FROM residente WHERE id = ?";

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
    public List<Residente> listarTodosResidentes() {
        String sql = "SELECT * FROM residente";
        List<Residente> listaResidentes = new ArrayList<>();

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Residente residente = new Residente();
                residente.setId(resultSet.getInt("id"));
                residente.setNome(resultSet.getString("nome"));
                residente.setEmail(resultSet.getString("email"));
                residente.setDataNascimento(resultSet.getString("data_nascimento"));
                residente.setAnoResidencia(resultSet.getInt("ano_residencia"));
                residente.setSenha(resultSet.getString("senha"));
                residente.setAtivo(resultSet.getBoolean("ativo"));

                listaResidentes.add(residente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaResidentes;
    }
}

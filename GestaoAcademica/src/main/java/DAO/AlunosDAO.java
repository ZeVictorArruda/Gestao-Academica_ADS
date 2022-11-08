/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import bin.Alunos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionFactory;

/**
 *
 * @author mathe
 */
public class AlunosDAO implements DAO<Alunos> {

    @Override
    public Optional<Alunos> get(long id) {
        //Problemas com a implementação deste metodo. Tentarei novamente outra hora
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alunos> getAll() {
        String sql = "SELECT * FROM alunos";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Alunos> alunosList = new ArrayList<Alunos>();
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Alunos alunos = new Alunos();
                alunos.setId_Aluno(resultSet.getInt("id_Aluno"));
                alunos.setNome(resultSet.getString("Nome"));
                alunos.setEndereco(resultSet.getString("endereco"));
                alunos.setEmail_Aluno(resultSet.getString("email_Aluno"));
                alunos.setCelular(resultSet.getString("celular"));
                alunos.setTelefone(resultSet.getString("telefone"));
                alunosList.add(alunos);
            }
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao Listar os alunos "
                        + ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(AlunosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            ConnectionFactory.closeConnection(con, statement, resultSet);
        }
        return alunosList;
    }

    @Override
    public void save(Alunos alunos) {
        String sql = "INSERT INTO alunos (nome,endereco,email_Aluno,celular,telefone) VALUES (?,?,?,?,?)";
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, alunos.getNome());
            statement.setString(2, alunos.getEndereco());
            statement.setString(3, alunos.getEmail_Aluno());
            statement.setString(4, alunos.getCelular());
            statement.setString(5, alunos.getTelefone());
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar Aluno "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

    @Override
    public void update(Alunos t, String[] params) {
        //duvidas em relação ao update
    }

    @Override
    public void delete(Alunos alunos) {
        String sql = "DELETE FROM alunos WHERE id_aluno = ?";

        Connection con = null;

        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            ConnectionFactory.getConnection();
            statement.setInt(1, alunos.getId_Aluno());
            statement.execute();
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao deletar o aluno "
                        + ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(AlunosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

}

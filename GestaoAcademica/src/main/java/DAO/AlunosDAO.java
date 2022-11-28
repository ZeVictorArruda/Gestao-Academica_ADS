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
        String sql = "SELECT * FROM alunos WHERE id_Aluno = " + id;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
         Alunos alunos = new Alunos();
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
           
            alunos.setId_Aluno(resultSet.getInt("id_Aluno"));
            alunos.setNome(resultSet.getString("Nome"));
            alunos.setEndereco(resultSet.getString("endereco"));
            alunos.setEmail_Aluno(resultSet.getString("email_Aluno"));
            alunos.setCelular(resultSet.getString("celular"));
            alunos.setTelefone(resultSet.getString("telefone"));

        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao procurar o aluno "
                        + ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(AlunosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            ConnectionFactory.closeConnection(con, statement, resultSet);
        }
        return Optional.of(alunos);
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
                alunos.setId_Turma(resultSet.getInt("id_Turma"));
                alunos.setId_Curso(resultSet.getInt("id_Curso"));
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
        String sql = "INSERT INTO alunos (nome,endereco,email_Aluno,celular,"
                + "telefone,id_Turma,id_Curso) VALUES (?,?,?,?,?,?,?)";
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
            statement.setInt(6, alunos.getId_Turma());
            statement.setInt(7, alunos.getId_Curso());
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar Aluno "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

    /* (non-Javadoc)
     * @see DAO.DAO#update(java.lang.Object, java.lang.String[])
     */
    @Override
    public void update(Alunos alunos, String[] params) {
        String sql = "UPDATE alunos SET nome = ?, endereco = ?, email_Aluno = ?, "
        + "celular = ?, telefone = ?, id_turma = ?, id_curso = ? WHERE id_Aluno = ?" ;

        Connection con = null;
        PreparedStatement statement = null;


        for( int i = 0; i < 7; i++){
            String convertString = "";
            if(params[i] == null){
                switch (i){
                    case 0: 
                    params[i] = alunos.getNome();
                    break;
                    case 1:
                    params[i] = alunos.getEndereco();
                    break;
                    case 2:
                    params[i] = alunos.getEmail_Aluno();
                    break;
                    case 3:
                    params[i] = alunos.getCelular();
                    break;
                    case 4:
                    params[i] = alunos.getTelefone();
                    break;
                    case 5:
                    params[i] = convertString + alunos.getId_Turma();
                    break;
                    case 6:
                    params[i] = convertString + alunos.getId_Curso();
                    break;
            }
        }
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);

            statement.setString(1, params[0]);
            statement.setString(2, params[1]);
            statement.setString(3, params[2]);
            statement.setString(4, params[3]);
            statement.setString(5, params[4]);
            statement.setInt(6, Integer.parseInt(params[5]));
            statement.setInt(7, Integer.parseInt(params[6]));
            statement.setInt(8, alunos.getId_Aluno());
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao alterar tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }
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

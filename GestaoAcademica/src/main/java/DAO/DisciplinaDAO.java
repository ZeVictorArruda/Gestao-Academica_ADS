package DAO;

import bin.Disciplina;
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

public class DisciplinaDAO implements DAO<Disciplina> {

    @Override
    public Optional<Disciplina> get(long id) {
        String sql = "SELECT * FROM disciplina WHERE idDisciplina = " + id;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Disciplina disciplina = new Disciplina();
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
           
            disciplina.setIdDisciplina(resultSet.getInt("idDisciplina"));
            disciplina.setNomeDisciplina(resultSet.getString("nomeDisciplina"));
            disciplina.setDiaDisciplina(resultSet.getInt("diaDisciplina"));
            disciplina.setCargaDisciplina(resultSet.getInt("cargaDisciplina"));

        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao procurar o disciplina "
                        + ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DisciplinaDAO.class.getNomeDisciplina()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            ConnectionFactory.closeConnection(con, statement, resultSet);
        }
        return Optional.of(disciplina);
    }

    @Override
    public List<Disciplina> getAll() {
        String sql = "SELECT * FROM disciplina";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Disciplina> disciplinaList = new ArrayList<Disciplina>();
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setIdDisciplina(resultSet.getInt("idDisciplina"));
                disciplina.setNomeDisciplina(resultSet.getString("nomeDisciplina"));
                disciplina.setDiaDisciplina(resultSet.getInt("diaDisciplina"));
                disciplina.setCargaDisciplina(resultSet.getInt("cargaDisciplina"));
                disciplina.add(disciplina);
            }
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao Listar os disciplina "
                        + ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DisciplinaDAO.class.getNomeDisciplina()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            ConnectionFactory.closeConnection(con, statement, resultSet);
        }
        return disciplinaList;
    }

    @Override
    public void save(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina (nomeDisciplina,diaDisciplina,cargaDisciplina) VALUES (?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, disciplina.getNomeDisciplina());
            statement.setInt(2, disciplina.getDiaDisciplina());
            statement.setInt(3, disciplina.getCargaDisciplina());
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar Disciplina "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

    @Override
    public void update(Disciplina disciplina, String[] params) {
        String sql = "UPDATE disciplina SET nomeDisciplina = ?, diaDisciplina = ?, cargaDisciplina = ?, "
        + " WHERE idDisciplina = ?" ;

        Connection con = null;
        PreparedStatement statement = null;


        for( int i = 0; i < 8; i++){
            if(params[i] == null){
                switch (i){
                    case 0: 
                    params[i] = disciplina.getNomeDisciplina();
                    break;
                    case 1:
                    params[i] = disciplina.getDiaDisciplina();
                    break;
                    case 2:
                    params[i] = disciplina.getDiaDisciplina();
                    break;
                    case 3:
                    params[i] = disciplina.getCargaDisciplina();
                    break;
            }
        }
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);

            statement.setString(1, params[0]);
            statement.setInt(2, params[1]);
            statement.setInt(3, params[2]);
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao alterar tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }
    }

    @Override
    public void delete(Disciplina disciplina) {
        String sql = "DELETE FROM disciplina WHERE idDisciplina = ?";

        Connection con = null;

        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            ConnectionFactory.getConnection();
            statement.setInt(1, disciplina.getIdDisciplina());
            statement.execute();
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao deletar o disciplina "
                        + ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

}

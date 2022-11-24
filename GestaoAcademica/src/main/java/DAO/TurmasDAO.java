package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.java.br.edu.uniaeso.gestaoacademica.Turma;

public class TurmasDAO implements DAO<Turma> {
  public Optional<Turma> get(long id) {
    String sql = "SELECT * FROM Turma WHERE id_turma = " + id;
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    main.java.bin.Turma Turma = new Turma();
    try {
      con = ConnectionFactory.getConnection();
      statement = con.prepareStatement(sql);
      resultSet = statement.executeQuery();

      Turma.setId_turma(resultSet.getInt("id_turma"));
      Turma.setNome_Turma(resultSet.getString("Nome_Turma"));
      Turma.setQtd_Turma(resultSet.getInt("qtd_Turma"));
      
    } catch (Exception ex) {
      try {
        throw new SQLException("Erro ao procurar a Turma "
            + ex.getMessage(), ex);
      } catch (SQLException ex1) {
        Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
    } finally {
      ConnectionFactory.closeConnection(con, statement, resultSet);
    }
    return Optional.of(Turma);
  }

  public List<Turma> getAll() {

    String sql = "SELECT * FROM Turma";
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<Turma> TurmaList = new ArrayList<Turma>();
    try {
      con = ConnectionFactory.getConnection();
      statement = con.prepareStatement(sql);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        main.java.bin.Turma Turma = new Turma();
        Turma.setId_Turma(resultSet.getInt("id_turma"));
        Turma.setNome(resultSet.getString("Nome_Turma"));
        Turma.setQtd_Turma(resultSet.getInt("qtd_Turma"));
        TurmaList.add(Turma);
      }
    } catch (Exception ex) {
      try {
        throw new SQLException("Erro ao Listar as Turmas "
            + ex.getMessage(), ex);
      } catch (SQLException ex1) {
        Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
    } finally {
      ConnectionFactory.closeConnection(con, statement, resultSet);
    }
    return TurmaList;
  }

  
  @Override
  public void save(main.java.bin.Turma turma) {
      String sql = "INSERT INTO turma (nome_turma,id_turma,qtd_alunos,"
              + "id_curso,id_aluno,id_disciplina) VALUES (?,?,?,?,?,?)";
      Connection con = null;
      PreparedStatement statement = null;
      try {
          con = ConnectionFactory.getConnection();
          statement = con.prepareStatement(sql);
          statement.setString(1, turma.getNome_Turma());
          statement.setInt(2, turma.getId_turma());
          statement.setInt(3,turma.getQtd_alunos());
          statement.setInt(4, turma.getId_Curso());
          statement.setInt(5, turma.getId_Aluno());
          statement.setInt(6, turma.getid_disciplina());
          statement.execute();
      } catch (SQLException ex) {
          throw new RuntimeException("Erro ao salvar Turma "
                  + ex.getMessage(), ex);
      } finally {
          ConnectionFactory.closeConnection(con, statement);
      }
  }

  @Override
  public void update(Turma turma, String[] params) {
      String sql = "UPDATE turma SET nome_turma = ?, id_turma = ?, qtd_alunos = ?, "
      + "id_curso = ?, id_aluno = ?, id_disciplina = ?, = ? WHERE id_turma = ?" ;

      Connection con = null;
      PreparedStatement statement = null;


      for( int i = 0; i < 7; i++){
          if(params[i] == null){
              switch (i){
                  case 0: 
                  params[i] = turma.getNome_Turma();
                  break;
                  case 1:
                  params[i] = turma.getId_turma();
                  break;
                  case 2:
                  params[i] = turma.getQtd_alunos();
                  break;
                  case 3:
                  params[i] = turma.getId_Curso();
                  break;
                  case 4:
                  params[i] = turma.getId_Aluno();
                  break;
                  case 5:
                  params[i] = turma.getid_disciplina();
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
          statement.setInt(7, Integer.parseInt(turma.getId_turma()));
          statement.execute();
      } catch (Exception ex) {
          throw new RuntimeException("Erro ao alterar tarefa " + ex.getMessage(), ex);
      } finally {
          ConnectionFactory.closeConnection(con, statement);
      }
  }
  }

  @Override
  public void delete(Turma turma) {
      String sql = "DELETE FROM turma WHERE id_turma = ?";

      Connection con = null;

      PreparedStatement statement = null;
      try {
          con = ConnectionFactory.getConnection();
          statement = con.prepareStatement(sql);
          ConnectionFactory.getConnection();
          statement.setInt(1, turma.getId_turma());
          statement.execute();
      } catch (Exception ex) {
          try {
              throw new SQLException("Erro ao deletar a Turma "
                      + ex.getMessage(), ex);
          } catch (SQLException ex1) {
              Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, null, ex1);
          }
      } finally {
          ConnectionFactory.closeConnection(con, statement);
      }
  }

}

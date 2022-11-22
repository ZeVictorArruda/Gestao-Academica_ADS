package DAO;

import main.java.br.edu.uniaeso.gestaoacademica.Professores;

public class ProfessoresDAO implements DAO<Professores> {
  public Optional<Professores> get(long id) {
    String sql = "SELECT * FROM professores WHERE id_Professores = " + id;
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null; // elento que manipula uma tabela, ele pega o valor do sql e joga no java
    professores professores = new professores();
    try {
      con = ConnectionFactory.getConnection();
      statement = con.prepareStatement(sql);
      resultSet = statement.executeQuery();

      professores.setId_Professores(resultSet.getInt("id_Professores"));
      professores.setNome(resultSet.getString("Nome"));
      professores.setEndereco(resultSet.getString("endereco"));
      professores.setEmail_Professores(resultSet.getString("email_Professores"));
      professores.setCelular(resultSet.getString("celular"));
      professores.setTelefone(resultSet.getString("telefone"));

    } catch (Exception ex) {
      try {
        throw new SQLException("Erro ao procurar o professor "
            + ex.getMessage(), ex);
      } catch (SQLException ex1) {
        Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
    } finally {
      ConnectionFactory.closeConnection(con, statement, resultSet);
    }
    return Optional.of(professores);
  }

  public List<Professores> getAll() {

    String sql = "SELECT * FROM professores";
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<professores> professoresList = new ArrayList<professores>();
    try {
      con = ConnectionFactory.getConnection();
      statement = con.prepareStatement(sql);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Professores professores = new Professores();
        professores.setId_Professores(resultSet.getInt("id_Professores"));
        professores.setNome(resultSet.getString("Nome"));
        professores.setEndereco(resultSet.getString("endereco"));
        professores.setEmail_Professores(resultSet.getString("email_Professores"));
        professores.setCelular(resultSet.getString("celular"));
        professores.setTelefone(resultSet.getString("telefone"));
        professoresList.add(professores);
      }
    } catch (Exception ex) {
      try {
        throw new SQLException("Erro ao Listar os professores "
            + ex.getMessage(), ex);
      } catch (SQLException ex1) {
        Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
    } finally {
      ConnectionFactory.closeConnection(con, statement, resultSet);
    }
    return professoresList;
  }

  public void save(Professores professores) {
    String sql = "INSERT INTO professores (nome,endereco,email_Professores,celular,"
        + "telefone,id_Turma,id_Curso) VALUES (?,?,?,?,?,?,?)";
    Connection con = null;
    PreparedStatement statement = null;

    try {
      con = ConnectionFactory.getConnection();
      statement = con.prepareStatement(sql); // é a abstrção do comando sql que vai ser recebido do java, pega do java e
                                             // joga no sql ( o contrário do resultset)
      statement.setString(1, professores.getNome());
      statement.setString(2, professores.getEndereco());
      statement.setString(3, professores.getEmail_Professores());
      statement.setString(4, professores.getCelular());
      statement.setString(5, professores.getTelefone());
      statement.setInt(6, professores.getId_Turma());
      statement.setInt(7, professores.getId_Curso());
      statement.execute();
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao salvar Professor " + ex.getMessage(), ex);
    } finally {
      ConnectionFactory.closeConnection(con, statement);
    }
  }

  public void update(Professores professores, String[] params) {
    String sql = "UPDATE professores SET nome_Professor = ?, idade_professor, endereco_Professor = ?, email_Professores = ?, "
        + "telefone_Professor = ?, celular_Professor = ?, id_curso = ?, id_disciplina = ? WHERE id_Professores = ?";

    Connection con = null;
    PreparedStatement statement = null;

    for (int i = 0; i < 8; i++) {
      if (params[i] == null) {
        switch (i) {
          case 0:
            params[i] = professores.getNome();
            break;
          case 1:
            params[i] = professores.getEndereco();
            break;
          case 2:
            params[i] = professores.getEmail_Professores();
            break;
          case 3:
            params[i] = professores.getCelular();
            break;
          case 4:
            params[i] = professores.getTelefone();
            break;
          case 5:
            params[i] = professores.getId_Turma();
            break;
          case 6:
            params[i] = professores.getId_Curso();
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
        statement.setInt(8, Integer.parseInt(professores.getId_Professores()));
        statement.execute();
      } catch (Exception ex) {
        throw new RuntimeException("Erro ao alterar tarefa " + ex.getMessage(), ex);
      } finally {
        ConnectionFactory.closeConnection(con, statement);
      }
    }
  }

  public void delete(Professores professores) {
    String sql = "DELETE FROM professoress WHERE id_professores = ?";

    Connection con = null;

    PreparedStatement statement = null;
    try {
      con = ConnectionFactory.getConnection();
      statement = con.prepareStatement(sql);
      ConnectionFactory.getConnection();
      statement.setInt(1, professoress.getId_professores());
      statement.execute();
    } catch (Exception ex) {
      try {
        throw new SQLException("Erro ao deletar o professores " + ex.getMessage(), ex);
      } catch (SQLException ex1) {
        Logger.getLogger(professoressDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
    } finally {
      ConnectionFactory.closeConnection(con, statement);
    }
  }
}
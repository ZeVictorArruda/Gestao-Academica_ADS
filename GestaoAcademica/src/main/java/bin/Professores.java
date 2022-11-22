package main.java.br.edu.uniaeso.gestaoacademica;

public class Professores {
  private String nome_Professor;
  private Integer idade_Professor;
  private String endereco_Professor;
  private String email_Professor;
  private String telefone_Professor;
  private String celular_Professor;
  private int id_turma;
  private int id_disciplina;

  public Professores() {
  }

  public Professores(String nome_Professor, Integer idade_Professor, String endereco_Professor, String email_Professor,
      String telefone_Professor, String celular_Professor, int id_turma, int id_disciplina) {
    this.nome_Professor = nome_Professor;
    this.idade_Professor = idade_Professor;
    this.endereco_Professor = endereco_Professor;
    this.email_Professor = email_Professor;
    this.telefone_Professor = telefone_Professor;
    this.celular_Professor = celular_Professor;
    this.id_turma = id_turma;
    this.id_disciplina = id_disciplina;
  }

  public String getNome_Professor() {
    return nome_Professor;
  }

  public void setNome_Professor(String nome_Professor) {
    this.nome_Professor = nome_Professor;
  }

  public Integer getIdade_Professor() {
    return idade_Professor;
  }

  public void setIdade_Professor(Integer idade_Professor) {
    this.idade_Professor = idade_Professor;
  }

  public String getEndereco_Professor() {
    return endereco_Professor;
  }

  public void setEndereco_Professor(String endereco_Professor) {
    this.endereco_Professor = endereco_Professor;
  }

  public String getEmail_Professor() {
    return email_Professor;
  }

  public void setEmail_Professor(String email_Professor) {
    this.email_Professor = email_Professor;
  }

  public String getCelular_Professor() {
    return celular_Professor;
  }

  public void setCelular_Professor(String celular_Professor) {
    this.celular_Professor = celular_Professor;
  }

  public String getTelefone_Professor() {
    return telefone_Professor;
  }

  public void setTelefone_Professor(String telefone_Professor) {
    this.telefone_Professor = telefone_Professor;
  }

  public int getId_turma() {
    return id_turma;
  }

  public void setId_turma(int id_turma) {
    this.id_turma = id_turma;
  }

  public int getId_disciplina() {
    return id_disciplina;
  }

  public void setId_disciplina(int id_disciplina) {
    this.id_disciplina = id_disciplina;
  }
  
}

package main.java.br.edu.uniaeso.gestaoacademica;

public class Professores {
  private String nome_Professor;
  private Integer idade_Professor;
  private String endereco_Professor;
  private String email_Professor;
  private String telefome_Professor;
  private String celular_Professor;

  public Professores() {
  }

  public Professores(String nome_Professor, Integer idade_Professor, String endereco_Professor, String email_Professor,
      String telefome_Professor, String celular_Professor) {
    this.nome_Professor = nome_Professor;
    this.idade_Professor = idade_Professor;
    this.endereco_Professor = endereco_Professor;
    this.email_Professor = email_Professor;
    this.telefome_Professor = telefome_Professor;
    this.celular_Professor = celular_Professor;
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

  public String getTelefome_Professor() {
    return telefome_Professor;
  }

  public void setTelefome_Professor(String telefome_Professor) {
    this.telefome_Professor = telefome_Professor;
  }

  public String getCelular_Professor() {
    return celular_Professor;
  }

  public void setCelular_Professor(String celular_Professor) {
    this.celular_Professor = celular_Professor;
  }
}

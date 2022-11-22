package bin;

public class Alunos {
    private int id_Aluno;
    private String nome;
    private String endereco;
    private String email_Aluno;
    private String celular;
    private String telefone;
    private int id_Turma;
    private int id_Curso;

    public Alunos(int id_Aluno, String nome, String endereco, String email_Aluno, String celular, String telefone, int id_Turma, int id_Curso) {
        this.id_Aluno = id_Aluno;
        this.nome = nome;
        this.endereco = endereco;
        this.email_Aluno = email_Aluno;
        this.celular = celular;
        this.telefone = telefone;
        this.id_Turma = id_Turma;
        this.id_Curso = id_Curso;
    }

    public Alunos() {
    }

    public int getId_Aluno() {
        return id_Aluno;
    }

    public void setId_Aluno(int id_Aluno) {
        this.id_Aluno = id_Aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail_Aluno() {
        return email_Aluno;
    }

    public void setEmail_Aluno(String email_Aluno) {
        this.email_Aluno = email_Aluno;
    }

    public String getCelular() {
        return celular;
    }

    public int getId_Turma() {
        return id_Turma;
    }

    public void setId_Turma(int id_Turma) {
        this.id_Turma = id_Turma;
    }

    public int getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(int id_Curso) {
        this.id_Curso = id_Curso;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

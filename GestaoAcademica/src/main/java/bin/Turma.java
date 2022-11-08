package main.java.bin;

public class Turma{
    
    private Integer id_turma;
    private Integer qtd_alunos;
    private String nome_Turma;
    
    public Turma(){
    }

    public Turma(Integer id_turma, Integer qtd_alunos, String nome_Turma) {
        this.id_turma = id_turma;
        this.qtd_alunos = qtd_alunos;
        this.nome_Turma = nome_Turma;
    }

    public Integer getId_turma() {
        return id_turma;
    }

    public void setId_turma(Integer id_turma) {
        this.id_turma = id_turma;
    }

    public Integer getQtd_alunos() {
        return qtd_alunos;
    }

    public void setQtd_alunos(Integer qtd_alunos) {
        this.qtd_alunos = qtd_alunos;
    }

    public String getNome_Turma() {
        return nome_Turma;
    }

    public void setNome_Turma(String nome_Turma) {
        this.nome_Turma = nome_Turma;
    }
    

}




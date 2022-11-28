package bin;

public class Disciplina {
    private int idDisciplina;
    private String nomeDisciplina;
    private int diaDisciplina;
    private int cargaDisciplina;

    public Disciplina(){

    }

    public Disciplina(int idDisciplina, String nomeDisciplina, int diaDisciplina, int cargaDisciplina){
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.diaDisciplina = diaDisciplina;
        this.cargaDisciplina = cargaDisciplina;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getDiaDisciplina() {
        return diaDisciplina;
    }

    public void setDiaDisciplina(int diaDisciplina) {
        this.diaDisciplina = diaDisciplina;
    }

    public int getCargaDisciplina() {
        return cargaDisciplina;
    }

    public void setCargaDisciplina(int cargaDisciplina) {
        this.cargaDisciplina = cargaDisciplina;
    }
    
}

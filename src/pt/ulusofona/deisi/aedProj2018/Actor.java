package pt.ulusofona.deisi.aedProj2018;


public class Actor {

    String nomeActor;
    boolean masculino;
    int idActor;
    int idFilme;

    Actor( String nomeActor, boolean masculino, int idActor, int idFilme){
       this.nomeActor= nomeActor;
       this.masculino= masculino;
       this.idActor=idActor;
       this.idFilme=idFilme;

    }

    Actor(){
    }

    public String toString() {
        return nomeActor;
    }

    public String getNomeActor() {
        return nomeActor;
    }

    public void setNomeActor(String nomeActor) {
        this.nomeActor = nomeActor;
    }

    public boolean isMasculino() {
        return masculino;
    }

    public void setMasculino(boolean masculino) {
        this.masculino = masculino;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

}

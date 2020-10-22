package pt.ulusofona.deisi.aedProj2018;

import java.util.ArrayList;

public class Filme {

    int idFilme;
    String tituloFilme;
    ArrayList<Actor> actores;
    ArrayList<GenreFilme> genero;
    int diaData;
    int mesData;
    int anoData;
    int orcamento;
    double duracao;
    float mediaVotos;
    int numVotos;


    public Filme(int idFilme, String tituloFilme,ArrayList<Actor> actores, ArrayList<GenreFilme> genero,int diaData, int mesData, int anoData, int orcamento, double duracao, float mediaVotos, int numVotos){
        this.idFilme= idFilme;
        this.tituloFilme= tituloFilme;
        this.diaData=diaData;
        this.mesData=mesData;
        this.anoData=anoData;
        this.actores= new ArrayList<>();
        this.genero=new ArrayList<>();
        this.orcamento=orcamento;
        this.duracao=duracao;
        this.mediaVotos=mediaVotos;
        this.numVotos=numVotos;
        }

        Filme(){
        }

    public String toString() {          //mudanca
        if(mesData>9) {
            return idFilme + " | " + tituloFilme + " | " + diaData + "-" + mesData + "-" + anoData + " | " + actores.size() + " | " + genero.size()+ " | " + numVotos;
        }else{
            return idFilme + " | " + tituloFilme + " | " + diaData + "-" + "0" + mesData + "-" + anoData + " | " + actores.size() + " | " + genero.size()+ " | " + numVotos;
        }
    }
    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    public ArrayList<GenreFilme> getGenero() {
        return genero;
    }

    public void setGenero(ArrayList<GenreFilme> genero) {
        this.genero = genero;
    }

    public int getDiaData() {
        return diaData;
    }

    public void setDiaData(int diaData) {
        this.diaData = diaData;
    }

    public int getMesData() {
        return mesData;
    }

    public void setMesData(int mesData) {
        this.mesData = mesData;
    }

    public int getAnoData() {
        return anoData;
    }

    public void setAnoData(int anoData) {
        this.anoData = anoData;
    }

    public int getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(int orcamento) {
        this.orcamento = orcamento;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public float getMediaVotos() {
        return mediaVotos;
    }

    public void setMediaVotos(float mediaVotos) {
        this.mediaVotos = mediaVotos;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

}

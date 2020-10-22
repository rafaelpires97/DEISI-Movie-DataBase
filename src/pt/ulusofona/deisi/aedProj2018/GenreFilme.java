package pt.ulusofona.deisi.aedProj2018;

public class GenreFilme {
    String nomeGenero;
    int idFilmeGenero;

    GenreFilme(String nomeGenero, int idFilmeGenero){
        this.nomeGenero=nomeGenero;
        this.idFilmeGenero=idFilmeGenero;
    }

    GenreFilme(){
    }

    public String toString() {
        return nomeGenero + " | " + idFilmeGenero  ;
    }

}

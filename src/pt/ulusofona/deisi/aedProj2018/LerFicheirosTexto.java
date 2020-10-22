package pt.ulusofona.deisi.aedProj2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LerFicheirosTexto {

    static HashSet<Integer> setFilmes = null;
    static HashMap<Integer,Filme> mapFilmes = null;
    static HashSet<Integer> setActor = null;
    static HashSet<String> setGenero = null;

    static ArrayList<Filme> lerFilmesFicheiro(ArrayList<Filme> listaDeFilmesTemp) {
        String nomeFicheiroFilme = "deisi_movies.txt";
        Filme filmeTemp;
        setFilmes = new HashSet<>();
        mapFilmes = new HashMap<>();
        int i=0;
        try {
            File ficheiro = new File(nomeFicheiroFilme);
            Scanner leitorFicheiro = new Scanner(ficheiro);
            while (leitorFicheiro.hasNextLine()) {
                String linha = leitorFicheiro.nextLine();
                String parts[] = linha.split(",");
                if (parts.length == 7 ) {
                    int id = Integer.parseInt(parts[0]);
                    String titulo = parts[1];
                    String data[] = parts[2].split("-");
                        int ano = Integer.parseInt(data[0]);
                        int mes = Integer.parseInt(data[1]);
                        int dia = Integer.parseInt(data[2]);
                    int orcamento = Integer.parseInt(parts[3]);
                    double duracao = Double.parseDouble(parts[4]);
                    float mediaVotos = Float.parseFloat(parts[5]);
                    int numVotos = Integer.parseInt(parts[6]);
                    if (numVotos < 0) {
                        System.out.println("Erro: A linha " + i + " não foi lida." );
                        i++;
                        continue;
                    }
                    filmeTemp = new Filme(id, titulo,null,null , dia, mes, ano, orcamento ,duracao, mediaVotos, numVotos);
                    if(setFilmes.contains(id)==false){
                        listaDeFilmesTemp.add(filmeTemp);
                        i++;
                        setFilmes.add(id);
                        mapFilmes.put(id,filmeTemp);
                    }
                }
            }
            leitorFicheiro.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Erro: " + nomeFicheiroFilme + " não foi encontrado.");
        }
        return listaDeFilmesTemp;
    }


    static ArrayList<Actor> lerActoresFicheiro(ArrayList<Actor> listaDeActores,ArrayList<Filme> listaDeFilmesTemp){
        String nomeFicheiroActors = "deisi_actors.txt";
        Actor actorTemp;
        setActor = new HashSet<>();
        try {
            File ficheiro = new File(nomeFicheiroActors);
            Scanner leitorFicheiro = new Scanner(ficheiro);
            while (leitorFicheiro.hasNextLine()) {
                String linha = leitorFicheiro.nextLine();
                String parts[] = linha.split(",");
                if(parts.length == 4) {
                    int idActor = Integer.parseInt(parts[0]);
                    String nomeActor = parts[1];
                    boolean masculino = Boolean.parseBoolean(parts[2]);
                    int idFilme = Integer.parseInt(parts[3]);
                    actorTemp = new Actor(nomeActor,masculino, idActor , idFilme);
                    if(setActor.contains(idActor)==false){
                        listaDeActores.add(actorTemp);
                        setActor.add(idActor);
                    }
                    if (mapFilmes.containsKey(idFilme)==true){
                        Filme filme = mapFilmes.get(idFilme);
                        filme.actores.add(actorTemp);
                    }
                }
            }

            leitorFicheiro.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Erro: " + nomeFicheiroActors + " não foi encontrado.");
        }
        return listaDeActores;
    }

    static ArrayList<GenreFilme> lerGeneroFicheiro(ArrayList<GenreFilme> listaDeGeneros){
        String nomeFicheiroGenres = "deisi_genres.txt";
        GenreFilme generoTemp;
        setGenero = new HashSet<>();
        try {
            File ficheiro = new File(nomeFicheiroGenres);
            Scanner leitorFicheiro = new Scanner(ficheiro);
            while (leitorFicheiro.hasNextLine()) {
                String linha = leitorFicheiro.nextLine();
                String parts[] = linha.split(",");
                if(parts.length == 2) {
                    String nomeGenero = parts[0];
                    int idFilmeGenero = Integer.parseInt(parts[1]);
                    generoTemp = new GenreFilme(nomeGenero, idFilmeGenero);
                    if(setGenero.contains(nomeGenero)==false){
                        listaDeGeneros.add(generoTemp);
                        setGenero.add(nomeGenero);
                    }
                    if (mapFilmes.containsKey(idFilmeGenero)==true){
                        Filme filme = mapFilmes.get(idFilmeGenero);
                        filme.genero.add(generoTemp);
                    }
                }
            }
            leitorFicheiro.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Erro: " + nomeFicheiroGenres + " não foi encontrado.");
        }
        return listaDeGeneros;
    }
}

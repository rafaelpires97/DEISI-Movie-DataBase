package pt.ulusofona.deisi.aedProj2018;
import java.util.ArrayList;
import java.util.Scanner;

//O PROFESSOR NA AULA PRÁTICA DE 27/05 DISSE QUE PODERIAMOS MANDAR UMA VEZ DEPOIS DAS 23:30 SABENDO QUE PERTO DESSA HORA A DROPBOX IA DEIXAR DE ESTAR DISPONIVEL

public class Main {
    static ArrayList<Filme> listaDeFilmesTemp = null;
    static ArrayList<Actor> listaDeActores = null;
    static ArrayList<GenreFilme> listaDeGeneros = null;


    public static ArrayList<Filme> getMovies(){
        return listaDeFilmesTemp;
    }

    public static void parseMovieFiles() {
        listaDeFilmesTemp = new ArrayList<>();
        listaDeActores = new ArrayList<>();
        listaDeGeneros = new ArrayList<>();
        LerFicheirosTexto.lerFilmesFicheiro(listaDeFilmesTemp);
        LerFicheirosTexto.lerActoresFicheiro(listaDeActores,listaDeFilmesTemp);
        LerFicheirosTexto.lerGeneroFicheiro(listaDeGeneros);
    }

    static String executeQuery(String query){
        String[] dadosQuery = query.split(" ",2);

        switch (dadosQuery[0]) {
            case "COUNT_MOVIES_YEAR":
                int anoCount = Integer.parseInt(dadosQuery[1]);
                return CodigoPergunta.countMoviesYear(anoCount, listaDeFilmesTemp);
            case "COUNT_MOVIES_ACTOR":
                String nomeActor= dadosQuery[1];
                return CodigoPergunta.countMoviesActor(nomeActor, listaDeFilmesTemp);
            case "COUNT_MOVIES_ACTORS":
                 String data1[] = dadosQuery[1].split(";",2);
                 String primeiroActor = data1[0];
                 String segundoActor = data1[1];
                return CodigoPergunta.countMoviesActors( primeiroActor, segundoActor, listaDeFilmesTemp);
            case "GET_TITLES_YEAR":
                int anoFilmes = Integer.parseInt(dadosQuery[1]);
                return CodigoPergunta.getTitlesYear(anoFilmes, listaDeFilmesTemp);
            case "HARD_MODE_ON_1":
                return CodigoPergunta.hardModeOn1();
            case "GET_TOP_VOTED_TITLES_YEAR":

                return CodigoPergunta.getTopVotedTitlesYear();
            case "COUNT_MOVIES_ACTOR_YEAR":
                String data2[] = dadosQuery[1].split(" ",2);
                int ano = Integer.parseInt(data2[0]);
                int ano1 =Integer.parseInt(data2[1]);
                String actor = data2[2];
                return CodigoPergunta.countMoviesActorYear(ano,ano1, actor, listaDeFilmesTemp);
            case "GET_TOP_ACTOR_YEAR":
                int anoTopActor = Integer.parseInt(dadosQuery[1]);
                return CodigoPergunta.getTopActorYear(anoTopActor, listaDeFilmesTemp);
            case "COUNT_MOVIES_YEAR_GENRE":
                String data3[] = dadosQuery[1].split(" ");
                int anoGenero = Integer.parseInt(data3[0]);
                int anoGenero2 = Integer.parseInt(data3[1]);
                String genero1 = data3[2];
                return CodigoPergunta.countMoviesYearGenre(anoGenero,anoGenero2, genero1, listaDeFilmesTemp);
            case "GET_MALE_RATIO_YEAR":
                int anoRatio = Integer.parseInt(dadosQuery[1]);
                return CodigoPergunta.getMaleRatioYear(anoRatio,listaDeFilmesTemp);
            case "COUNT_MOVIES_WITH_MANY_ACTORS":
                int numActores= Integer.parseInt(dadosQuery[1]);
                return CodigoPergunta.countMoviesWithManyActors(numActores, listaDeFilmesTemp);
            case "GET_TOP_ACTORS_BY_GENRE":
                String genero2= dadosQuery[1];
                return CodigoPergunta.getTopActorsByGenre(genero2, listaDeFilmesTemp);
            case "INSERT_ACTOR":
                String data4[] = dadosQuery[1].split(",");
                int idActorInsert= Integer.parseInt(data4[0]);
                String nomeInsert = data4[1];
                boolean sexoInsert = Boolean.parseBoolean(data4[2]);
                int idFilmeInsert = Integer.parseInt(data4[3]);
                return CodigoPergunta.insertActor(idActorInsert, nomeInsert, sexoInsert, idFilmeInsert, listaDeFilmesTemp, listaDeActores);
            case "REMOVE_ACTOR":
                return CodigoPergunta.removeActor(Integer.parseInt(dadosQuery[1]), listaDeActores,listaDeFilmesTemp);
            default:
                break;
        }
        return "Query com formato inválido. Tente novamente.";

    }

    public static void main(String[] args){
        parseMovieFiles();
        System.out.println();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (line !=null && !line.equals("QUIT")) {
            long start = System.currentTimeMillis();
            String result = executeQuery(line);
            long end = System.currentTimeMillis();
            System.out.println(result);
            System.out.println("(demorou " + (end - start) + " ms");
            line = in.nextLine();
        }
    }
}

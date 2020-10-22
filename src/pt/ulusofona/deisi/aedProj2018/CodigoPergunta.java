package pt.ulusofona.deisi.aedProj2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class CodigoPergunta {
                                                                                                                            //TESTE CERTO
    public static String countMoviesYear(int anoUser, ArrayList<Filme> listaDeFilmes) {
        int count = 0;
        boolean temComedy;
        for (Filme f: listaDeFilmes) {
            temComedy = false;
            for (GenreFilme g: f.genero) {
                if (g.nomeGenero.equals("Comedy")) {
                    temComedy = true;
                }                                       //mudanca
            }
            if (temComedy == false && anoUser == f.anoData){
                count++;
            }
        }
        return "" + count;
    }
                                                                                                                            //TESTE CERTO
    public static String countMoviesActor(String actorUser, ArrayList<Filme> listaDeFilmesTemp) {
        int count = 0;
        for (Filme f : listaDeFilmesTemp) {
            for (Actor a: f.actores) {
                if (a.nomeActor.equals(actorUser)) {
                    count++;
                }
            }
        }
        return "" + count;

    }
                                                                                                                            //FUNCIONAAA
    public static String countMoviesActors(String primeiroActor, String segundoActor, ArrayList<Filme> listaDeFilmesTemp) {
        int count = 0;
        for (Filme f : listaDeFilmesTemp) {
            for (Actor a : f.actores) {
                if (a.nomeActor.equals(primeiroActor) || a.nomeActor.equals(segundoActor)) {
                   count++;
                }
            }
        }
        return "" + count;
    }
                                                                                                                            //FUNCIONAAA
    public static String getTitlesYear(int ano, ArrayList<Filme> listaDeFilmes) {
        String titulos = "";
        for (Filme f: listaDeFilmes) {
            if (ano == f.anoData) {
                if (titulos.equals("")) {
                    titulos = f.tituloFilme;
                } else {
                    titulos = titulos + ";" + f.tituloFilme;                                                         //FUNCIONAAA
                }
            }
        }
        return titulos;
    }

    public static String hardModeOn1() {
        return null;
    }                                                                                    //NULL

    public static String getTopVotedTitlesYear() {

        return null;
    }                                                                           //NULL
                                                                                                                                //FUNCIONAAA
    public static String countMoviesActorYear(int ano,int ano1, String actor, ArrayList<Filme> listaDeFilmes) {
        int count = 0;
        for (Filme f: listaDeFilmes) {
            if (ano == f.anoData && f.actores.toString().contains(actor) ) {
                count++;
            }
            if (ano1 == f.anoData && f.actores.toString().contains(actor)) {
                count++;
            }
        }
        return "" + count;
    }
                                                                                                                                //FUNCIONAAA
    public static String countMoviesYearGenre(int ano1,int ano2, String genero, ArrayList<Filme> listaDeFilmes) {
        int count = 0;
        for (Filme f: listaDeFilmes) {
            if (ano1 == f.anoData || ano2 == f.anoData) {           //mudanca
                if (f.genero.toString().contains(genero)) {                                                             //FUNCIONAAA
                    count++;
                }
            }
        }
        return "" + count;
    }

    public static String getMaleRatioYear(int ano, ArrayList<Filme> listaDeFilmes) {
        ArrayList<Actor> listaDeActoresTemp= new ArrayList<>();
        ArrayList<Filme> filmesDoAno= new ArrayList<>();
        HashSet<Integer> setActor = new HashSet<>();
        for(Filme f: listaDeFilmes){
            if (ano==f.anoData){
                filmesDoAno.add(f);
            }                                                                                                              //ESTA BEM
        }
        int numDeHomens = 0;
        int numTotalDeAtores = 0;
        for (Filme f: filmesDoAno) {
            for(Actor a: f.actores){
                if(setActor.contains(a.idActor)== false) {
                    listaDeActoresTemp.add(a);
                    setActor.add(a.idActor);
                    if (a.masculino){
                        numDeHomens++;
                    }
                    numTotalDeAtores++;
                }
            }
        }
        long ratio=Math.round(numDeHomens*100.0/numTotalDeAtores);
        return ratio + "%";
    }
                                                                                                                                //FUNCIONAAA
    public static String countMoviesWithManyActors(int numActores, ArrayList<Filme> listaDeFilmes) {
        int count = 0;
        for (Filme f: listaDeFilmes) {
            if (f.actores.size()>numActores) {                                                                         //FUNCIONAAA
                    count++;
            }
        }
        return "" + count;
    }

    public static String getTopActorsByGenre(String genero ,ArrayList<Filme> listaDeFilmes) {

        return null;
    }                                   //NULL

    public static String insertActor(int id, String nome, boolean sexo, int idFilme, ArrayList<Filme> listaFilmes, ArrayList<Actor> listaDeActores ) {
        Actor actor = new Actor(nome, sexo, id, idFilme);
        boolean existeFilme = false;
        boolean existeActor = false;
        for (Filme f : listaFilmes) {
            if (idFilme == f.idFilme) {
                existeFilme = true;
                break;
            }
        }
        if (existeFilme == true) {
            for (Actor a : listaDeActores) {
                if (a.idActor == actor.idActor) {
                    existeActor = true;
                }
            }
            if (existeActor == false) {
                for (Filme f : listaFilmes) {
                    if (idFilme == f.idFilme) {
                        f.actores.add(actor);
                        listaDeActores.add(actor);
                        return "OK";
                    }
                }
            } else {
                return "Erro";
            }
            return "Erro";
        }
        return "Erro";
    }

    public static String removeActor(int id, ArrayList<Actor> listaActores, ArrayList<Filme> listadeFilmesTemp) {
        Actor actor = null;
        boolean actorExiste = false;
        for(Filme f: listadeFilmesTemp){
            for(Actor a: f.actores){
                if(a.idActor == id){
                    f.actores.remove(a);
                    break;
                }
            }
        }
        for(Actor a: listaActores){
            if(a.getIdActor() == id){
                actor = a;
                actorExiste = true;
            }
        }

        if(actorExiste){
            listaActores.remove(actor);
            return "OK";
        } else {
            return "Erro";
        }
    }

    public static String getTopActorYear(int ano, ArrayList<Filme> listadeFilmesTemp) {
        HashMap<Integer,Integer>actorAnoMap= new HashMap<>();
        ArrayList<Filme> filmesAno = new ArrayList<>();
        for (Filme f : listadeFilmesTemp) {
            if (ano == f.anoData){
                filmesAno.add(f);
            }
        }
        ArrayList<Actor> actorAno = new ArrayList<>();
        String result="";
        for(Filme f: filmesAno){
            for(Actor a: f.actores){
                actorAno.add(a);
            }
        }
        for(Actor a: actorAno){
            if(actorAnoMap.size()==0)
            {
                actorAnoMap.put(a.idActor,1);
            }
            else
            {
                if (actorAnoMap.containsKey(a.idActor))
                {
                    int qtd = actorAnoMap.get(a.idActor);
                    actorAnoMap.put(a.idActor, qtd+=1);
                }
                else
                {
                    actorAnoMap.put(a.idActor, 1);
                }
            }
        }
        int maiorCount = maiorNumero(actorAnoMap);
        String maiorNome = null;
        for(int i = 0;i < actorAno.size();i++)
        {
            Actor ator = actorAno.get(i);
            if(ator.idActor == maiorCount) {
                maiorNome = ator.nomeActor;
                break;
            }
        }
        result += maiorNome+";"+actorAnoMap.get(maiorCount);
        return result;
    }                                           //ESTA CERTA

    public static int maiorNumero(HashMap<Integer,Integer> mapa)                                                                    //ESTA CERTA
    {
        double maior=0.0;
        int id = -1;
        for(Map.Entry<Integer,Integer> entry : mapa.entrySet())
        {
            if(entry.getValue() > maior)
            {
                maior = entry.getValue();
                id = entry.getKey();
            }
        }
        return id;
    }
}

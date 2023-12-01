package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Campeonatode10 extends Campeonato {

    private Fixturede10 fixture;

    public Campeonatode10() {
    }
    
    public Campeonatode10(Fixturede10 fixture, Equipo ganador, int idcampeonato) {
        super(ganador, idcampeonato);
        this.fixture = fixture;
    }
    
    public Fixturede10 getFixture() {
        return fixture;
    }

    public void setFixture(Fixturede10 fixture) {
        this.fixture = fixture;
    }
    
    @Override
    public ArrayList<Equipo> tablafinaldeposiciones(Equipo[] equipos){
        ArrayList<Equipo> listaequiposordenados = new ArrayList();
        for(int i=0;i<10;i++){
            listaequiposordenados.add(equipos[i]);
        }
        Comparator<Equipo> comparadorPorPuntos = Comparator.comparingInt(E -> E.getPuntos());
        Collections.sort(listaequiposordenados, comparadorPorPuntos);
        return listaequiposordenados; 
    }
    
    @Override
    public String saludoGanador(Equipo ganador){
        return "¡FUTBOL DE PRIMERA felicita a "+ganador.getNombre().toUpperCase()+" por la obtención del torneo largo!";
    }  
}

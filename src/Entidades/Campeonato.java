/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author bmt
 */
public abstract class Campeonato {
    
    protected Equipo ganador;
    protected int idcampeonato;
    
    public Campeonato() {
    }
    
    public Campeonato(Equipo ganador, int idcampeonato) {
        this.ganador = ganador;
        this.idcampeonato = idcampeonato;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    public int getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(int idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public abstract String saludoGanador(Equipo ganador);

    public abstract ArrayList<Equipo> tablafinaldeposiciones(Equipo[] equipos);
}
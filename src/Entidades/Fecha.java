package Entidades;

import java.util.ArrayList;

public class Fecha {
   
   private ArrayList<Partido> partidos;
   private int numero;

    public Fecha() {
    }
    
    public Fecha(ArrayList<Partido> partidos, int numero) {
        this.partidos = partidos;
        this.numero=numero;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author bmt
 */
public class Equipo {
    
    private int Idequipo;
    private String Nombre;
    private int Tamañoplantel;
    private String Dt;
    private int Golesafavor;
    private int Golesencontra;
    private int Puntos;
    private int Partidosjugados;
    private int Partidosganados;
    private int Partidosempatados;
    private int Partidosperdidos;
    private int Campeonatosjugados;

    public Equipo(int Idequipo, String Nombre) {
        this.Idequipo = Idequipo;
        this.Nombre = Nombre;
    }

    public Equipo(int Idequipo, String Nombre, int Golesafavor, int Golesencontra, int Puntos, int Partidosjugados, int Partidosganados, int Partidosempatados, int Partidosperdidos) {
        this.Idequipo = Idequipo;
        this.Nombre = Nombre;
        this.Golesafavor = Golesafavor;
        this.Golesencontra = Golesencontra;
        this.Puntos = Puntos;
        this.Partidosjugados = Partidosjugados;
        this.Partidosganados = Partidosganados;
        this.Partidosempatados = Partidosempatados;
        this.Partidosperdidos = Partidosperdidos;
    }
    
    public int getIdequipo() {
        return Idequipo;
    }

    public void setIdequipo(int Idequipo) {
        this.Idequipo = Idequipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTamañoplantel() {
        return Tamañoplantel;
    }

    public void setTamañoplantel(int Tamañoplantel) {
        this.Tamañoplantel = Tamañoplantel;
    }

    public String getDt() {
        return Dt;
    }

    public void setDt(String Dt) {
        this.Dt = Dt;
    }

    public int getGolesafavor() {
        return Golesafavor;
    }

    public void setGolesafavor(int Golesafavor) {
        this.Golesafavor = Golesafavor;
    }

    public int getGolesencontra() {
        return Golesencontra;
    }

    public void setGolesencontra(int Golesencontra) {
        this.Golesencontra = Golesencontra;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public int getPartidosjugados() {
        return Partidosjugados;
    }

    public void setPartidosjugados(int Partidosjugados) {
        this.Partidosjugados = Partidosjugados;
    }

    public int getPartidosganados() {
        return Partidosganados;
    }

    public void setPartidosganados(int Partidosganados) {
        this.Partidosganados = Partidosganados;
    }

    public int getPartidosempatados() {
        return Partidosempatados;
    }

    public void setPartidosempatados(int Partidosempatados) {
        this.Partidosempatados = Partidosempatados;
    }

    public int getPartidosperdidos() {
        return Partidosperdidos;
    }

    public void setPartidosperdidos(int Partidosperdidos) {
        this.Partidosperdidos = Partidosperdidos;
    }

    public int getCampeonatosjugados() {
        return Campeonatosjugados;
    }

    public void setCampeonatosjugados(int Campeonatosjugados) {
        this.Campeonatosjugados = Campeonatosjugados;
    }  
}

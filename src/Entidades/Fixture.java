
package Entidades;

import java.util.ArrayList;


public abstract class Fixture {
    
    protected Fecha[] fechas;

    public Fixture() {
    }
    
    public Fixture(Fecha[] fechas) {
        this.fechas = fechas;
    }
    
    public abstract ArrayList<ArrayList<Equipo>> sorteo(Equipo[] equipos);
}

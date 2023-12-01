package Entidades;

import java.util.ArrayList;

public class Fixturede10 extends Fixture {
    
    public Fixturede10() {
    }

    public Fixturede10(Fecha[] fechas) {
        super(fechas);
    }
    
    public Fecha[] getFechas() {
        return fechas;
    }

    public void setFechas(Fecha[] fechas) {
        this.fechas = fechas;
    }
    
    @Override
    public ArrayList<ArrayList<Equipo>> sorteo(Equipo[] equipos){
        ArrayList<Double> aleatorios = new ArrayList();
        ArrayList<Double> aleatorios2 = new ArrayList();
        double aleatorio;
        ArrayList<Equipo> posiciones = new ArrayList();
        ArrayList<Equipo> posiciones2 = new ArrayList();
        ArrayList<ArrayList<Equipo>> lista=new ArrayList();
        for(int i=0;i<10;i++){
            aleatorios.add(Math.random());
        }
        for(int i=0;i<10;i++){
            aleatorios2.add(aleatorios.get(i));
        }
        aleatorios2.sort(null);
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(aleatorios2.get(i)==aleatorios.get(j)){
                    posiciones.add(equipos[j]);
                    break;
                }
            }
        }
        for(int i=0;i<10;i++){
            posiciones2.add(posiciones.get(i));
        }
        for(int i=0;i<9;i++){
            Equipo[] listaeq=new Equipo[10];
            for(int k=0;k<10;k++){
                if(k==0){
                    listaeq[k]=posiciones2.get(k+1);
                }else{
                    if(k==9){
                        listaeq[k]=posiciones2.get(k-1);
                    }else{
                        if(k%2==0){
                            listaeq[k]=posiciones2.get(k-2);
                        }else{
                            listaeq[k]=posiciones2.get(k+2);
                        }
                    }
                }  
            }
            ArrayList<Equipo> coleccioneq=new ArrayList();
            for(int h=0;h<10;h++){
                coleccioneq.add(listaeq[h]);
            }
            lista.add(coleccioneq);
            posiciones2.clear();
            posiciones2.addAll(coleccioneq);
        }
        return lista;
    }   
}

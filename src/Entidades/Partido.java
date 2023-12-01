package Entidades;

public class Partido {
    
    private Equipo EquipoA;
    private Equipo EquipoB;
    private int golesA;
    private int golesB;
    private Campeonato campeonato;
    private Fecha fecha;

    public Partido(Equipo EquipoA, Equipo EquipoB, Campeonato campeonato, Fecha fecha) {
        this.EquipoA = EquipoA;
        this.EquipoB = EquipoB;
        this.campeonato = campeonato;
        this.fecha = fecha;
    }
    
    public Partido() {
    }

    public Partido(Equipo EquipoA, Equipo EquipoB, Campeonatode06 campeonato) {
        this.EquipoA = EquipoA;
        this.EquipoB = EquipoB;
        this.campeonato = campeonato;
    }
    
    public Partido(Equipo EquipoA, Equipo EquipoB, Campeonatode10 campeonato) {
        this.EquipoA = EquipoA;
        this.EquipoB = EquipoB;
        this.campeonato = campeonato;
    }

    
    public Equipo getEquipoA() {
        return EquipoA;
    }

    public void setEquipoA(Equipo EquipoA) {
        this.EquipoA = EquipoA;
    }

    public Equipo getEquipoB() {
        return EquipoB;
    }

    public void setEquipoB(Equipo EquipoB) {
        this.EquipoB = EquipoB;
    }

    public int getGolesA() {
        return golesA;
    }

    public void setGolesA(int golesA) {
        this.golesA = golesA;
    }

    public int getGolesB() {
        return golesB;
    }

    public void setGolesB(int golesB) {
        this.golesB = golesB;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
    public int[] golescorto(Partido partido,int[] favoritismo,double pempate){
        int posicion1=0;
        int posicion2=01;
        double aleatorio=Math.random();
        int[] goles=new int[2];
        double pganareq1;
        int num1=1;
        int num2=7;
        for(int i=0;i<6;i++){
            if(favoritismo[i]==partido.getEquipoA().getIdequipo()){
                posicion1=i+1;
                break;
            }
        }
        for(int i=0;i<6;i++){
            if(favoritismo[i]==partido.getEquipoB().getIdequipo()){
                posicion2=i+1;
                break;
            }
        }
        pganareq1=((posicion1-7)/(posicion1+posicion2-14))*(1-pempate);
        if(aleatorio<pganareq1){
            
            goles[0]=(int) Math.rint(num1-0.5+(num2-num1+1)*Math.random());
            goles[1]=(int) Math.rint(-0.5+goles[0]*Math.random());
            
        }else{
            if(aleatorio>pganareq1 & aleatorio<pganareq1+pempate){
                goles[0]=(int) Math.rint(-0.5+(num2+1)*Math.random());
                goles[1]=goles[1];
            }else{
                goles[1]=(int) Math.rint(num1-0.5+(num2-num1+1)*Math.random());
            goles[0]=(int) Math.rint(-0.5+goles[0]*Math.random());
            }
        }
        return goles;
    }
    
    public int[] goleslargo(Partido partido,int[] favoritismo,double pempate){
        int posicion1=0;
        int posicion2=01;
        double aleatorio=Math.random();
        int[] goles=new int[2];
        double pganareq1;
        int num1=1;
        int num2=7;
        for(int i=0;i<10;i++){
            if(favoritismo[i]==partido.getEquipoA().getIdequipo()){
                posicion1=i+1;
                break;
            }
        }
        for(int i=0;i<10;i++){
            if(favoritismo[i]==partido.getEquipoB().getIdequipo()){
                posicion2=i+1;
                break;
            }
        }
        pganareq1=((posicion1-11)/(posicion1+posicion2-22))*(1-pempate);
        if(aleatorio<pganareq1){
            
            goles[0]=(int) Math.rint(num1-0.5+(num2-num1+1)*Math.random());
            goles[1]=(int) Math.rint(-0.5+goles[0]*Math.random());
            
        }else{
            if(aleatorio>pganareq1 & aleatorio<pganareq1+pempate){
                goles[0]=(int) Math.rint(-0.5+(num2+1)*Math.random());
                goles[1]=goles[1];
            }else{
                goles[1]=(int) Math.rint(num1-0.5+(num2-num1+1)*Math.random());
            goles[0]=(int) Math.rint(-0.5+goles[0]*Math.random());
            }
        }
        return goles;
    }
}

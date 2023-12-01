package futboldeprimera;

import Conexión.Campeonatosdata;
import Conexión.Equiposdata;
import Conexión.Partidosdata;
import Entidades.Campeonatode06;
import Entidades.Equipo;
import Entidades.Fecha;
import Entidades.Fixturede06;
import Entidades.Fixturede10;
import Entidades.Partido;
import Entidades.Campeonatode10;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Futboldeprimera {

    public static void main(String[] args) {
        
        Campeonatosdata campeonatodata = new Campeonatosdata();
        Equiposdata equiposdata= new Equiposdata();
        Partidosdata partidosdata=new Partidosdata();
        
        String[] nombreequipos = {"Boca Juniors", "River Plate", "Independiente", "Racing", "San Lorenzo", "Estudiantes", "Vélez", "Huracán", "Rosario Central", "Newells"};

        int[] favoritismo={1,2,3,4,5,6,7,8,9,10};
        double pempate=0.3;
        
        boolean volveralmenuprincipal=false;
        boolean salir=false;
        boolean saliralinicio=false;
        
        Scanner leer = new Scanner(System.in);
        
        boolean exception;
        double opcionnum;
        String opcion;
        
        String[] Menu0 = new String[2];
        Menu0[0]="1: opción A.";
        Menu0[1]="2: opción B.";
        double l0=(double) Menu0.length;
        
        String[] Menu1 = new String[7];
        Menu1[0]="MENÜ PRINCIPAL (Seleccione una opción):";
        Menu1[1]="1: crear nuevo campeonato.";
        Menu1[2]="2: consultar info sobre campeonatos anteriores.";
        Menu1[3]="3: consultar info sobre equipos.";
        Menu1[4]="4: cambiar DT equipos.";
        Menu1[5]="5: actualizar el tamaño de un plantel.";
        Menu1[6]="6: salir";
        double l1=(double) Menu1.length;
        
        String[] Menu3 = new String[4];
        Menu3[0]="1: campeonato LARGO (10 equipos) todos contra todos.";
        Menu3[1]="2: campeonato CORTO (6 equipos) todos contra todos.";
        Menu3[2]="3: volver al menú principal.";
        Menu3[3]="4: salir.";
        double l3=(double) Menu3.length;
        
        String[] Menu4 = new String[2];
        Menu4[0]="1: sí.";
        Menu4[1]="2: no, y salir.";
        double l4=(double) Menu4.length;
      
        String[] Menu5 = new String[3];
        Menu5[0]="1: sí.";
        Menu5[1]="2: no, y volver al menú principal.";
        Menu5[2]="3: no, y salir.";
        double l5=(double) Menu5.length;
        
        String[] Menu6 = new String[12];
        for(int i=0;i<10;i++){
            Menu6[i]=String.valueOf(i+1)+": "+nombreequipos[i];
        }
        Menu6[10]="11: volver al menú principal.";
        Menu6[11]="12: salir.";
        double l6=(double) Menu6.length;        
  
        System.out.println("¡BIENVENIDOS A LA APLICACIÓN!");
        
        if(equiposdata.primeraEjecucion()){
            System.out.println("");
            System.out.println("Este programa interactúa con el usuario de manera que este debe introducir caracteres numéricos por teclado cuyos");
            System.out.println("valores están asociados a las distintas funcionalidad del programa, las cuales serán informadas en menúes.");
            do{
                System.out.println("");
                System.out.println("Por ejemplo, a continuación presione la tecla '1' o '2' para elegir entre la 'Opción A' o la 'Opción B' respectivamente:");
                System.out.println("");
                exception=false;
                for(int i=0;i<Menu0.length;i++){
                    System.out.println(Menu0[i]);
                }
                try{
                    opcion=leer.next();
                    opcionnum=Integer.parseInt(opcion);
                    if(Math.abs(opcionnum-1-((l0)-1)/2)>((l0)-1)/2){
                        JOptionPane.showMessageDialog(null,"Ha ingresado un número fuera de rango. Inténtelo nuevamente.");
                        exception=true;
                    }else{
                        System.out.println("");
                        System.out.println("¡Bien hecho¡ Ha escogido la "+Menu0[(int) opcionnum-1].substring(3));
                    }
                }catch(NumberFormatException nfe ){
                    JOptionPane.showMessageDialog(null,"Debe ingresar un caracter numérico entero. Inténtelo nuevamente.");
                    exception=true;
                }
            }while(exception==true);
            System.out.println("");
            System.out.println("Como es la primera vez que se ejecuta la aplicación, deberá subir todos los equipos a la base de datos ¿Desea hacerlo ahora?");
            System.out.println("");
            do{
                exception=false;
                volveralmenuprincipal=false;
                for(int i=0;i<Menu4.length;i++){
                    System.out.println(Menu4[i]);
                }
                try{
                    opcion=leer.next();
                    opcionnum=Integer.parseInt(opcion);
                    if(Math.abs(opcionnum-1-((l0)-1)/2)>((l0)-1)/2){
                        JOptionPane.showMessageDialog(null,"Ha ingresado un número fuera de rango. Inténtelo nuevamente.");
                        exception=true;
                    }else{
                        if(opcionnum==1){
                            equiposdata.subirEquipos();
                        }else{
                            JOptionPane.showMessageDialog(null,"Hasta que no se suban los equipos a la base de datos, no podrá utilizar ninguna de las funcionalidades del programa.");
                            saliralinicio=true;
                            break;
                        }
                    }
                }catch(NumberFormatException nfe ){
                    JOptionPane.showMessageDialog(null,"Debe ingresar un caracter numérico entero. Inténtelo nuevamente.");
                    exception=true;
                }
            }while(exception==true);
        } 
        
        if(saliralinicio!=true){
        do{
            exception=false;
            volveralmenuprincipal=false;
            System.out.println("");
            for(int i=0;i<Menu1.length;i++){
                System.out.println(Menu1[i]);
            }
            try{
                opcion=leer.next();
                opcionnum=Integer.parseInt(opcion);
                if(Math.abs(opcionnum-1-((l1)-1)/2)>((l1)-1)/2 || opcionnum==Menu1.length){
                    JOptionPane.showMessageDialog(null,"Ha ingresado un número fuera de rango. Inténtelo nuevamente.");
                }else{
                    switch((int)opcionnum){
                        case 1:
                            do{
                                volveralmenuprincipal=false;
                                exception=false;
                                System.out.println("Seleccione una opción:");
                                for(int i=0;i<Menu3.length;i++){
                                    System.out.println(Menu3[i]);
                                }
                                try{
                                    opcion=leer.next();
                                    opcionnum=Integer.parseInt(opcion);
                                    if(Math.abs(opcionnum-1-((l3)-1)/2)>((l3)-1)/2){
                                        JOptionPane.showMessageDialog(null,"Ha ingresado un número fuera de rango. Inténtelo nuevamente.");
                                        exception=true;
                                    }else{

                                        switch((int)opcionnum){
                                            case 1:
                                                Fixturede10 fixture=new Fixturede10();
                                                Campeonatode10 campeonato = new Campeonatode10();
                                                Equipo[] equipos=new Equipo[10];
                                                Fecha[] fechas =new Fecha[9];
                                                Partido[] partidos=new Partido[45];
                                                ArrayList<ArrayList<Equipo>> fechaequipos = new ArrayList();
                                                ArrayList<Partido> listapartidos=new ArrayList();
                                                for(int i=0;i<10;i++){
                                                    equipos[i]=new Equipo(i+1,nombreequipos[i],0,0,0,0,0,0,0);
                                                }
                                                fechaequipos=fixture.sorteo(equipos);
                                                for(int y=0;y<9;y++){
                                                    System.out.println("");
                                                    for(int t=0;t<10;t++){
                                                        System.out.println(fechaequipos.get(y).get(t).getNombre());
                                                    }
                                                }
                                                int k=0;
                                                for(int i=0;i<9;i++){
                                                    for(int j=0;j<5;j++){
                                                            partidos[k]=new Partido(fechaequipos.get(i).get(2*j),fechaequipos.get(i).get(2*j+1),campeonato);
                                                            Partido elpartido=new Partido();
                                                            listapartidos.add(partidos[k]); 
                                                            k++;
                                                    }
                                                }
                                                for(int i=0;i<9;i++){
                                                    ArrayList<Partido> partidosporfecha = new ArrayList<>(listapartidos.subList(5*i, 5*i+5));
                                                    fechas[i]=new Fecha(partidosporfecha,i+1);
                                                }
                                                fixture.setFechas(fechas);
                                                campeonato.setFixture(fixture);
                                                System.out.println("");
                                                System.out.println("El sorteo de las fechas quedó de la siguiente manera:");
                                                for(int i=0;i<9;i++){
                                                    System.out.println("");
                                                    System.out.println("Fecha "+(i+1)+":");
                                                    for(int j=0;j<5;j++){
                                                        System.out.println(fechas[i].getPartidos().get(j).getEquipoA().getNombre()+" vs. "+fechas[i].getPartidos().get(j).getEquipoB().getNombre());
                                                    }
                                                }
                                                for(int i=0;i<9;i++){
                                                    System.out.println("");
                                                    do{
                                                        System.out.println("¿Desea jugar la FECHA "+(i+1)+"?");
                                                        volveralmenuprincipal=false;
                                                        exception=false;
                                                        for(int j=0;j<Menu5.length;j++){
                                                            System.out.println(Menu5[j]);
                                                        }
                                                        try{
                                                            opcion=leer.next();
                                                            opcionnum=Integer.parseInt(opcion);
                                                            if(Math.abs(opcionnum-1-((l5)-1)/2)>((l5)-1)/2){
                                                                JOptionPane.showMessageDialog(null,"Ha ingresado un número fuera de rango. Inténtelo nuevamente.");
                                                                exception=true;
                                                            }else{
                                                                if(opcionnum==1){
                                                                    System.out.println("");
                                                                    System.out.println("Resultados de la FECHA "+(i+1)+":");
                                                                    System.out.println("");
                                                                    for(int j=0;j<5;j++){
                                                                        fechas[i].getPartidos().get(j).setGolesA(fechas[i].getPartidos().get(j).goleslargo(fechas[i].getPartidos().get(j), favoritismo, pempate)[0]);
                                                                        fechas[i].getPartidos().get(j).setGolesB(fechas[i].getPartidos().get(j).goleslargo(fechas[i].getPartidos().get(j), favoritismo, pempate)[1]);
                                                                        int goleslocal=fechas[i].getPartidos().get(j).getGolesA();
                                                                        int golesvisitante=fechas[i].getPartidos().get(j).getGolesB();
                                                                        System.out.println(fechas[i].getPartidos().get(j).getEquipoA().getNombre()+" "+goleslocal+" vs. "+golesvisitante+" "+fechas[i].getPartidos().get(j).getEquipoB().getNombre());       
                                                                        equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setGolesafavor(equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getGolesafavor()+goleslocal);
                                                                        equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setGolesencontra(equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getGolesencontra()+golesvisitante);
                                                                        equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setGolesafavor(equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getGolesafavor()+golesvisitante);
                                                                        equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setGolesencontra(equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getGolesencontra()+goleslocal);
                                                                        if(goleslocal>golesvisitante){
                                                                            equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPartidosganados(equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPartidosganados()+1);
                                                                            equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPartidosperdidos(equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPartidosperdidos()+1);
                                                                            equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPuntos(equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPuntos()+3); 
                                                                        }else{
                                                                            if(goleslocal==golesvisitante){
                                                                                equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPartidosempatados(equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPartidosempatados()+1);
                                                                                equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPartidosempatados(equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPartidosempatados()+1);
                                                                                equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPuntos(equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPuntos()+1);
                                                                                equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPuntos(equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPuntos()+1);
                                                                            }else{
                                                                                equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPartidosganados(equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPartidosganados()+1);
                                                                                equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPartidosperdidos(equipos[fechas[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPartidosperdidos()+1);
                                                                                equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPuntos(equipos[fechas[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPuntos()+3);                
                                                                            }
                                                                        }
                                                                    }
                                                                }else{
                                                                    if(opcionnum==2){
                                                                        volveralmenuprincipal=true;
                                                                        break;
                                                                    }else{
                                                                        salir=true;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }catch(NumberFormatException nfe ){
                                                            JOptionPane.showMessageDialog(null,"Debe ingresar un caracter numérico entero. Inténtelo nuevamente.");
                                                            exception=true;
                                                        }
                                                    }while(exception==true);
                                                    if(volveralmenuprincipal || salir){
                                                        break;
                                                    }
                                                }
                                                if(volveralmenuprincipal || salir){
                                                        break;
                                                    }
                                                System.out.println("");
                                                ArrayList<Equipo> listafinal=new ArrayList();
                                                listafinal=campeonato.tablafinaldeposiciones(equipos);
                                                campeonato.setGanador(listafinal.get(9));
                                                System.out.println("¡EL CAMPEONATO HA FINALIZADO! Equipo ganador: "+campeonato.getGanador().getNombre().toUpperCase());
                                                System.out.println("");
                                                System.out.println(campeonato.saludoGanador(campeonato.getGanador()));
                                                System.out.println("");
                                                System.out.println("RESUMEN EQUIPO POR EQUIPO:");
                                                System.out.println("");
                                                for(int r=9;r>=0;r--){
                                                    System.out.println(listafinal.get(r).getNombre().toUpperCase()+":");
                                                    System.out.println("Posición final en la tabla: "+(10-r));
                                                    System.out.println("Puntaje final: "+listafinal.get(r).getPuntos());
                                                    System.out.println("Partidos jugados: "+10);
                                                    System.out.println("Partidos ganados: "+listafinal.get(r).getPartidosganados());
                                                    System.out.println("Partidos empatados: "+listafinal.get(r).getPartidosempatados());
                                                    System.out.println("Partidos perdidos: "+listafinal.get(r).getPartidosperdidos());
                                                    System.out.println("Goles a favor:"+listafinal.get(r).getGolesafavor());
                                                    System.out.println("Goles en contra:"+listafinal.get(r).getGolesencontra());
                                                    System.out.println("");
                                                }
                                                campeonatodata.subirCampeonato(campeonato);
                                                equiposdata.subirEquiposCampeonato(equipos, campeonato);
                                                partidosdata.subirPartidos(fechas, campeonato);
                                                volveralmenuprincipal=true;
                                                break;
                                            case 2:
                                                Fixturede06 fixture2=new Fixturede06();
                                                Campeonatode06 campeonato2 = new Campeonatode06();
                                                Equipo[] equipos2=new Equipo[6];
                                                Fecha[] fechas2 =new Fecha[5];
                                                Partido[] partidos2=new Partido[15];
                                                ArrayList<ArrayList<Equipo>> fechaequipos2 = new ArrayList();
                                                ArrayList<Partido> listapartidos2=new ArrayList();
                                                for(int i=0;i<6;i++){
                                                    equipos2[i]=new Equipo(i+1,nombreequipos[i],0,0,0,0,0,0,0);
                                                }
                                                fechaequipos=fixture2.sorteo(equipos2);
                                                int k2=0;
                                                for(int i=0;i<5;i++){
                                                    for(int j=0;j<3;j++){
                                                            partidos2[k2]=new Partido(fechaequipos.get(i).get(2*j),fechaequipos.get(i).get(2*j+1),campeonato2);
                                                            Partido elpartido2=new Partido();
                                                            listapartidos2.add(partidos2[k2]); 
                                                            k2++;
                                                    }
                                                }
                                                for(int i=0;i<5;i++){
                                                    ArrayList<Partido> partidosporfecha = new ArrayList<>(listapartidos2.subList(3*i, 3*i+3));
                                                    fechas2[i]=new Fecha(partidosporfecha,i+1);
                                                }
                                                fixture2.setFechas(fechas2);
                                                campeonato2.setFixture(fixture2);
                                                System.out.println("");
                                                System.out.println("El sorteo de las fechas quedó de la siguiente manera:");
                                                for(int i=0;i<5;i++){
                                                    System.out.println("");
                                                    System.out.println("Fecha "+(i+1)+":");
                                                    for(int j=0;j<3;j++){
                                                        System.out.println(fechas2[i].getPartidos().get(j).getEquipoA().getNombre()+" vs. "+fechas2[i].getPartidos().get(j).getEquipoB().getNombre());
                                                    }
                                                }
                                                for(int i=0;i<5;i++){
                                                    System.out.println("");
                                                    do{
                                                        System.out.println("¿Desea jugar la FECHA "+(i+1)+"?");
                                                        volveralmenuprincipal=false;
                                                        exception=false;
                                                        for(int j=0;j<Menu5.length;j++){
                                                            System.out.println(Menu5[j]);
                                                        }
                                                        try{
                                                            opcion=leer.next();
                                                            opcionnum=Integer.parseInt(opcion);
                                                            if(Math.abs(opcionnum-1-((l5)-1)/2)>((l5)-1)/2){
                                                                JOptionPane.showMessageDialog(null,"Ha ingresado un número fuera de rango. Inténtelo nuevamente.");
                                                                exception=true;
                                                            }else{
                                                                if(opcionnum==1){
                                                                    
                                                                    System.out.println("");
                                                                    System.out.println("Resultados de la FECHA "+(i+1)+":");
                                                                    System.out.println("");
                                                                    for(int j=0;j<3;j++){
                                                                        fechas2[i].getPartidos().get(j).setGolesA(fechas2[i].getPartidos().get(j).goleslargo(fechas2[i].getPartidos().get(j), favoritismo, pempate)[0]);
                                                                        fechas2[i].getPartidos().get(j).setGolesB(fechas2[i].getPartidos().get(j).goleslargo(fechas2[i].getPartidos().get(j), favoritismo, pempate)[1]);                        
                                                                        int goleslocal=fechas2[i].getPartidos().get(j).getGolesA();
                                                                        int golesvisitante=fechas2[i].getPartidos().get(j).getGolesB();
                                                                        System.out.println(fechas2[i].getPartidos().get(j).getEquipoA().getNombre()+" "+goleslocal+" vs. "+golesvisitante+" "+fechas2[i].getPartidos().get(j).getEquipoB().getNombre());            
                                                                        equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setGolesafavor(equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getGolesafavor()+goleslocal);
                                                                        equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setGolesencontra(equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getGolesencontra()+golesvisitante);
                                                                        equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setGolesafavor(equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getGolesafavor()+golesvisitante);
                                                                        equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setGolesencontra(equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getGolesencontra()+goleslocal);      
                                                                        if(goleslocal>golesvisitante){
                                                                            equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPartidosganados(equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPartidosganados()+1);
                                                                            equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPartidosperdidos(equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPartidosperdidos()+1);
                                                                            equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPuntos(equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPuntos()+3);      
                                                                        }else{
                                                                            if(goleslocal==golesvisitante){
                                                                                equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPartidosempatados(equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPartidosempatados()+1);
                                                                                equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPartidosempatados(equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPartidosempatados()+1);
                                                                                equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPuntos(equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPuntos()+1);
                                                                                equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPuntos(equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPuntos()+1);

                                                                            }else{
                                                                                equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPartidosganados(equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPartidosganados()+1);
                                                                                equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].setPartidosperdidos(equipos2[fechas2[i].getPartidos().get(j).getEquipoA().getIdequipo()-1].getPartidosperdidos()+1);
                                                                                equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].setPuntos(equipos2[fechas2[i].getPartidos().get(j).getEquipoB().getIdequipo()-1].getPuntos()+3);
                                                                            }
                                                                        }
                                                                    }
                                                                }else{
                                                                    if(opcionnum==2){
                                                                        volveralmenuprincipal=true;
                                                                        break;
                                                                    }else{
                                                                        salir=true;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }catch(NumberFormatException nfe ){
                                                            JOptionPane.showMessageDialog(null,"Debe ingresar un caracter numérico entero. Inténtelo nuevamente.");
                                                            exception=true;
                                                        }
                                                    }while(exception==true);
                                                    if(volveralmenuprincipal || salir){
                                                        break;
                                                    }
                                                }
                                                if(volveralmenuprincipal || salir){
                                                        break;
                                                    }
                                                System.out.println("");
                                                ArrayList<Equipo> listafinal2=new ArrayList();
                                                listafinal2=campeonato2.tablafinaldeposiciones(equipos2);
                                                campeonato2.setGanador(listafinal2.get(4));
                                                System.out.println("¡EL CAMPEONATO HA FINALIZADO! Equipo ganador: "+campeonato2.getGanador().getNombre().toUpperCase());
                                                System.out.println("");
                                                System.out.println(campeonato2.saludoGanador(campeonato2.getGanador()));
                                                System.out.println("");
                                                System.out.println("RESUMEN EQUIPO POR EQUIPO:");
                                                System.out.println("");
                                                for(int r=4;r>=0;r--){
                                                    System.out.println(listafinal2.get(r).getNombre().toUpperCase()+":");
                                                    System.out.println("Posición final en la tabla: "+(6-r));
                                                    System.out.println("Puntaje final: "+listafinal2.get(r).getPuntos());
                                                    System.out.println("Partidos jugados: "+5);
                                                    System.out.println("Partidos ganados: "+listafinal2.get(r).getPartidosganados());
                                                    System.out.println("Partidos empatados: "+listafinal2.get(r).getPartidosempatados());
                                                    System.out.println("Partidos perdidos: "+listafinal2.get(r).getPartidosperdidos());
                                                    System.out.println("Goles a favor:"+listafinal2.get(r).getGolesafavor());
                                                    System.out.println("Goles en contra:"+listafinal2.get(r).getGolesencontra());
                                                    System.out.println("");
                                                }
                                                campeonatodata.subirCampeonato(campeonato2);
                                                equiposdata.subirEquiposCampeonato(equipos2, campeonato2);
                                                partidosdata.subirPartidos(fechas2, campeonato2);
                                                volveralmenuprincipal=true;
                                                break;
                                            case 3:
                                                volveralmenuprincipal=true;
                                                break;
                                            default:
                                                salir=true;
                                                break;
                                        }
                                    }
                                }catch(NumberFormatException nfe ){
                                    JOptionPane.showMessageDialog(null,"Debe ingresar un caracter numérico entero. Inténtelo nuevamente.");
                                    exception=true;
                                }
                            }while(exception==true || (volveralmenuprincipal==false & salir==false));
                            break;
                        case 2:
                            campeonatodata.infoCampeonatos();
                            break;
                        case 3:
                            equiposdata.infoEquipos();
                            break;
                        case 4:
                            do{
                                exception=false;
                                System.out.println("Seleccione un equipo:");
                                for(int i=0;i<Menu6.length;i++){
                                    System.out.println(Menu6[i]);
                                }
                                try{
                                    opcion=leer.next();
                                    opcionnum=Integer.parseInt(opcion);
                                    if(Math.abs(opcionnum-1-((l6)-1)/2)>((l6)-1)/2){
                                        JOptionPane.showMessageDialog(null,"Ha ingresado un número fuera de rango. Inténtelo nuevamente.");
                                        exception=true;
                                    }else{
                                        switch((int) opcionnum){
                                            case 11:
                                                volveralmenuprincipal=true;
                                                salir=false;
                                                break;
                                            case 12:
                                                volveralmenuprincipal=false;
                                                salir=true;  
                                                break;
                                            default:
                                                System.out.println("A continuación ingrese el nombre del nuevo Dt de "+nombreequipos[(int) (opcionnum-1)]);
                                                String nuevodt=leer.next();
                                                equiposdata.actualizarDt(nombreequipos[(int) (opcionnum-1)], nuevodt);
                                                volveralmenuprincipal=true;
                                                break;
                                        }
                                    }
                                }catch(NumberFormatException nfe ){
                                    JOptionPane.showMessageDialog(null,"Debe ingresar un caracter numérico entero. Inténtelo nuevamente.");
                                    exception=true;
                                }
                                System.out.println("");
                            }while(exception==true);
                            break;    
                        case 5:
                            do{
                                exception=false;
                                System.out.println("Seleccione un equipo:");
                                for(int i=0;i<Menu6.length;i++){
                                    System.out.println(Menu6[i]);
                                }
                                try{
                                    opcion=leer.next();
                                    opcionnum=Integer.parseInt(opcion);
                                    if(Math.abs(opcionnum-1-((l6)-1)/2)>((l6)-1)/2){
                                        JOptionPane.showMessageDialog(null,"Ha ingresado un número fuera de rango. Inténtelo nuevamente.");
                                        exception=true;
                                    }else{
                                        switch((int) opcionnum){
                                            case 11:
                                                volveralmenuprincipal=true;
                                                salir=false;
                                                break;
                                            case 12:
                                                volveralmenuprincipal=false;
                                                salir=true;  
                                                break;
                                            default:
                                                do{
                                                    System.out.println("");
                                                    System.out.println("A continuación ingrese el tamaño del plantel de "+nombreequipos[(int) (opcionnum-1)]+":");
                                                    try{
                                                        String tamañotexto=leer.next();
                                                        Integer tamaño=Integer.parseInt(tamañotexto);
                                                        if(tamaño<16){
                                                            JOptionPane.showMessageDialog(null,"Debe ingresar un número mayor o igual a 16. Inténtelo nuevamente");
                                                            exception=true;
                                                        }else{
                                                            equiposdata.actualizarTamaño(nombreequipos[(int) (opcionnum-1)],tamaño);
                                                            exception=false;
                                                        }
                                                    }catch(NumberFormatException nfe){
                                                        JOptionPane.showMessageDialog(null,"Debe ingresar un número mayor o igual a 16. Inténtelo nuevamente");
                                                        exception=true;
                                                    }
                                                }while(exception);
                                                
                                                volveralmenuprincipal=true;
                                                break;
                                        }
                                    }
                                }catch(NumberFormatException nfe ){
                                    JOptionPane.showMessageDialog(null,"Debe ingresar un caracter numérico entero. Inténtelo nuevamente.");
                                    exception=true;
                                }
                                System.out.println("");
                            }while(exception==true);
                            break;    
                            
                        default:
                            salir=true;
                            break;
                    }
                }
            }catch(NumberFormatException nfe ){
                JOptionPane.showMessageDialog(null,"Debe ingresar un caracter numérico entero. Inténtelo nuevamente.");
                exception=true;
            }
        }while(exception==true || volveralmenuprincipal==true || salir==false);
    }
                System.out.println("");
                System.out.println("¡GRACIAS POR UTILIZAR EL PROGRAMA!");
    }
    
}

package Conexión;

import Entidades.Campeonato;
import Entidades.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Equiposdata {
    
    private Connection con=null;

    public Equiposdata(){
        con=Conexiondata.getconexion2();
    }
    
    
    public void actualizarDt(String nombreequipo, String nuevodt){
        String sql="UPDATE equipos SET Dt=? WHERE Nombre=?";
        boolean exito=false;
        try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,nuevodt);
        ps.setString(2,nombreequipo);
        ps.executeUpdate();
        ps.close();
        exito=true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al subir la actualización a la base de datos");
        }
        if(exito){
            JOptionPane.showMessageDialog(null,"DT de "+nombreequipo+" actualizado!");
        }
    }
    
    public void actualizarTamaño(String nombreequipo, int tamaño){
        String sql="UPDATE equipos SET Tamañoplantel=? WHERE Nombre=?";
        boolean exito=false;
        try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,tamaño);
        ps.setString(2,nombreequipo);
        ps.executeUpdate();
        ps.close();
        exito=true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al subir la actualización a la base de datos");
        } 
        if(exito){
            JOptionPane.showMessageDialog(null,"Tamaño de plantel de "+nombreequipo+" actualizado!");
        }
    }
    
    public boolean primeraEjecucion(){
        String sql = "SELECT* FROM equipos";
        boolean x=true;
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            ps.close();
            x=rs.next();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
    return !x;
    }
    
    public void subirEquipos(){
       String[] equipos = {"Boca Juniors", "River Plate", "Independiente", "Racing", "San Lorenzo", "Estudiantes", "Vélez", "Huracán", "Rosario Central", "Newells"};
       String[] dts= {"Herrón","Demichelis","Tévez","Gago","Insúa","Domínguez","Méndez","Martínez","Russo","Heinze"};
        int exito=0;
        for(int i=0;i<10;i++){
            String sql = "INSERT INTO equipos (Nombre,Dt,Tamañoplantel,Campeonatoscortosganados,Campeonatoslargosganados,Partidosganados,Partidosempatados,Partidosperdidos,Golesafavor,Golesencontra) VALUES (?,?,?,?,?,?,?,?,?,?)";
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,equipos[i]);
                ps.setString(2,dts[i]);
                ps.setInt(3,23);
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.setInt(8, 0);
                ps.setInt(9, 0);
                ps.setInt(10, 0);
                ps.executeUpdate();
                ps.close();
                exito++;
                }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al subir los equipos a la base de datos");
            }
        }
        if(exito==10){
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Se han subido a la base de datos los siguientes ").append(equipos.length).append(" equipos:\n\n");
            for (String equipo : equipos) {
                mensaje.append(equipo).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Equipos Subidos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    public void infoEquipos(){
        String sql="SELECT * FROM equipos";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("");
                System.out.println("Nombre: "+rs.getString("Nombre"));
                System.out.println("Director técnico: "+rs.getString("Dt"));
                System.out.println("Tamaño del plantel: "+rs.getInt("Tamañoplantel"));
                System.out.println("Campeonatos cortos ganados: "+rs.getInt("Campeonatoscortosganados"));
                System.out.println("Campeonatos largos ganados: "+rs.getInt("Campeonatoslargosganados"));
                System.out.println("Partidos ganados: "+rs.getInt("Partidosganados"));
                System.out.println("Partidos empatados: "+rs.getInt("Partidosempatados"));
                System.out.println("Partidos perdidos: "+rs.getInt("Partidosperdidos"));
                System.out.println("Goles a favor: "+rs.getInt("Golesafavor"));
                System.out.println("Goles en contra: "+rs.getInt("Golesencontra"));
                ps.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
    }
    
    public void subirEquiposCampeonato(Equipo[] equipos,Campeonato campeonato){
        int exito=0;
        for(int i=0;i<campeonato.tablafinaldeposiciones(equipos).size();i++){
            String sql="UPDATE equipos SET Campeonatoscortosganados=Campeonatoscortosganados+?,Campeonatoslargosganados=Campeonatoslargosganados+?,Partidosganados=Partidosganados+?,Partidosempatados=Partidosempatados+?,Partidosperdidos=Partidosperdidos+?,Golesafavor=Golesafavor+?,Golesencontra=Golesencontra+? WHERE Nombre=?";
            try{
               PreparedStatement ps=con.prepareStatement(sql);
               if(campeonato.getGanador().getIdequipo()-1==i){
                   if(campeonato.getClass().getName().substring(12).equals("06")){
                       ps.setInt(1,1);
                       ps.setInt(2, 0);
                   }else{
                       ps.setInt(1,0);
                       ps.setInt(2,1);
                   }
               }else{
                   ps.setInt(1, 0);
                   ps.setInt(2, 0);
               }
               ps.setInt(3, equipos[i].getPartidosganados());
               ps.setInt(4, equipos[i].getPartidosempatados());
               ps.setInt(5, equipos[i].getPartidosperdidos());
               ps.setInt(6, equipos[i].getGolesafavor());
               ps.setInt(7, equipos[i].getGolesencontra());
               ps.setString(8, equipos[i].getNombre());
               ps.executeUpdate();
               ps.close();
               exito++;
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al actualizar la información de los equipos en la base de datos");
            }
        }
        if(exito==campeonato.tablafinaldeposiciones(equipos).size()){
            JOptionPane.showMessageDialog(null,"Se ha actualizado la información de los equipos en la base de datos");
        }
    }
    
}

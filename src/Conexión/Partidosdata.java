package Conexión;

import Entidades.Campeonato;
import Entidades.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Partidosdata {
    
    private Connection con=null;

    public Partidosdata(){
        con=Conexiondata.getconexion2();
    }
    
    public void subirPartidos(Fecha[] fechas,Campeonato campeonato){
        int exito=0;
        for(int i=0;i<fechas.length;i++){
            for(int j=0;j<(fechas.length+1)/2;j++){
            String sql="INSERT INTO partidos (Idcampeonato,Fecha,Equipolocal,Equipovisitante,Goleslocal,Golesvisitante) VALUES (?,?,?,?,?,?)";
                try{
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.setInt(1,campeonato.getIdcampeonato());
                    ps.setInt(2,fechas[i].getNumero());
                    ps.setString(3,fechas[i].getPartidos().get(j).getEquipoA().getNombre());
                    ps.setString(4,fechas[i].getPartidos().get(j).getEquipoB().getNombre());
                    ps.setInt(5,fechas[i].getPartidos().get(j).getGolesA());
                    ps.setInt(6,fechas[i].getPartidos().get(j).getGolesB());
                    ps.executeUpdate();
                    ps.close();
                    exito++;
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error al subir los partidos a la base de datos");
                }
            }
        }
        if(exito==(fechas.length)*(fechas.length+1)/2){
            JOptionPane.showMessageDialog(null,"Todos los partidos se han subido correctamente a la base de datos");
        }
    }
}

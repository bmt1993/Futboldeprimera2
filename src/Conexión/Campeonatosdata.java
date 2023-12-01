package Conexión;

import Entidades.Campeonato;
import Entidades.Campeonatode06;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Campeonatosdata {

    private Connection con=null;

    public Campeonatosdata(){
        con=Conexiondata.getconexion2();
    }
    
    public void infoCampeonatos(){
        String sql="SELECT * FROM campeonatos";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("");
                switch(rs.getString("tipo")){
                    case "Corto":
                        System.out.println("Id campeonato: "+rs.getInt("Idcampeonato"));
                        System.out.println("Tipo de campeonato: corto");
                        System.out.println("Equipo campeón: "+rs.getString("Campeon"));
                        break;
                    default:
                        System.out.println("Id campeonato: "+rs.getInt("Idcampeonato"));
                        System.out.println("Tipo de campeonato: largo");
                        System.out.println("Equipo campeón: "+rs.getString("Campeon"));
                        break;
                }
                ps.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
    }
    
    public void subirCampeonato(Campeonato campeonato){
        boolean exito=false;
        String sql="INSERT INTO Campeonatos (Tipo,Campeon) VALUES (?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            if(campeonato.getClass().getName().substring(22).equals("06")){
                ps.setString(1,"Corto");
            }else{
                ps.setString(1,"Largo");
            }
            ps.setString(2,campeonato.getGanador().getNombre());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                campeonato.setIdcampeonato(rs.getInt(1));
                exito=true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al subir campeonato a la base de datos");
        }
        if(exito){
            JOptionPane.showMessageDialog(null,"Campeonato subido correctamente a la base de datos"+campeonato.getClass().getName().substring(22));
        }
    }
}
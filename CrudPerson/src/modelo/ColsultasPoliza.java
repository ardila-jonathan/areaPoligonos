
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ColsultasPoliza extends Conexion {
    
    
    //------METODO REGITRAR----------
    
    public boolean registrar(Poliza p){
    
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "insert into Poliza (numero,inicioVigencia,finVigencia,Persona_tipoDocumento,Persona_numeroDocumento) values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getNumero());
            ps.setString(2, p.getInicioVigencia());
            ps.setString(3, p.getFinVigencia());
            ps.setString(4, p.getPersona_tipoDocumento());
            ps.setString(5, p.getPersona_numeroDocumento());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        }
    }
    //------FIN REGITRAR----------
    
        //------MODIFICAR----------
    
    public boolean modificar(Poliza p){
    
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "update Poliza set inicioVigencia=?, finVigencia=? ,Persona_tipoDocumento=? ,Persona_numeroDocumento=? where numero=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getInicioVigencia());
            ps.setString(2, p.getFinVigencia());
            ps.setString(3, p.getPersona_tipoDocumento());
            ps.setString(4, p.getPersona_numeroDocumento());
            ps.setInt(5, p.getNumero());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        }
    }
    //------FIN MODIFICAR----------
    
            //------ELIMINAR----------
    
    public boolean eliminar(Poliza p){
    
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "delete from Poliza where numero=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getNumero());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        }
    }
    //------FIN ELIMINAR----------
    
                //------BUSCAR----------
    
    public boolean buscar(Poliza p){
    
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * from Poliza where numero=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getNumero());
            rs = ps.executeQuery();
            if(rs.next()){
                p.setNumero(Integer.parseInt(rs.getString("numero"))); 
                p.setInicioVigencia(rs.getString("inicioVigencia"));
                p.setFinVigencia(rs.getString("finVigencia"));
                p.setPersona_tipoDocumento(rs.getString("Persona_tipoDocumento"));
                p.setPersona_numeroDocumento(rs.getString("Persona_numeroDocumento"));
                return true;
            }
            return false;
        
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        }
    }
    //------FIN BUSCAR----------
    
    
    
}

package covidweb.modelDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import covidweb.config.Conexion;
import covidweb.modelo.Mensaje;
public class MensajeDao {
	 Conexion con = null;

	    public MensajeDao() {
	        
	        con = Conexion.getConexion();
	    }
	    
	    public void insertar(Mensaje mensaje){
	        String sql="insert into mensaje (nombre,email,website,mensaje) values('"+mensaje.getNombre()+"','"+mensaje.getEmail()+"','"+mensaje.getSitio()+"','"+mensaje.getMensaje()+"')";
	        try {
	            con.insert(sql);
	        } catch (SQLException ex) {
	            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    public Mensaje buscar(Mensaje mensaje){
	        Mensaje m = new Mensaje();
	        String sql="select * from mensaje where id='"+mensaje.getId()+"'";
	        try {
	          m = con.query(sql);
	        } catch (SQLException ex) {
	            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return m;
	    }
	    
	    public void delete(Mensaje mensaje){
	    String sql="delete from mensaje where id='"+mensaje.getId()+"'";
	    try {
	            con.delete(sql);
	        } catch (SQLException ex) {
	            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public void actualizar(Mensaje mensaje){
	    String sql="update mensaje set  nombre='"+mensaje.getNombre()+"', email='"+mensaje.getEmail()+"', website='"+mensaje.getSitio()+"', mensaje='"+mensaje.getMensaje()+"' where id='"+mensaje.getId()+"'";
	    try {
	            con.actualizar(sql);
	        } catch (SQLException ex) {
	            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}

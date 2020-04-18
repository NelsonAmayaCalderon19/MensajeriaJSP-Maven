package covidweb.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import covidweb.modelo.Mensaje;
public class Conexion {
	 private Statement statement;
	    private PreparedStatement ps;
	    private static Conexion bd;
	    private Connection con=null;
	    //private String driver = "org.gjt.mm.mysql.Driver";
	    private String url = "jdbc:mysql://localhost:3306/";
	    private String dbname = "mensajeria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    private String driver = "com.mysql.cj.jdbc.Driver";
	    private String username = "root";
	    private String password = "";
	    
	    public Conexion(){      
	      try{
	    	Class.forName(driver).newInstance();
	    	con = (Connection)DriverManager.getConnection(url+dbname,username,password);
	      }catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
	    	  e.printStackTrace();
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }
	         
	    }
	    public static Conexion getConexion(){
	        if(bd == null){
	           bd = new Conexion(); 
	        }
	        return bd;
	    }
	    public void cerrarConexion(){
	        try{
	            con.close();
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	    }
	    
	    
	    public Mensaje query(String query) throws SQLException{
	      Mensaje m = new Mensaje();
	         statement = bd.con.createStatement();
	        ResultSet res = statement.executeQuery(query);
	        while(res.next()){
	        m.setId(res.getInt(1));
	        m.setNombre(res.getString(2));
	        m.setEmail(res.getString(3));
	        m.setSitio(res.getString(4));
	        m.setMensaje(res.getString(5));
	        }
	        return m;
	    }
	    public void delete(String deleteQuery) throws SQLException{
	    statement = bd.con.createStatement();
	        int resdelete = statement.executeUpdate(deleteQuery);
	    }
	    public int insert(String insertQuery) throws SQLException{
	        statement = bd.con.createStatement();
	        int res = statement.executeUpdate(insertQuery);
	        return res;
	    }
	    
	    public int actualizar(String actQuery) throws SQLException{
	       Mensaje m = new Mensaje();
	    ps = bd.con.prepareStatement(actQuery);
	        int resact = ps.executeUpdate();
	        
	        return resact;
	    }
}

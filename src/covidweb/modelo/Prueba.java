package covidweb.modelo;
import java.sql.SQLException;

import covidweb.config.Conexion;
import covidweb.modelDao.MensajeDao;
//import covidweb.modelDao.MensajeDao;
public class Prueba {
public static void main(String[] args) throws SQLException{
        
    Conexion conexion = Conexion.getConexion();
    
    Mensaje m= new Mensaje();
    m.setNombre("Jose");
    m.setEmail("jose@gmail.com");
    m.setSitio("www.jose.com");
    m.setMensaje("Hola Como Estas");
    
    MensajeDao mdao = new MensajeDao();
    mdao.insertar(m);
        
    }
}

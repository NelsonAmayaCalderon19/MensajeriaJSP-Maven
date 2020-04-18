package covidweb.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import covidweb.modelDao.MensajeDao;
import covidweb.modelo.Mensaje;
import covidweb.modelo.Utility;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
response.setContentType("text/html;charset=UTF-8");
        
        
        request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");   
        Mensaje m = new Mensaje();
        MensajeDao mdao = new MensajeDao();
        
        if(menu.equalsIgnoreCase("Mensaje")){
            switch (accion){
                case "Enviar":
                    String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String website = request.getParameter("website");
        String message = request.getParameter("message");
                    
		m.setNombre(nombre);
		m.setMensaje(message);
		m.setSitio(website);
		m.setEmail(email);
		
		
		if(Utility.enviarCorreo(m)){
		
                mdao.insertar(m);
		request.getRequestDispatcher("index.jsp").forward(request, response);
                }else{
                response.getWriter().println("Error Enviando");
                }
                    break;
                case "Buscar":
                    String id = request.getParameter("id");                   
		m.setId(Integer.parseInt(String.valueOf(id)));
                m = mdao.buscar(m);
                request.setAttribute("mensaje", m);
                //request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                    case "Eliminar":
                    String iddelete = request.getParameter("id");                   
		m.setId(Integer.parseInt(String.valueOf(iddelete)));
                mdao.delete(m);

                request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                    case "Actualizar":
                        int idact =Integer.parseInt(request.getParameter("id"));  
                        String nombreact = request.getParameter("nombre");
        String emailact = request.getParameter("email");
        String websiteact = request.getParameter("website");
        String messageact = request.getParameter("message");
        
        m.setNombre(nombreact);
		m.setMensaje(messageact);
		m.setSitio(websiteact);
		m.setEmail(emailact);
                    m.setId(idact);
		 mdao.actualizar(m);
		request.getRequestDispatcher("index.jsp").forward(request, response);
                        break;
                default:
                    throw new AssertionError();
            }   
            request.getRequestDispatcher("formulario.jsp").forward(request, response);
            }
	}

}

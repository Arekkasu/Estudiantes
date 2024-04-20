package javaPostgres;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class InsertDetails
 */


// DEFINIR LA RUTA CON WEBSERVLET ("RUTA")
@WebServlet(name = "InserDetails", value = "/InserDetails")
public class InsertDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName(DbUtil.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        //HACIENDO USO DE LA BASE DE DATOS
        try{

            //OBTENIENOD CONECCION DE LA BASE DE DATOS
            Connection conn = DriverManager.getConnection(DbUtil.url,DbUtil.user,DbUtil.password);
            System.out.println("Conexion hecha");

                                                                                    //LA ? es el parametro que
                                                                                    // que recibira
            PreparedStatement st = conn.prepareStatement("insert into estudiante values (?, ?, ?, ?)");

            //OBTENIEDO LO QUE RECIBIMOS DE LA URL
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");


            // MANDAR LO QUE SE RECIBIO DEL LA URL AL prepraStatemantes == SQL QUERY

            st.setInt(1, Integer.valueOf(id));
            st.setString(2, nombre);
            st.setString(3, apellido);
            st.setString(4, email);

            //HACER ACCION
            st.executeUpdate();

            // CERRAR BASE DE DATOS
            st.close();
            conn.close();

            //ENVIARLO A LA SIGUIETNE RUTA

            /*
            *
            * PARAMETRO URL, INICIAN CON ? y se poner clave=valor y si son mas de uno se continua con &
            *
            * */
            response.sendRedirect("Success.jsp?msg=Insert");


        }catch (Exception e){
            System.out.println(e);
        }

    }



}

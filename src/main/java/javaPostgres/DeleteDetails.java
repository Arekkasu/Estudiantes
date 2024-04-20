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
 * Servlet implementation class DeleteDetails
 */
public class DeleteDetails extends HttpServlet {
	//private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		// SE COMPRUEBA SI ESTA LA CLASE DE LA CONEXION DE LA BASE DE DATOS
		try{
			Class.forName(DbUtil.driver);
		} catch (ClassNotFoundException error){
			System.out.println("Class not found" + error);
		}

		// EN ESTO SE HACE LA NUEVA PETICION A LA BASE DE DATOS
		try {

			Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);

			// VAMOS A PEDIR QUE SE ELIMENE EL ESTUDIANTE QUE ESTE EN EL CODIGO
			PreparedStatement st = conn.prepareStatement("delete from estudiante where est_id=?");

			String id = request.getParameter("id");

			st.setInt(1, Integer.valueOf(id));

			st.executeUpdate();
			st.close();
			conn.close();

			response.sendRedirect("Success.jsp?msg=Delete");


		} catch (Exception error){
			error.printStackTrace();
		}



	}

}

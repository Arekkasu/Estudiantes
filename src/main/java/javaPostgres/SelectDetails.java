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
import java.sql.ResultSet;

/**
 * Servlet implementation class SelectDetails
 */
public class SelectDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			System.out.println("ENTRO");
			Class.forName(DbUtil.driver);
		}catch (ClassNotFoundException error){
			System.out.println("Class not found: " + error);
			System.out.println("ERROR");
		}

		try{

			int id = 0;
			String nombre = "", apellido = "", email = "";
			Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
			System.out.println("Conexion hecha");
			PreparedStatement st = conn.prepareStatement("select * from estudiante where est_id=?");


			//ESCOGE EL PRIMER PARAMETRO DE LA URL ID=?
			st.setInt(1, Integer.valueOf(request.getParameter("id")));

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				System.out.println("EJECUTADO");
				id = rs.getInt(1);
				nombre = rs.getString(2);
				apellido = rs.getString(3);
				email = rs.getString(4);

			}

			rs.close();
			st.close();
			conn.close();

			response.sendRedirect("Result.jsp?id=" + id + "&nombre=" + nombre + "&apellido=" + apellido
			+ "&email=" + email);



		}catch(Exception error){
			System.out.println(error);
		}


	}


}

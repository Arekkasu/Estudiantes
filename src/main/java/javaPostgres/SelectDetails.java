package javaPostgres;

import com.sun.jdi.request.ClassPrepareRequest;
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

public class SelectDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try{

			Class.forName(DbUtil.driver);

		}catch(ClassNotFoundException error) {
			System.out.println("CLASE NO ENCOTNRADA: " + error);
		}

		try{

			// DEFINIENDO VALORES EN 0;
			int id = 0;
			String nombre = "", apellido = "", email = "";

			// A PARTIR DEL ID QUE SE PONE EN CONSULTA SE OBTENDRA TODAS LAS COLUMNAS QUE HAY
			// EN ESTUDIANTES (id,nombre,apellido, email)

			Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);

			PreparedStatement st = conn.prepareStatement("select * from estudiante where est_id=?");


			st.setInt(1, Integer.valueOf(request.getParameter("id")));

			//la sentencia de rs es como obtener lo que se ejecuta del Query sql, por
			//lo cual se usaria el metodo rs.next() que es similar a ejecutalo y dime si funciona
			// es un booleano osea True si se ejecuto bien la Query o False si no se ejecuto bien

			// rs es una obejeto de  estrura de dato Resultset y tendra como valor
			// st.executeQuery
			ResultSet rs = st.executeQuery();

			while(rs.next()){


				// LOS NUMEROS SON LAS COLUMNAS QUE SE RECIBIERON de la peticion SQL

				id = rs.getInt(1);
				nombre = rs.getString(2);
				apellido = rs.getString(3);
				email = rs.getString(4);

			}

			rs.close();
			st.close();
			conn.close();


			response.sendRedirect("Result.jsp?id=" + id + "&nombre=" + nombre +
					"&apellido=" + apellido + "&email=" + email);

		}catch (Exception error) {
			System.out.println(error);
		}

	}

}

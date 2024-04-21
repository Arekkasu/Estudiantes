package javaPostgres;

import jakarta.servlet.ServletException;
<<<<<<< HEAD
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

=======
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
>>>>>>> upgrading
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

<<<<<<< HEAD
public class UpdateDetails extends HttpServlet {

    //private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName(DbUtil.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");
            PreparedStatement st = conn.prepareStatement(
                    "update estudiante set est_nombre=?, est_apellido=?, est_email=? where est_id=?");

            st.setString(1, request.getParameter("nombre"));
            st.setString(2, request.getParameter("apellido"));
            st.setString(3, request.getParameter("email"));
            st.setInt(4, Integer.valueOf(request.getParameter("id")));

            st.executeUpdate();

            st.close();
            conn.close();

            response.sendRedirect("Success.jsp?msg=Update");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

=======
/**
 * Servlet implementation class UpdateDetails
 */
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			Class.forName(DbUtil.driver);
		} catch (ClassNotFoundException error){
			System.out.println("Class not found" + error);
		}

		try {

			Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);

			PreparedStatement st = conn.prepareStatement(
					"update estudiante set est_nombre=?, est_apellido=?, est_email=? where est_codigo=?"
			);

			st.setString(1, request.getParameter("nombre"));
			st.setString(2, request.getParameter("apellido"));
			st.setString(3, request.getParameter("email"));
			st.setInt(4, Integer.valueOf(request.getParameter("id")));

			st.executeUpdate();
			st.close();
			conn.close();


			response.sendRedirect("Success.jsp?msg=Update");
		} catch (Exception error){
			error.printStackTrace();
		}


	}

}
>>>>>>> upgrading

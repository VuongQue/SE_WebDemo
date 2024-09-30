package Controller;

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class UserServlet
 */

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String identity_card = request.getParameter("identity_card");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=user_db;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
            Connection conn = DriverManager.getConnection(url);
            String sql = "INSERT INTO users (name, birthdate, gender, address, identity_card, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, birthdate);
            stmt.setString(3, gender);
            stmt.setString(4, address);
            stmt.setString(5, identity_card);
            stmt.setString(6, email);
            stmt.setString(7, phone);
            stmt.executeUpdate();
            

            stmt.close();
            conn.close();


            request.getRequestDispatcher("/WEB-INF/Views/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

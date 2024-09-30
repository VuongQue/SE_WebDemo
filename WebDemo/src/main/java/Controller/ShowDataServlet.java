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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.User;

/**
 * Servlet implementation class ShowDataServlet
 */

public class ShowDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=user_db;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
            Connection conn = DriverManager.getConnection(url);

            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, birthdate, gender, address, identity_card, email, phone FROM users");

            // Tạo danh sách người dùng
            List<User> userList = new ArrayList<>();


            while (rs.next()) {
                User user = new User(
                    rs.getString("name"),
                    rs.getString("birthdate"),
                    rs.getString("gender"),
                    rs.getString("address"),
                    rs.getString("identity_card"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
                userList.add(user);
            }

           
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/WEB-INF/Views/showData.jsp").forward(request, response);

            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

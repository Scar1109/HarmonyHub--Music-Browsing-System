package usermanage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String uName = request.getParameter("uName");	
		String uPass = request.getParameter("uPass");

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a database connection (you need to replace these with your database credentials)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanage", "root", "");

            // Create a SQL query to retrieve a user with the given username and password
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, uName);
            st.setString(2, uPass);

            // Execute the query
            resultSet = st.executeQuery();

            if (resultSet.next()) {
            	// Successful login, you can forward to a success page (e.g., index.jsp)
            	RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            	rd.forward(request, response);
            } else {
                // Invalid login, you can redirect to an error page (e.g., error.html)
                response.sendRedirect("error.html");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) resultSet.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

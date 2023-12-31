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
            Class.forName("com.mysql.cj.jdbc.Driver");
		     conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanage","root","");

            // Create a SQL query to retrieve a user with the given username and password
            String sql = "SELECT * FROM user1 WHERE uName = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, uName);
            
            // Execute the query
            resultSet = st.executeQuery();

            if (resultSet.next()) {
            	
            	String userName = resultSet.getString("uName");
            	String fName = resultSet.getString("fName");
            	String lName = resultSet.getString("lName");
            	String email =  resultSet.getString("uEmail");
            	String uCountry =  resultSet.getString("uCountry");
            	String uCity =  resultSet.getString("uCity");
            	String uDOB =  resultSet.getString("uDOB");
            	// Successful login, you can forward to a success page (e.g., index.jsp)
            	user user1 = new user(userName,fName,lName,email,uCountry,uCity,uDOB);
            	
            	request.setAttribute("user", user1);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            	
            } else {
            	
                // Invalid login, you can redirect to an error page (e.g., error.html)
                response.sendRedirect("error.jsp");
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

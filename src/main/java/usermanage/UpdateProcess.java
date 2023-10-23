package usermanage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProcess")
public class UpdateProcess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateProcess() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uID = request.getParameter("uID");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String uGen = request.getParameter("uGen");
        String uDOB = request.getParameter("uDOB");
        String uEmail = request.getParameter("uEmail");
        String uMember = request.getParameter("uMember");
        String uName = request.getParameter("uName");
        String uPass = request.getParameter("uPass");
        String uCountry = request.getParameter("uCountry");
        String uCity = request.getParameter("uCity");

        if (uID != null) {
            Connection con = null;
            PreparedStatement ps = null;
            int personID = Integer.parseInt(uID);
            try {
                String driverName = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/usermanage";
                String user = "root";
                String psw = "";

                Class.forName(driverName);
                con = DriverManager.getConnection(url, user, psw);
                String sql = "UPDATE user1 SET fName=?, lName=?, uGen=?, uDOB=?, uEmail=?, uMember=?, uName=?, uPass=?, uCountry=?, uCity=? WHERE uID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, fName);
                ps.setString(2, lName);
                ps.setString(3, uGen);
                ps.setString(4, uDOB);
                ps.setString(5, uEmail);
                ps.setString(6, uMember);
                ps.setString(7, uName);
                ps.setString(8, uPass);
                ps.setString(9, uCountry);
                ps.setString(10, uCity);
                ps.setInt(11, personID);

                int i = ps.executeUpdate();
                if (i > 0) {
                    RequestDispatcher rd = request.getRequestDispatcher("ManageUser.jsp");
                    rd.forward(request, response);
                } else {
                    response.getWriter().write("There is a problem in updating Record.");
                }
            } catch (SQLException e) {
                request.setAttribute("error", e);
                response.getWriter().write(e.toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

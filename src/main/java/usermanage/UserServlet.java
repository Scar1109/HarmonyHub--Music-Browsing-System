package usermanage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserServlet") 
public class UserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
	
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
		
		
		 Connection conn = null;
		    
		    try {
		    	String sql = "insert into user1(fName,lName,uGen,uDOB,uEmail,uMember,uName,uPass,uCountry,uCity) values(?,?,?,?,?,?,?,?,?,?)";
		    	Class.forName("com.mysql.cj.jdbc.Driver");
			     conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanage","root","");
			    PreparedStatement st = conn.prepareStatement(sql);
			   

			    st.setString(1, fName);
			    st.setString(2, lName);			    
			    st.setString(3, uGen);			    
			    st.setString(4, uDOB);	
			    st.setString(5, uEmail);
			    st.setString(6, uMember);			    
			    st.setString(7, uName);			    
			    st.setString(8, uPass);
			    st.setString(9, uCountry);
			    st.setString(10, uCity);			    			    

			     int row = st.executeUpdate();
			     
			    System.out.println("db connected!!");

		        if (row > 0) {
		          System.out.println("File uploaded and saved into database");
		          
		          
					
		          
		          RequestDispatcher rd = request.getRequestDispatcher("/ManageUser.jsp");
		          
		          rd.include(request, response);
		        }
		       
		    }catch (Exception e) {
				e.printStackTrace();

      } 		
	} 	
} 




<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%
	String uID = request.getParameter("uID");
	int no = Integer.parseInt(uID);
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanage","root","");
	Statement stat = conn.createStatement();
	stat.executeUpdate("delete from user1 where uID ='" +uID+"'");
	response.sendRedirect("ManageUser.jsp");
	%>
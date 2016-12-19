package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "This is a login Servlet", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		//printer
		try(PrintWriter web = response.getWriter()){
		//	request.getRequestDispatcher("navigation.html").include(request, response);
			// här får vi html name
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			//Databasanslutning

			try {
				// koplas till localhost
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost/register";
				Connection con = DriverManager.getConnection(url, "root", "");
				//prepared statement takes email och password
				PreparedStatement pstmt = con.prepareStatement("select custemers.email , custemers.password from custemers "
						+ "where email = ? AND password = ?");
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				
				ResultSet rs = pstmt.executeQuery();
					
				web.println("<html>");
				web.println("<body>");
				// om entered mail och password finns i databasen ska skriva wälkomen
				if(rs.next()){
					pstmt.setString(1, email);
					pstmt.setString(2, password);
web.print("welcomen ");
					

					
				}
				//annars felaktig input
				else {
					web.println("Wrong password");
				}
				
				web.println("</body>");
				web.println("</html>");
				con.close();
				pstmt.close();
				
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//Kolla i databasen om lössenordet stämmer med användarnamnet
			
			//Om den stämmer så start en session
			
			
			
			

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

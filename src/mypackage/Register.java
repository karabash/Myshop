package mypackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// får vi alla name från register.html
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name1");
		String surname = request.getParameter("surname1");
		String email = request.getParameter("email1");
		String address = request.getParameter("address1");
		String password = request.getParameter("password1");
		int postnr = Integer.parseInt(request.getParameter("postnr1"));
		try {

// connection till våra database
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/register";
			Connection con = DriverManager.getConnection(url, "root", "");
			PreparedStatement pstmt	= con.prepareStatement("insert into custemers ( name, surname , email, address, postnr, password) values (?,?,?,?,?,?)" );
			pstmt.setString(1, name);
			pstmt.setString(2, surname);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setInt(5, postnr);
			pstmt.setString(6, password);
			pstmt.executeUpdate();

			con.close();
			pstmt.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// när user klar skickar till index.html
		response.sendRedirect("index.html"); // skickar till login sidan

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

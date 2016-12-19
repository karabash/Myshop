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
 * Servlet implementation class Buyer
 */
@WebServlet("/Buyer")
public class Buyer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buyer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String colors = request.getParameter("colors");
	   String amount = request.getParameter("amount");
		String size = request.getParameter("size");
		PrintWriter web = response.getWriter();
				
 
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					String url = "jdbc:mysql://localhost/register";
					Connection con = DriverManager.getConnection(url, "root", "");
					PreparedStatement pstmt = con.prepareStatement("select shoes.size , shoes.color"
							+" from shoes where (size like? AND color like? )");
						pstmt.setString(1, "'%"+size+"%'");
						pstmt.setString(2, "%"+colors+"%");

						ResultSet rs = pstmt.executeQuery();

						System.out.println("size is: "+size+"/n color is: "+colors );
					web.println("<html>");
					web.println("<body>");
					
					if (!rs.next()){
						pstmt.setString(1, "'%"+size+"%'");
						pstmt.setString(2, "%"+colors+"%");
						
web.print("dsadsaasddsads");
					
					}
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doGet(request, response);
			
	}

}

package my.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.classes.ConnectionFactory;


@WebServlet("/productDelete")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("test product delete");
			
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		try {
			ConnectionFactory pool = new ConnectionFactory();
			Connection connection = pool.retrieveConnection();
			
			PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUCTS WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
			
			stm.setInt(1, id);
			stm.execute();
			
			System.out.println("Product deleted");
			
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		response.sendRedirect("productList");
	}
}

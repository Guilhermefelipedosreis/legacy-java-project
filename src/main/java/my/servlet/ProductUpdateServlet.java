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


@WebServlet("/productUpdate")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String paramPrice = request.getParameter("price");
		Float price = Float.valueOf(paramPrice);
		String paramQuantity = request.getParameter("quantity");
		Integer quantity = Integer.valueOf(paramQuantity);
		
		try {
			ConnectionFactory pool = new ConnectionFactory();
			Connection connection = pool.retrieveConnection();
			
			PreparedStatement stm = connection.prepareStatement("UPDATE PRODUCTS SET name = ?, description = ?, price = ?, quantity = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
			
			updateProduct(id, name, description, price, quantity, stm);
			
			System.out.println("Product updated");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("productList");
	}
	
	private static void updateProduct(int id, String name, String description, double price, int quantity, PreparedStatement stm) throws SQLException {
		
		stm.setInt(5, id); //id is the last item in the query, "where id=?"
		stm.setString(1, name);
		stm.setString(2, description);
		stm.setDouble(3, price);
		stm.setInt(4, quantity);
		
		stm.execute();
		
	}

}

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


@WebServlet("/productInsert")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("test product insert");
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String paramPrice = request.getParameter("price");
		Float price = Float.valueOf(paramPrice);
		String paramQuantity = request.getParameter("quantity");
		Integer quantity = Integer.valueOf(paramQuantity);
		
		try {
			ConnectionFactory pool = new ConnectionFactory();
			Connection connection = pool.retrieveConnection();
			
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUCTS (NAME, DESCRIPTION, PRICE, QUANTITY) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			addProduct(name, description, price, quantity, stm);
				
			System.out.println("Product inserted!");
					
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("productList");
	}
	
//	public void main(String[] args) throws SQLException, ClassNotFoundException {
//		
//		ConnectionFactory pool = new ConnectionFactory();
//		Connection connection = pool.retrieveConnection();
//		
//		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUCTS (NAME, DESCRIPTION, PRICE, QUANTITY) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//		
//		addProduct(name, description, price, quantity, stm);
//			
//		System.out.println("Product inserted!");
//				
//		connection.close();
//	}
	
	private static void addProduct(String nome, String description, double price, int quantity, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, description);
		stm.setDouble(3, price);
		stm.setInt(4, quantity);
		
		stm.execute();
	}
}

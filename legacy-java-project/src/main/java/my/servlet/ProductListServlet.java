package my.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.classes.ConnectionFactory;
import my.model.Product;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> list = null;
		try {
			list = ProductListServlet.listProduct();
		} catch (SQLException e) {
			System.out.println("failed to find list/SQLException");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		request.setAttribute("products", list);	
		
		RequestDispatcher rd = request.getRequestDispatcher("/crudTable.jsp");		
		rd.forward(request, response);
	}
	
	public static List<Product> listProduct() throws SQLException, ClassNotFoundException {
		
		 List<Product> list = new ArrayList<>();
		 		
		ConnectionFactory pool = new ConnectionFactory();
		Connection connection = pool.retrieveConnection();
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NAME, DESCRIPTION, PRICE, QUANTITY FROM PRODUCTS;");
		stm.execute();		
		
		ResultSet rst = (ResultSet)stm.getResultSet();
				
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.print(id + ", ");
			String name = rst.getString("NAME");
			System.out.print(name + ", ");
			String description = rst.getString("Description");
			System.out.print(description + ", ");
			Float price = rst.getFloat("PRICE");
			System.out.print(price + ", ");
			Integer quantity = rst.getInt("QUANTITY");
			System.out.println(quantity);
			
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);
			product.setQuantity(quantity);
			
			list.add(product);
			
		}
		connection.close();
		return list;
	}
}

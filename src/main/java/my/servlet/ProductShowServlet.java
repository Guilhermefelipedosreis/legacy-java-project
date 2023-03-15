package my.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.model.Product;

@WebServlet("/ProductShow")
public class ProductShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String paramPrice = request.getParameter("price");
		Float price = Float.valueOf(paramPrice);
		String paramQuantity = request.getParameter("quantity");
		Integer quantity = Integer.valueOf(paramQuantity);
		
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		
		request.setAttribute("product", product);		
		RequestDispatcher rd = request.getRequestDispatcher("/updateProduct.jsp");
		rd.forward(request, response);
			
			
			
		
		System.out.println("test product show servlet");
		
	}

}

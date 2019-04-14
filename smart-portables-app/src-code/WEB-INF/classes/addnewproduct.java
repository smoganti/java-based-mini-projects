import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class addnewproduct extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter pw = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		pw.println("<html><head>");
		pw.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
		pw.println("<title>Smart Portables</title>");
		pw.println("<link rel='shortcut icon' href='images/icon.jpg'/>");
		pw.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div id='container'>");
		pw.println("<header>");
		pw.println("<h1><a href='/'>Smart <span> Portables</span></a></h1>");
	  pw.println("<marquee>Grab a coffee and order your favorite products on the Internet !</marquee>");
		pw.println("</header>");
		pw.println("<nav>");
		pw.println("<ul>");
		pw.println("<li  class=''><a href='managestore'>Add Products</a></li>");
		pw.println("<li class=''><a href='modifyproduct'>Modify Product</a></li>");
		pw.println("<li class=''><a href='deleteproduct'>Delete Product</a></li>");

		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		if (role == null) {
			pw.println("<li class='' ><a href='login'>Sign in</a></li>");
		} else {
			pw.println("<li class=''>");
			pw.println("<a href='signout'> Sign Out </a>");
			pw.println("</li >");
		}

		pw.println("</ul>");
		pw.println("</nav>");
		try {
			String productid = request.getParameter("product_id");
			String display_under = request.getParameter("display_under");
			String productname = request.getParameter("product_name");
			int price = Integer.parseInt(request.getParameter("price"));
			String description = request.getParameter("description");
			int quantity = 100;
			Double discount_amt = 0.0;
			Double rebate_amt = 0.0;



			Product product =  new Product();
			product.setId(productid);
			product.setName(productname);
			product.setDescription(description);
			product.setDisplay_under(display_under);
			product.setImageUrl("images/noimage.jpg");
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setDiscounAmt(discount_amt);
			product.setRebateAmt(rebate_amt);


		    MySQLDataStoreUtilities.addnewProduct(product);

				pw.println("<div id='body'>");
				pw.println("<section id='content'>");
				pw.println("<div id='container'>");
			pw.println("<h3><br /><br />The Product has been added succesfully </h3><br /><br />");

			pw.println("</div>");
			pw.println("</section>");
			pw.println("</div>");
		} catch (Exception e) {
			e.printStackTrace();
			//pw.println("<h3><br /><br />Error Adding Product, Please check input parameters and try again!</h3><br /><br />");
		}

		pw.println("<aside class='sidebar'>");
		pw.println("<ul>");
		pw.println("<li>");
		pw.println("<h4>Options</h4>");
		pw.println("<ul>");
		pw.println("<li  class=''><a href='managestore'>Add Products</a></li>");
		pw.println("<li class=''><a href='modifyproduct'>Modify Product</a></li>");
		pw.println("<li class=''><a href='deleteproduct'>Delete Product</a></li>");
		pw.println("</ul>");
		pw.println("</li>");
		pw.println("<li>");
		pw.println("<h4>About us</h4>");
		pw.println("</li>");
		pw.println("<li>");
		pw.println("<h4>Helpful Link</h4>");
		pw.println("<ul>");
		pw.println("<li><a href='http://www.google.com/' title='google'>Google Website</a></li>");
		pw.println("<li><a href='http://www.javatpoint.com/' title=' learn java'>Learn Java here</a></li>");
		pw.println("</ul></li></ul></aside>");
		pw.println("<div class='clear'></div>");

		pw.println("<br /> <br />");
		pw.println("<footer>");
		pw.println("<div class='footer-content'>");
		pw.println("<div class='clear'></div>");
		pw.println("</div>");
		pw.println("<div class='footer-bottom'>");
		pw.println("<p>&copy Smart Portables </p>");
		pw.println("</div>");
		pw.println("</footer>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");

	}
}

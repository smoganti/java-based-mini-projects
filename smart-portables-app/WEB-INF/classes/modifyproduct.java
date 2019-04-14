import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class modifyproduct extends HttpServlet {

	  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

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
	pw.println("<h1><a href='/'>Smart <span>Portables</span></a></h1>");
  pw.println("<marquee>Grab a coffee and order your favorite products on the Internet !</marquee>");
	pw.println("</header>");
	pw.println("<nav>");
	pw.println("<ul>");
	pw.println("<li  class=''><a href='managestore'>Add Products</a></li>");
	pw.println("<li class=''><a href='modifyproduct'>Modify Product</a></li>");
	pw.println("<li class=''><a href='deleteproduct'>Delete Product</a></li>");

	HttpSession session = request.getSession();
	String role=(String)session.getAttribute("role");
	if (role == null)
	{
	pw.println("<li class='' ><a href='login'>Sign in</a></li>");
	}
	else
	{
		pw.println("<li class=''>");
		pw.println("<a href='signout'> Sign Out </a>");
		pw.println("</li >");
	}

	pw.println("</ul>");
	pw.println("</nav>");

	pw.println("<div id='body'>");
	pw.println("<section id='content'>");
	pw.println("<div id='container'>");

	if(role!=null){
	pw.println("<br /><h3>Hello  "+role+"</h3>");
	}
	pw.println("<form action='modifyproduct' METHOD='Post'>");

	pw.println("<table>");
	pw.println("<tr>");
	pw.println("<td> Enter Product ID which you want to change :-</td>");
	pw.println("<td> <input type='text' name='oldproduct_id' ></td>");
	pw.println("</tr>");
	pw.println("<tr>");
	pw.println("<td> New Product ID :-</td>");
	pw.println("<td> <input type='text' name='newproduct_id' ></td>");
	pw.println("</tr>");
	pw.println("<tr>");
	pw.println("<td> Display Under:-</td>");
	pw.println("<td><select name='display_under'><option value='Smart Phones'>Phones</option><option value='smartWatch'>Smartwatches</option><option value='Speaker'>Speakers</option><option value='Laptop'>Laptops</option><option value='memory'>Memory Card</option><option value='Pendrive'>Flash drive</option><option value='storage'>Hard Drives</option><option value='Headphone'>Head phones</option></select></td>");
	pw.println("</tr>");

	pw.println("<tr>");
	pw.println("<td> Product Model Name :-</td>");
	pw.println("<td> <input type='text' name='product_name' ></td>");
	pw.println("</tr>");
	pw.println("<tr>");
	pw.println("<td> Product Price :- </td>");
	pw.println("<td> $<input type='text' name='price' ></td>");
	pw.println("</tr>");
	pw.println("<tr>");
	pw.println("<td> Rebate Amount  :- </td>");
	pw.println("<td> $<input type='text' name='rebateAmt' ></td>");
	pw.println("</tr>");
	pw.println("<tr>");
	pw.println("<td> Discount Price :- </td>");
	pw.println("<td> $<input type='text' name='discountAmt' ></td>");
	pw.println("</tr>");
	pw.println("<tr>");
	pw.println("<td> Quantity :- </td>");
	pw.println("<td> $<input type='text' name='quantity' ></td>");
	pw.println("</tr>");
	pw.println("<tr>");
	pw.println("<td> Product Description:-</td>");
	pw.println("<td>  <input type='text' name='description' ></td>");
	pw.println("</tr>");

	pw.println("<tr>");
	pw.println("<td colspan='2' align='center'>");
	pw.println("<input class = 'submit-button' type = 'submit'  value = 'Modify Product'></form>");
	pw.println("</td>");
	pw.println("</tr>");
	pw.println("</tr></table>");
				pw.println("</div>");
				pw.println("</section>");
				pw.println("</div>");

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


//POST METHOD **********************//
public void doPost(HttpServletRequest request,
								HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");

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
pw.println("<h1><a href='/'>Smart <span>Portables</span></a></h1>");
pw.println("<marquee>Grab a coffee and order your favorite products on the Internet !</marquee>");
pw.println("</header>");
pw.println("<nav>");
pw.println("<ul>");
pw.println("<li  class=''><a href='managestore'>Add Products</a></li>");
pw.println("<li class=''><a href='modifyproduct'>Modify Product</a></li>");
pw.println("<li class=''><a href='deleteproduct'>Delete Product</a></li>");

HttpSession session = request.getSession();
String role=(String)session.getAttribute("role");
if (role == null)
{
pw.println("<li class='' ><a href='login'>Sign in</a></li>");
}
else
{
pw.println("<li class=''><div class='dropdown'><a>More Options</a >");
pw.println("<div class='dropdown-content' >");
pw.println("<a href='inventory'>Inventory </a >");
pw.println("<a href='salesreport'>Sales Report </a >");
pw.println("<a href='signout'> Sign Out </a>");
pw.println("</div >");
pw.println("</div >");
pw.println("</li >");
}

pw.println("</ul>");
pw.println("</nav>");

pw.println("<div id='body'>");
pw.println("<section id='content'>");
pw.println("<div id='container'>");


try {
	String oldproductid = request.getParameter("oldproduct_id");
	String newproductid = request.getParameter("newproduct_id");
	String display_under = request.getParameter("display_under");
	String productname = request.getParameter("product_name");
	int price = Integer.parseInt(request.getParameter("price"));
	String description = request.getParameter("description");
	int quantity = Integer.parseInt(request.getParameter("quantity"));;
	Double discount_amt = Double.parseDouble(request.getParameter("discountAmt"));
	Double rebate_amt = Double.parseDouble(request.getParameter("rebateAmt"));

	Map<String,Product> tempMap = MySQLDataStoreUtilities.getProductDetails();

	String url = tempMap.get(oldproductid).getImageUrl();

	Product product =  new Product();
	product.setId(newproductid);
	product.setName(productname);
	product.setDescription(description);
	product.setDisplay_under(display_under);
	product.setPrice(price);
	product.setQuantity(quantity);
	product.setDiscounAmt(discount_amt);
	product.setRebateAmt(rebate_amt);
	product.setImageUrl(url);


		MySQLDataStoreUtilities.modifyProduct(product,oldproductid);


	pw.println("<h3><br /><br />The Product has been Modified succesfully </h3><br /><br />");
} catch (Exception e) {
	e.printStackTrace();
	//pw.println("<h3><br /><br />Error Adding Product, Please check input parameters and try again!</h3><br /><br />");
}

		pw.println("</div>");
		pw.println("</section>");
		pw.println("</div>");

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

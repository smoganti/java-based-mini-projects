import java.io.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.util.*;

public class DealMatches extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request,response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{

			HttpSession session = request.getSession(false);
			Map<String,Product> pMap = new HashMap<String,Product>();
			pMap =  MySQLDataStoreUtilities.getProductDetails();
			Map<String,Product> dmProducts = new HashMap<String,Product>();
			String line = null;


			PrintWriter pw = response.getWriter();


				RequestDispatcher rd = request.getRequestDispatcher("topnav.html");
				rd.include(request, response);

				String role = (String) session.getAttribute("role");

				if (role == null)
				{
				pw.println("<li class=''><a href='register'>Register</a></li>");
				pw.println("<li class='' ><a href='login'>Sign in</a></li>");
				}
				  else if (role.equals("SalesManager")){
						pw.println("<li class=''><div class='dropdown'><a>More Options</a >");
		 			 pw.println("<div class='dropdown-content' >");
		 			 pw.println("<a href='register'>Register Customer</a >");
					 pw.println("<a href='inventory'>Inventory </a >");
		       pw.println("<a href='salesreport'>Sales Report </a >");
		 			 pw.println("<a href='signout'> Sign Out </a>");
		 			 pw.println("</div >");
		 			 pw.println("</div >");
		 			 pw.println("</li >");
			      	  } else
				{
					pw.println("<li class='' ><a href='signout'>Sign Out</a></li>");
				}


				pw.println("<li class='' ><a href='vieworders'>View Orders</a></li>");


				pw.println("<div align='right'>");
			  cart mycart;
					 mycart = (cart) session.getAttribute("cart");

					if ( mycart == null)

					{

						pw.println("<li class='' ><a href='viewcart'><i class='glyphicon glyphicon-shopping-cart'></i>(0)</a></li>");
					}

					else {
			      pw.println("<li class='' ><a href='viewcart'><i class='glyphicon glyphicon-shopping-cart'></i>("+mycart.numberofitems()+")</a></li>");
			    }

				pw.println("</div>");
				pw.println("</ul>");
				pw.println("</nav>");



				pw.println("<div id='body'>");
				pw.println("<section id='content'>");
				pw.println("<article>");

				pw.println("<table>");
				pw.println("<tr>");
				pw.println("<td>");
				pw.println("<h1 style=\"color: #777;border-bottom: 2px solid #777;\">Deal Match</h1>");
				pw.println("</td>");
				pw.println("</tr>");
				pw.println("</table>");


				pw.println("<table class=\"wrapper\">");

				for(Map.Entry<String, Product> entry : pMap.entrySet()){
				if(dmProducts.size()<2 && !dmProducts.containsKey(entry.getKey())){
					BufferedReader reader = new BufferedReader(new FileReader (new File("C:\\apache-tomcat-7.0.34\\webapps\\CSP584_A20392260\\DealMatches.txt")));
					line=reader.readLine();
					if(line==null){
						pw.println("<tr style=\"padding: 0px;\">");
						pw.println("<td align=\"center\" style=\"width:100%;padding: 0px;\">");
						pw.println("<p style=\"font-size:27px;font-weight:bold;color:Red;padding: 0px;line-height: 110%;\">");
						pw.println("Currently there are no deals to display!");
						pw.println("</p>");
						pw.println("</td>");
						pw.println("</tr>");
						break;
					}
					else{
					    Product product = entry.getValue();

						do{

							if(line.contains(product.getName())){

									dmProducts.put(entry.getKey(),entry.getValue());

								pw.println("<tr style=\"padding: 0px;\">");
								pw.println("<td align=\"center\" style=\"width:50%;padding: 0px;\">");
								pw.println("<p style=\"font-size:22px;font-weight:bold;color:black;padding: 0px;line-height: 110%;\">");
								pw.println(product.getName()+" "+product.getDescription());
								pw.println("</p>");
								pw.println("</td>");
								pw.println("<td align=\"center\" style=\"width:50%;padding: 0px;\">");
								pw.println("<p style=\"font-size:22px;font-weight:bold;color:black;padding: 0px;\">");
								pw.println("Deal From Our Local Competitor:");
								pw.println("</p>");
								pw.println("</td>");
								pw.println("</tr>");
								pw.println("<tr style=\"padding: 0px;\">");
								pw.println("<td style=\"width:50%;padding: 0px;\" >");
								pw.println("<table class=\"wrapper\">");
								pw.println("<tr>");
								pw.println("<td>");
								pw.println("<img src=\""+product.getImageUrl()+"\" height=\"260px\" width=\"280px\"/>");
								pw.println("</td>");
								pw.println("<td >");
								pw.println("<h2>");
								pw.println("Buy New");
								pw.println("</h2>");
								pw.println("<br/>");
								pw.println("<br/>");
								pw.println("<h3>");
								pw.println("<em>$</em>");
								pw.println("<span style=\"font-size:26px;font-weight:bold;color:black\">"+product.getPrice()+"<span>");
								pw.println("</h3>");
								pw.println("<br/>");
								pw.println("<td>");
								pw.println("<form class = 'submit-button' method = 'get' action = 'addtocart'>");
								pw.println("<i class='glyphicon glyphicon-shopping-cart'></i>");
								pw.println("<input class = 'submit-button' type = 'submit' name = 'Smartphone_Original' value = ' Add to Cart'>");
								pw.println("<input type='hidden' name='model' value='" + product.getName() + "'>");
								pw.println("<input type='hidden' name='price' value='" + product.getPrice() + "'>");
								pw.println("<input type='hidden' name='imageUrl' value='" + product.getImageUrl() + "'>");
								pw.println("<input type='hidden' name='quantity' value='" + 1 + "'>");
								pw.println("</form>");
								pw.println("</td>");
								pw.println("</a>");
								pw.println("<td>");
								pw.println("<form class = 'submit-button' method = 'get' action = 'prodinfo'>");
								pw.println("<input class = 'submit-button' type = 'submit' name = 'Smartphone_Original' value = ' More Details'>");
								pw.println("<input type='hidden' name='model' value='" + product.getId() + "'>");
								pw.println("<input type='hidden' name='quantity' value='" + 1 + "'>");
								pw.println("</form>");
								pw.println("</td>");

								pw.println("<td style=\"border-right: dashed #888;\"></td>");
								pw.println("</tr>");
								pw.println("</table>");
								pw.println("</td>");
								pw.println("<td style=\"width:50%;\">");
								pw.println("<p style=\"font-size:19px;font-weight:bold;line-height: 110%;text-align: justify\">"+line+"</p>");
								pw.println("</td>");
								pw.println("</tr>");
								pw.println("<tr>");
								pw.println("<td colspan=\"3\" style=\"border-bottom: dashed #888;\"></td>");
								pw.println("</tr>");
								pw.println("<tr>");
								pw.println("<td colspan=\"3\"></td>");
								pw.println("</tr>");
								break;
							}
						}while((line = reader.readLine()) != null);
					}
				}
				}

				pw.println("</table>");

				pw.println("</article>");
				pw.println("</section>");
				pw.println("</div>");





		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher sd = request.getRequestDispatcher("sidebarfooter.html");
		sd.include(request, response);
	}
}

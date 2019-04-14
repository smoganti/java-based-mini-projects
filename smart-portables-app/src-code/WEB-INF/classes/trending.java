
import java.util.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class trending extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				processRequest(request,response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			String product_id = request.getParameter("product_id");
			HttpSession session = request.getSession(false);
			String role =(String) session.getAttribute("role");
			Map<String,Product> pMap = (HashMap<String,Product>)ProductUtility.getProductMap();

			Product product = pMap.get(product_id);

			PrintWriter pw = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");

		RequestDispatcher tnav = request.getRequestDispatcher("topnav.html");
		tnav.include(request, response);

		//HttpSession session = request.getSession();
		//String role = (String) session.getAttribute("role");

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
		/*
	pw.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");

	pw.println("<ol class='carousel-indicators'>");
    pw.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
    pw.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
    pw.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
	pw.println("</ol>");


	pw.println("<div class='carousel-inner'>");
    pw.println("<div class='item active'>");
    pw.println("<img src='images/1.jpg' alt='1'>");
    pw.println("<div class='carousel-caption'>");
    pw.println("</div>");
    pw.println("</div>");

    pw.println("<div class='item'>");
    pw.println("<img src='images/2.jpg' alt='2'>");
    pw.println("<div class='carousel-caption'>");
    pw.println("</div>");
    pw.println("</div>");

    pw.println("<div class='item'>");
    pw.println("<img src='images/3.jpg' alt='3'>");
    pw.println("<div class='carousel-caption'>");;
    pw.println("</div>");
    pw.println("</div>");
	pw.println("</div>");


	pw.println("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>");
    pw.println("<span class='glyphicon glyphicon-chevron-left'></span>");
    pw.println("<span class='sr-only'>Previous</span>");
	pw.println("</a>");
	pw.println("<a class='right carousel-control' href='#myCarousel' data-slide='next'>");
    pw.println("<span class='glyphicon glyphicon-chevron-right'></span>");
    pw.println("<span class='sr-only'>Next</span>");
	pw.println("</a>");
	pw.println("</div>");
	*/

		pw.println("<div id='body'>");
  pw.println("<section id='content'>");
 pw.println("<article>");
	pw.println("<table style=\"font-size:14px; width:80%;color:#333334\">");
					pw.println("<tr>");
					pw.println("<td>");
					pw.println("<h1 style=\"color: #777;border-bottom: 2px solid #777;\">Trending</h1>");
					pw.println("</td>");
					pw.println("</tr>");
					pw.println("</table>");

					pw.println("<br/>");
					pw.println("<br/>");
					pw.println("<h3 style=\"font-weight: bold\">Top 5 Most Liked Products:</h3>");
					pw.println("<div >");
					pw.println("<table style=\"font-size:14px; width:80%;color:#333334\">");
					pw.println("<tr>");
					pw.println("<th class='addcolor' align=\"center\" width=\"50%\">");
					pw.println("<span style=\"font-size:24px;font-weight: bold\">Product</span>");
					pw.println("</th>");
					pw.println("<th class='addcolor' align=\"center\" width=\"50%\">");
					pw.println("<span style=\"font-size:24px;font-weight: bold\">Avg. Review Rating</span>");
					pw.println("</th>");
					pw.println("</tr>");
					pw.println("</table>");

					Map<String, String> mostLikedProductsMap = MongoDBDataStoreUtilities.getTop5MostLikedProducts();

					if(mostLikedProductsMap != null){
						if(mostLikedProductsMap.isEmpty()){
							pw.println("<br/>");
							pw.println("<br/>");
							pw.println("<h3 style=\"font-weight: bold\">Not enough information available to display this!</h3>");
						}
						else{
							for (Map.Entry<String,String> entry : mostLikedProductsMap.entrySet()) {
								pw.println("<table style=\"font-size:14px; width:80%;color:#333334\">");
								pw.println("<tr>");
								pw.println("<td  width=\"50%\">");
								pw.println("<span style=\"font-size:20px;font-weight: bold\">"+entry.getKey()+"</span>");
								pw.println("</td>");
								pw.println("<td align=\"center\" width=\"50%\">");
								pw.println("<span style=\"font-size:20px;font-weight: bold\">"+entry.getValue()+"</span>");
								pw.println("</td>");
								pw.println("</tr>");
								pw.println("</table>");
							}
						}
					}
					else{
						pw.println("<br/>");
						pw.println("<br/>");
						pw.println("<h1>MongoDB Server is not running!</h1>");
					}
					pw.println("</div >");

					pw.println("<br/>");
					pw.println("<br/>");
					pw.println("<h3 style=\"font-weight: bold\">Top 5 Zipcodes where maximum number of products Reviewed:</h3>");
					pw.println("<div >");
					pw.println("<table style=\"font-size:14px; width:80%;color:#333334\">");
					pw.println("<tr>");
					pw.println("<th class='addcolor' align=\"center\" width=\"50%\">");
					pw.println("<span style=\"font-size:24px;font-weight: bold\">Zipcode</span>");
					pw.println("</th>");
					pw.println("<th class='addcolor' align=\"center\" width=\"50%\">");
					pw.println("<span style=\"font-size:24px;font-weight: bold\">No. of Items Reviewed</span>");
					pw.println("</th>");
					pw.println("</tr>");
					pw.println("</table>");

					Map<String, String> mostProductsSoldZipcodeMap = MongoDBDataStoreUtilities.getTop5MostProductsSoldZipcode();

					if(mostProductsSoldZipcodeMap != null){
						if(mostProductsSoldZipcodeMap.isEmpty()){
							pw.println("<br/>");
							pw.println("<br/>");
							pw.println("<h3 style=\"font-weight: bold\">Not enough information available to display this!</h3>");
						}
						else{
							for (Map.Entry<String,String> entry : mostProductsSoldZipcodeMap.entrySet()) {
								pw.println("<table style=\"font-size:14px; width:80%;color:#333334\">");
								pw.println("<tr>");
								pw.println("<td  width=\"50%\">");
								pw.println("<span style=\"font-size:20px;font-weight: bold\">"+entry.getKey()+"</span>");
								pw.println("</td>");
								pw.println("<td align=\"center\" width=\"50%\">");
								pw.println("<span style=\"font-size:20px;font-weight: bold\">"+entry.getValue()+"</span>");
								pw.println("</td>");
								pw.println("</tr>");
								pw.println("</table>");
							}
						}
					}
					else{
						pw.println("<br/>");
						pw.println("<br/>");
						pw.println("<h1>MongoDB Server is not running!</h1>");
					}


					pw.println("</div >");

					pw.println("<br/>");
					pw.println("<br/>");
					pw.println("<h3 style=\"font-weight: bold\">Top 5 most reviewed products regardless of rating :</h3>");
					pw.println("<div >");
					pw.println("<table style=\"font-size:14px; width:80%;color:#333334\">");
					pw.println("<tr>");
					pw.println("<th class='addcolor' align=\"center\" width=\"50%\">");
					pw.println("<span style=\"font-size:24px;font-weight: bold\">Product</span>");
					pw.println("</th>");
					pw.println("<th class='addcolor' align=\"center\" width=\"50%\">");
					pw.println("<span style=\"font-size:24px;font-weight: bold\">No. of Reviews</span>");
					pw.println("</th>");
					pw.println("</tr>");
					pw.println("</table>");

					Map<String, String> mostSoldProductMap = MongoDBDataStoreUtilities.getTop5MostSoldProducts();

					if(mostSoldProductMap != null){
						if(mostSoldProductMap.isEmpty()){
							pw.println("<br/>");
							pw.println("<br/>");
							pw.println("<h3 style=\"font-weight: bold\">Not enough information available to display this!</h3>");
						}
						else{
							for (Map.Entry<String,String> entry : mostSoldProductMap.entrySet()) {
								pw.println("<table style=\"font-size:14px; width:80%;color:#333334\">");
								pw.println("<tr>");
								pw.println("<td  width=\"50%\">");
								pw.println("<span style=\"font-size:20px;font-weight: bold\">"+entry.getKey()+"</span>");
								pw.println("</td>");
								pw.println("<td align=\"center\" width=\"50%\">");
								pw.println("<span style=\"font-size:20px;font-weight: bold\">"+entry.getValue()+"</span>");
								pw.println("</td>");
								pw.println("</tr>");
								pw.println("</table>");
							}
						}
					}
					else{
						pw.println("<br/>");
						pw.println("<br/>");
						pw.println("<h1>MongoDB Server is not running!</h1>");
					}


					pw.println("</div >");

pw.println("</article>");


		pw.println("</section>");


		RequestDispatcher sd = request.getRequestDispatcher("sidebarfooter.html");
	  sd.include(request, response);


	}catch (Exception e) {
			e.printStackTrace();
	}
}
}

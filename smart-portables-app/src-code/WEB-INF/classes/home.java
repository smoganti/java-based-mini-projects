import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;




public class home extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter pw = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");


  RequestDispatcher rd = request.getRequestDispatcher("topnav.html");
  rd.include(request, response);


	HttpSession session = request.getSession();


	String role=(String)session.getAttribute("role");

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
  if(role!=null){
  pw.println("<h3>Hello  "+role+"</h3>");
}
	pw.println("<br /><br />");
	pw.println("<p><h2>We present your favorite choice with interesting items</h2></p>");
  pw.println("<p>This site gives you the best prices Available on the internet</p>");
  pw.println("<p>Select from among the Available items from the navigation bars on the top as well as the left</p>");
	pw.println("</article>");
	pw.println("<article class='expanded'>");

  //bootstrap carousal


	pw.println("<p><h2>Select the category from navigation Bar</h2></p>");

	pw.println("</article>");
	pw.println("</section>");

  RequestDispatcher sd = request.getRequestDispatcher("sidebarfooter.html");
  sd.include(request, response);


}




public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {


    PrintWriter pw = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");

  RequestDispatcher rd = request.getRequestDispatcher("topnav.html");
  rd.include(request, response);

	HttpSession session = request.getSession();
	String role=(String)session.getAttribute("role");

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
  if(role!=null){
  pw.println("<h3>Hello  "+role+"</h3>");
}
	pw.println("<br /><br />");
  pw.println("<p><h2>We present your favorite choice with interesting items</h2></p>");
  pw.println("<p>This site gives you the best prices Available on the internet</p>");
  pw.println("<p>Select from among the Available items from the navigation bars on the top as well as the left</p>");
	pw.println("</article>");
	pw.println("<article class='expanded'>");

	pw.println("<p>Choose a category from a navigation bar</p>");
	pw.println("</article>");
	pw.println("</section>");

  RequestDispatcher sd = request.getRequestDispatcher("sidebarfooter.html");
  sd.include(request, response);


}
}

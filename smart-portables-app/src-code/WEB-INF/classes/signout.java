import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class signout extends HttpServlet {


  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
  PrintWriter pw = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");

  RequestDispatcher tnav = request.getRequestDispatcher("topnav.html");
  tnav.include(request, response);

	HttpSession session = request.getSession(false);


		pw.println("<li class='' ><a href='login'>Sign In</a></li>");

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
  pw.println("<div id = 'container'>");
	if(session!=null)
	session.invalidate();
		pw.println("<br /><br /><h2>You are logged out !<br />Please use Sign in from the Navigation bar to Sign in again. </h2><br /><br />");
    pw.println("</div>");
    pw.println("</section>");
    pw.println("</div>");


    pw.println("<aside class='sidebar'>");
		pw.println("<ul>");
		pw.println("<li>");
		pw.println("<h4>Products</h4>");
		pw.println("<ul>");
		pw.println("<li><a href='phones'>Phones</a></li>");
		pw.println("<li><a href='smartwatches'>Smart Watches</a></li>");
		pw.println("<li><a href='Speakers'>Speakers</a></li>");
		pw.println("<li><a href='laptops'>Laptops</a></li>");
		pw.println("<li class=''><div class='dropdown'><a>External Storage</a>");
		pw.println("<div class='dropdown-content'>");
		pw.println("<a href='harddrive'>Hard Drives</a>");
		pw.println("<a href='flashdrive'>Flash Drives</a>");
		pw.println("<a href='memorycard'>Memory cards</a>");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</li>");
		pw.println("<li><a href='headphones'>Head Phones</a></li>");

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

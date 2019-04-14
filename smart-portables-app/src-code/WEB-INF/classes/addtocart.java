import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class addtocart extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		response.setContentType("text/html;charset=UTF-8");


		RequestDispatcher rd = request.getRequestDispatcher("topnav.html");
		rd.include(request, response);

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
	  pw.println("<div id='container'>");
		if (role == null) {
			pw.println("<h1>Please Login to Order.</h1>");
		} else {
			cart cartitem;
			cartitem = (cart) session.getAttribute("cart");
			if (cartitem == null) {
				cartitem = new cart();
				session.setAttribute("cart", cartitem);
			}
			String name = request.getParameter("model");
			String url = request.getParameter("imageUrl");
			Integer price = Integer.parseInt(request.getParameter("price"));
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));

			cartitem.addToCart(name, price, quantity);
			cartitem.addToCartUrl(name,url);
			session.setAttribute("cart", cartitem);

			RequestDispatcher rd1 = request.getRequestDispatcher("viewcart");
			rd1.forward(request, response);
		}


			pw.println("</div>");
			pw.println("</section>");
			pw.println("</div>");

			RequestDispatcher sd = request.getRequestDispatcher("sidebarfooter.html");
			sd.include(request, response);
	}
}

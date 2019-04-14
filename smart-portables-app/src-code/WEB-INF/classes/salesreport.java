
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;




public class salesreport extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter pw = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
  pw.println("<html><head>");
  pw.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
  pw.println("<title>Smart Portables</title>");
  pw.println("<link rel='shortcut icon' href='images/icon.jpg'/>");
  pw.println("<link rel='stylesheet' href='styles.css' type='text/css' />");


  pw.println("<script type='text/javascript' src='js/loader.js'></script>");
  pw.println("<script type='text/javascript'>");
  HashMap<String, List<Integer>> orders = MySQLDataStoreUtilities.getsalesreport();
  // Load the Visualization API and the corechart package.
  pw.println("google.charts.load('current', {'packages':['corechart']});");

// Set a callback to run when the Google Visualization API is loaded.
  pw.println("google.charts.setOnLoadCallback(drawChart);");

  // Callback that creates and populates a data table,
  // instantiates the pie chart, passes in the data and
  // draws it.
  pw.println("function drawChart() {");

    // Create the data table.
    pw.println("var data = new google.visualization.DataTable();");
    pw.println("data.addColumn('string', 'Product Name');");
    pw.println("data.addColumn('number', 'Value in $');");
   pw.println(" data.addRows([");
   for (HashMap.Entry<String, List<Integer>> entry : orders.entrySet()) {
     String key = entry.getKey();

       List<Integer> order1 = entry.getValue();
     pw.println(" ['"+key+"', "+order1.get(0)*order1.get(1)+"],");
     /*pw.println(" ['Mushrooms', 3],");
      pw.println("['Onions', 1],");
    pw.println("  ['Olives', 1],");
    pw.println("  ['Zucchini', 1],");
    pw.println("  ['Pepperoni', 2]  ");*/
  }
    pw.println("]);");
    // Set chart options
   pw.println(" var options = {'title':'Sales Report',");
           pw.println("        'width':800,");
            pw.println("       'height':200};");

    // Instantiate and draw our chart, passing in some options.
   pw.println(" var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
  pw.println("  chart.draw(data, options);     }");
pw.println(" </script>");
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
  HttpSession session = request.getSession();
  String role = (String) session.getAttribute("role");
  if (role == null)
  {
  pw.println("<li class=''><a href='register'>Register</a></li>");
  pw.println("<li class='' ><a href='login'>Sign in</a></li>");
  }
    else if (role.equalsIgnoreCase("StoreManager")){
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

	pw.println("</ul>");
	pw.println("</nav>");

  pw.println("<div id='body'>");
  pw.println("<section id='content'>");
  pw.println("<article>");


  pw.println("<table style='font-size:14px; width:80%;color:#333334'>");
          pw.println("<tr>");
          pw.println("<td>");
          pw.println("<h1 style='color: #777;border-bottom: 2px solid #777;'>Sales Report</h1>");
          pw.println("</td>");
          pw.println("</tr>");
          pw.println("</table>");

          pw.println("<br/>");
          pw.println("<br/>");
          pw.println("<h3 style='font-weight: bold'>Sold products</h3>");
          pw.println("<div >");
          pw.println("<table style='font-size:14px; width:80%;color:#333334'>");
          pw.println("<tr>");
          pw.println("<th class='addcolor' align='center' width='50%'>");
          pw.println("<span style='font-size:14px;font-weight: bold'>Product name</span>");
          pw.println("</th>");
          pw.println("<th class='addcolor' align='center' width='50%'>");
          pw.println("<span style='font-size:14px;font-weight: bold'>Price</span>");
          pw.println("</th>");
          pw.println("<th class='addcolor' align='center' width='50%'>");
          pw.println("<span style='font-size:14px;font-weight: bold'>Quantity</span>");
          pw.println("</th>");
          pw.println("<th class='addcolor' align='center' width='50%'>");
          pw.println("<span style='font-size:14px;font-weight: bold'>Total sales</span>");
          pw.println("</th>");
          pw.println("</tr>");
          pw.println("</table>");

//sales report


          if(orders != null){
            if(orders.isEmpty()){
              pw.println("<br/>");
              pw.println("<br/>");
              pw.println("<h3 style='font-weight: bold'>Not enough information available to display this!</h3>");
            }
            else{


              for (Map.Entry<String, List<Integer>> entry : orders.entrySet()) {
                  String key = entry.getKey();

                    List<Integer> order1 = entry.getValue();


                pw.println("<table style='font-size:14px; width:80%;color:#333334'>");
                pw.println("<tr>");
                pw.println("<td  width='50%'>");
                pw.println("<span style='font-size:14px;font-weight: bold'>"+key+"</span>");
                pw.println("</td>");
                pw.println("<td align='center' width='50%'>");
                pw.println("<span style='font-size:14px;font-weight: bold'>$"+order1.get(1)+"</span>");
                pw.println("</td>");
                pw.println("<td align='center' width='50%'>");
                pw.println("<span style='font-size:14px;font-weight: bold'>"+order1.get(0)+"</span>");
                pw.println("</td>");
                pw.println("<td align='center' width='50%'>");
                pw.println("<span style='font-size:14px;font-weight: bold'>$"+order1.get(0)*order1.get(1)+"</span>");
                pw.println("</td>");
                pw.println("</tr>");
                pw.println("</table>");

              }

            }
          }
          else{
            pw.println("<br/>");
            pw.println("<br/>");
            pw.println("<h1>Database not running!</h1>");
          }

//Sales per Day display

pw.println("<br/>");
pw.println("<br/>");
pw.println("<h3 style='font-weight: bold'>Sales per Day</h3>");
pw.println("<div >");
pw.println("<table style='font-size:14px; width:80%;color:#333334'>");
pw.println("<tr>");
pw.println("<th class='addcolor' align='center' width='50%'>");
pw.println("<span style='font-size:14px;font-weight: bold'>Product name</span>");
pw.println("</th>");
pw.println("<th class='addcolor' align='center' width='50%'>");
pw.println("<span style='font-size:14px;font-weight: bold'>Total Price Value</span>");
pw.println("</th>");
pw.println("<th class='addcolor' align='center' width='50%'>");
pw.println("<span style='font-size:14px;font-weight: bold'>Total Quantity</span>");
pw.println("</th>");
pw.println("</tr>");
pw.println("</table>");

          HashMap<Object, ArrayList<Integer>> data2 = MySQLDataStoreUtilities.getsalesperday();
          if(data2 != null){
            if(data2.isEmpty()){
              pw.println("<br/>");
              pw.println("<br/>");
              pw.println("<h3 style='font-weight: bold'>Not enough information available to display this!</h3>");
            }
            else{
              //for (int i=0; i!= data2.size(); i++ )
				for (HashMap.Entry<Object, ArrayList<Integer>> entry : data2.entrySet()) {

                pw.println("<table style='font-size:14px; width:80%;color:#333334'>");
                pw.println("<tr>");
				pw.println("<td  width='50%'>");
                pw.println("<span style='font-size:14px;font-weight: bold'>"+entry.getKey()+"</span>");
                pw.println("</td>");

                pw.println("<td align='center' width='50%'>");
                pw.println("<span style='font-size:14px;font-weight: bold'>$"+entry.getValue().get(1)+"</span>");
                pw.println("</td>");

                pw.println("<td align='center' width='50%'>");
                pw.println("<span style='font-size:14px;font-weight: bold'>"+entry.getValue().get(0)+"</span>");
                pw.println("</td>");

                pw.println("</tr>");
                pw.println("</table>");
              }
            }
          }
          else{
            pw.println("<br/>");
            pw.println("<br/>");
            pw.println("<h1>Database not running!</h1>");
          }


          //chart
          pw.println("<br/>");
          pw.println("<br/>");
          pw.println("<h3 style='font-weight: bold'>SalesReport Items using Google Bar Chart</h3>");
            pw.println("<div id='chart_div'></div>");
  pw.println("</article>");
  pw.println("</section>");



  RequestDispatcher sd = request.getRequestDispatcher("sidebarfooter.html");
  sd.include(request, response);


}

}

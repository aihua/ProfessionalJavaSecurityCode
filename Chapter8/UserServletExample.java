import javax.servlet.*;
import javax.servlet.http.*;

/**
 *	Simple Servlet Example using the getRemoteUser() method.
 */
public class UserServletExample extends HttpServlet {

	public void doGet (HttpServletRequest req, HttpServletResponse res)
		throws ServletException, java.io.IOException {

		// Start printing out the HTML page
		res.setContentType("text/html");
		java.io.PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>User Example</TITLE></HEAD>");
		out.println("<BODY>");

		// Get the username from the request.
		// This will be null
		String username = req.getRemoteUser();
		if (username == null) {
			// User is not logged in.
			out.println("Hello. You are not logged in.");
		} else if ("Bob".equals(username)) {
			out.println("Hello, Bob. Nice to see you again.");
		} else {
			out.println("Hello, "+username+".");
		}

		// Finish the HTML page
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}
}
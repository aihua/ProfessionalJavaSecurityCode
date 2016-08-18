package ecommerce_example.servlet;

import ecommerce_example.data.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.security.cert.*;
import java.math.*;

/**
  * Gather the correct info to show a customer's balance and forward to
	* the JSP
	*/

public class BalanceServlet extends AbstractEcommerceServlet {
	/**
	  * Treat GETs and POSTs the same
		*/
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) 
		throws IOException, ServletException {
		
		doPost( request, response );
	}
	
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
		throws IOException, ServletException {

		// Get the cert's serial number
		X509Certificate cert = getCertificate( request );		
		String serialNumber = cert.getSerialNumber().toString();
		
		try {
			Account account = mBank.getAccount( serialNumber );

			// Check if the user has already registered an account
			if ( account == null ) {
				response.sendRedirect( getRedirectURL( request, "/invalidLogin.html" ) );
				return;				
			}

			// Forward to the JSP for display
			request.setAttribute( "Account", account );
			request.getRequestDispatcher( "/balance.jsp" ).forward( request, response );
		}
		catch( java.rmi.RemoteException e ) {
			e.printStackTrace();
			throw new IOException( e.getMessage() );
		}
	}
}
	

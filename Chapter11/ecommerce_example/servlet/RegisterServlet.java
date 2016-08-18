package ecommerce_example.servlet;

import ecommerce_example.data.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.security.cert.*;
import java.math.*;

public class RegisterServlet extends AbstractEcommerceServlet {
	/**
	  * GET strings are cached and stored as part of the URL, so for
	  * security they should not be used for sensitive data
	  */
	protected void doGet( HttpServletRequest request, HttpServletResponse response )
		throws IOException {

		throw new IOException( "Connections not allowed over GET for security reasons" );
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response )
		throws IOException {

		// Grab the browser cert's serial number
		X509Certificate cert = getCertificate( request );
		String serialNumber = cert.getSerialNumber().toString();

		try {
			// Check if the user has already registered an account
			if ( mBank.getAccount( serialNumber ) != null ) {
				response.sendRedirect( getRedirectURL( request, "/alreadyRegistered.html" ) );
				return;
			}

			// Gather all the needed information
			String name = request.getParameter( "Name" );
			String creditCard = request.getParameter( "CreditCard" );
			float balance = Float.parseFloat( request.getParameter( "Balance" ) );
			RegistrationInformation info = new RegistrationInformation( name, serialNumber, creditCard, balance );

			Account account = mBank.register( info );

			// Send to the balance page
			response.sendRedirect( getRedirectURL( request, "/balanceServlet" ) );
		}
		catch( java.rmi.RemoteException e ) {
			e.printStackTrace();
			throw new IOException( e.getMessage() );
		}
		catch( java.security.InvalidKeyException e ) {
			throw new IOException( e.getMessage() );
		}
	}
}


package ecommerce_example.servlet;

import ecommerce_example.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.security.cert.*;
import java.util.*;

/**
  * Base class for the RegisterServlet and BalanceServlet.
  * Connects to the RMI bank object and gets certificate
  */

public abstract class AbstractEcommerceServlet extends HttpServlet {
	protected Bank mBank;

	/**
	  * Connect to the RMI bank object on startup
	  */
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		String bankServerName = config.getInitParameter("BankServerName");
		try {
			if ( System.getSecurityManager() == null ) {
				System.setSecurityManager( new java.rmi.RMISecurityManager() );
			}
//			mBank = (Bank)java.rmi.Naming.lookup( "//" +
//				bankServerName + "/ecommerce_example.Bank" );
			mBank = (Bank)java.rmi.Naming.lookup( "ecommerce_example.Bank" );
		}
		catch( Exception e ) {
			e.printStackTrace();
			throw new ServletException( e );
		}
	}

	/**
	  * Grab the browser's certificate as an attribute and cast it correctly
	  */
	protected X509Certificate getCertificate( HttpServletRequest request ) {
		return (X509Certificate)request.getAttribute( "javax.servlet.request.X509Certificate" );
	}

	/**
	  * Jakarta doesn't like doing redirects as a non-standard HTTPS, so
	  * build the full URL correctly
	  */
	protected String getRedirectURL( HttpServletRequest request, String url ) {
		StringBuffer result = new StringBuffer( "https://" );
		result.append( request.getServerName() );
		result.append( ":" );
		result.append( request.getServerPort() );
		result.append( url );

		return result.toString();
	}
}


import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class TimeServerSSLImpl extends UnicastRemoteObject implements TimeServer {

	public TimeServerSSLImpl() throws RemoteException {
		super(0, new RMISSLClientSocketFactory(),
			new RMISSLServerSocketFactory());
	}

	public Date getTime() {
		Date theTime = new Date();
		System.out.println("Time requested: "+theTime);
		return theTime;
	}

	public static void main (String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {

			TimeServerSSLImpl self = new TimeServerSSLImpl();

			Naming.rebind("//localhost/TimeServer", self);
			System.out.println("TimeServer bound in registry");

		} catch (Exception e) {
			System.out.println("Error binding to the registry:");
			e.printStackTrace();
		}
	}
}

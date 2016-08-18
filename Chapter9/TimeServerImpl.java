import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class TimeServerImpl extends UnicastRemoteObject implements TimeServer {

	public TimeServerImpl() throws RemoteException {
		super();
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

			TimeServerImpl self = new TimeServerImpl();

			Naming.rebind("//localhost/TimeServer", self);
			System.out.println("TimeServer bound in registry");

		} catch (Exception e) {
			System.out.println("Error binding to the registry:");
			e.printStackTrace();
		}
	}
}

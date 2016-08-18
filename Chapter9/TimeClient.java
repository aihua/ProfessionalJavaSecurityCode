import java.rmi.*;

public class TimeClient {

	private static String host = "localhost";

	public static void main (String[] args) {

		// If we received any arguments, then the first one
		// is the host to connect to.
		if (args.length > 0) {
			host = args[0];
		}
		if (System.getSecurityManager()==null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			TimeServer remoteTimeServer = (TimeServer)Naming.lookup("//"+host+"/TimeServer");
			System.out.println(remoteTimeServer.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

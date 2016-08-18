import java.applet.*;
import java.awt.*;

// Import netscape class for security
import netscape.security.PrivilegeManager;

/**
 *	This applet requests the system property "user.home"
 *	and displays it. It should throw a security exception
 *	in most environments unless it has been given special
 *	permissions
 */
public class UsernameNetscapeApplet extends Applet {

	String mUsername;

	public void init() {
		try {
			// Ask the PrivilegeManager for permission
			// to read system properties
			PrivilegeManager.enablePrivilege("UniversalPropertyRead");
			mUsername = System.getProperty("user.name");
			PrivilegeManager.revertPrivilege("UniversalPropertyRead");
		} catch (SecurityException e) {
			mUsername = null;
		}
	}

	public void paint(Graphics g) {
		if (mUsername != null) {
			g.drawString("Hello, " + mUsername + ".", 5, 25);
		} else {
			g.drawString("Couldn't get the username.", 5, 25);
		}
	}

}
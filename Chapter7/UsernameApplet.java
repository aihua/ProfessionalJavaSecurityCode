import java.applet.*;
import java.awt.*;

/**
 *	This applet requests the system property "user.name"
 *	and displays it. It should throw a security exception
 *	in most environments unless it has been given special
 *	permissions
 */
public class UsernameApplet extends Applet {

	String mUsername;

	public void init() {
		try {
			mUsername = System.getProperty("user.name");
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
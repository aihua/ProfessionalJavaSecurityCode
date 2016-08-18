import java.security.*;

public class SecretWordPermission extends BasicPermission {

	public SecretWordPermission(String name) {
		super(name);
	}

	public SecretWordPermission(String name, String action) {
		super(name);
	}
}

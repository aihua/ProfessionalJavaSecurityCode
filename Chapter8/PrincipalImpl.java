import java.io.Serializable;
import java.security.Principal;

/**
 *	Implementation of the Principal interface.
 */
public class PrincipalImpl implements Principal, Serializable {
	
	private String mName;
	
	public PrincipalImpl(String name) {
		mName = name;
	}
	
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof PrincipalImpl)) {
			return false;
		}
		PrincipalImpl other = (PrincipalImpl)obj;
		if (mName.equals(other.getName())) {
			return true;
		}
		return false;
	}
	
	public java.lang.String getName() {
		return mName;
	}
	
	public int hashCode() {
		return mName.hashCode();
	}
	
	public java.lang.String toString() {
		return getName();
	}
	
}

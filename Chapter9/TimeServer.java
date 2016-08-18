import java.rmi.*;
import java.util.*;

public interface TimeServer extends Remote {

	public Date getTime() throws RemoteException;

}

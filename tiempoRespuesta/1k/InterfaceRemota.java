import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRemota extends Remote {
	
	public byte[] getData() throws RemoteException;
	
	public void setData(byte[] data) throws RemoteException;
}

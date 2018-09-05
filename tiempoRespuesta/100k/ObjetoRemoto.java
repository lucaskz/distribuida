import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRemoto extends UnicastRemoteObject
		implements InterfaceRemota {
	
	/**
	 * Construye una instancia de ObjetoRemoto
	 */
	
	private byte[] data;
	
	public ObjetoRemoto() throws RemoteException {
		super();
	}
	
	/**
	 */
//	public void imprimir(InterfaceMensaje msg) {
//
//	}
	
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
}

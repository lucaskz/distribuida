import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.TimeUnit;

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
		System.out.println("getting data");
		try{
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
}

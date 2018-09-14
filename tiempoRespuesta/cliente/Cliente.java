import java.rmi.*;

/**
 */
public class Cliente {

	/** Crea nueva instancia de Cliente */
	public Cliente(String[] args) {
		try {
			// Se obtiene el objeto remoto

			System.setProperty("java.security.policy", "file:./java.policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			
			InterfaceRemota objetoRemoto = (InterfaceRemota) Naming.lookup("//"+ args[0] +"/ObjetoRemoto");

			long start = System.currentTimeMillis();
			byte[] data =  objetoRemoto.getData();
			long end = System.currentTimeMillis();
			System.out.println("Tiempo de respuesta " + (end - start) + " ms. " + (data != null ? ("Lon. :" + data.length ) : "" ));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		if (args[0] != null)
			new Cliente(args);
		else
			System.out.println("Falta parametro de direccion");
	}

}

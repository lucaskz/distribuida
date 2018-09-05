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
			long start = System.currentTimeMillis();
			InterfaceRemota objetoRemoto = (InterfaceRemota) Naming.lookup("//"+ args[0] +"/ObjetoRemoto");

			long end = System.currentTimeMillis();
			System.out.println("Tiempo de respuesta " + (end - start) + " ms. long : " + objetoRemoto.getData().length);

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

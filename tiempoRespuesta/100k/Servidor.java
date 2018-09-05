import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class Servidor {

	public Servidor(String[] args) {
		System.setProperty("java.security.policy", "file:./java.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			// Se publica el objeto remoto
			InterfaceRemota objetoRemoto = new ObjetoRemoto();
			((ObjetoRemoto) objetoRemoto).setData(new byte[100000]);
			Naming.rebind("//" + args[0] + "/ObjetoRemoto", objetoRemoto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		if (args.length > 0)
			new Servidor(args);
		else
			System.out.println("Falta parametro de direccion");
	}
}

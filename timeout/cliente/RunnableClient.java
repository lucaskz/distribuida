import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.concurrent.Callable;

public class RunnableClient implements Callable {
	
	@Override
	public Object call() throws Exception {
		System.out.println("running");
		System.setProperty("java.security.policy", "file:./java.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		long start = System.currentTimeMillis();
		InterfaceRemota objetoRemoto =
				(InterfaceRemota) Naming.lookup("//localhost/ObjetoRemoto");
		
		byte[] data = objetoRemoto.getData();
		long end = System.currentTimeMillis();
		System.out.println("Tiempo de respuesta " + (end - start) + " ms");
		return data;
	}
}

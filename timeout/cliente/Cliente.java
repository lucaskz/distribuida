import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 */
public class Cliente {
	
	/**
	 * Crea nueva instancia de Cliente
	 */
	public Cliente() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			
			//RunnableClient clientTask = new RunnableClient();
			Future future = executor.submit(new RunnableClient());
			Object data = future.get(5, TimeUnit.SECONDS);
			//executor.in
			
			
		} catch (Exception e) {
			e.printStackTrace();
			executor.shutdown();
		}
		executor.shutdown();
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		new Cliente();
	}
	
}

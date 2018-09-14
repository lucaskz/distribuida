import java.util.concurrent.*;
/**
 */
public class Cliente {
	
	/**
	 * Crea nueva instancia de Cliente
	 */
	public Cliente() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future future = executor.submit(new RunnableClient());
		try {
			Object data = future.get(5, TimeUnit.SECONDS);
		} 
		catch (TimeoutException e){
			e.printStackTrace();
			future.cancel(true);
			System.exit(0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		new Cliente();
	}
	
}

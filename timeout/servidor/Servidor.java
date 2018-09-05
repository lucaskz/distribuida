import java.rmi.Naming;
import java.rmi.RMISecurityManager;

/**
 * Servidor para el ejemplo de RMI.
 * NOTA : rmiregistry en carpeta "servidor"
 */
public class Servidor 
{
    
    /** Crea nueva instancia de Servidor rmi */
    public Servidor() {
//        System.setProperty ("java.rmi.server.codebase", "file:../cliente/"); // Direccion en el cliente donde encontrar el objeto
        System.setProperty(	"java.security.policy",	"file:./java.policy");
        if (System.getSecurityManager()==null)
        {
            System.setSecurityManager(new RMISecurityManager());
        }
            
        try 
        {
            // Se publica el objeto remoto
            InterfaceRemota objetoRemoto = new ObjetoRemoto();
            ((ObjetoRemoto) objetoRemoto).setData(new byte[1000]);
            Naming.rebind ("//localhost/ObjetoRemoto", objetoRemoto);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Servidor();
    }
}

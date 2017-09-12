import java.io.IOException;
import java.net.ServerSocket;


public class ServidorPrincipal {

	private final static int PUERTO = 8080;

	private static int idThread;

	public static void main(String[] args) throws IOException {
		idThread = 0;
		ServerSocket ss = null;
		boolean continuar = true;
		// defina variable para contar e identificar los threads
		try {
			ss = new ServerSocket(PUERTO);
		} catch (IOException e) {
			System.err.println("No pudo crear socket en el puerto:" + PUERTO);
			System.exit(-1);
		}
		while (continuar) {
			new ServidorT(ss.accept(),idThread++).start();
			// incremente identificador de thread
		}
		ss.close();
	}
}

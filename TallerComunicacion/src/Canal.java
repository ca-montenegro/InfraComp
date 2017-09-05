
public class Canal {

	private int contenido;
	
	private boolean ocupado;
	
	public Canal()
	{
		ocupado = true;
	}
	
	public synchronized int recibir()
	{
		ocupado = false;
		notifyAll();
		return contenido;
	}
	
	public synchronized void enviar(int conte) throws InterruptedException
	{
		ocupado=true;
		contenido = conte;
		wait();
	}
	
	public boolean estaOcupado()
	{
		return ocupado;
	}
}

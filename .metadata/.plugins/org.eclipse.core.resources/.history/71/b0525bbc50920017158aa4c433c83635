import java.util.Queue;


public class Semaforo {

	int contador;
	//int mutex;
	public Semaforo(int pC){
		//this.mutex = 1;
		this.contador = pC;
	}
	public synchronized void V() 
	{
		contador++;
		if(contador<=0)
		{
			notify();
		}
	}
	
	public synchronized void P()
	{
		contador--;
		if(contador<0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

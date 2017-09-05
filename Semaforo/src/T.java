
public class T extends Thread  {


	Semaforo semaphore;
	 static int total=0;
	 int suma;
	public T(Semaforo pSemaforo,int i)
	{
		semaphore = pSemaforo;
		
		suma=i;
	}
	

//	public  int mA()
//	{
//		semaphore.P();
//		total++;
//		
//		semaphore.V();
//		return total;
//	}
//	
//	public  int mB()
//	{
//		semaphore.P();
//		total--;
//		semaphore.V();
//		return total;
//	}
	
	public void run()
	{
		semaphore.P();
		total+=suma;
		semaphore.V();
	}
	
	public int darTotal()
	{
		return total;
	}
	
}

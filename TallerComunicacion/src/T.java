
public class T extends Thread {

	private int val;
	static T productor;
	static T consumidor;

	private static Canal canal;

	private static int valor;
	public T()
	{

	}


	public void run()
	{
		//Consu
		if(val==0)
		{
			valor = canal.recibir();

		}
		//Productor
		else
			try {
				
					canal.enviar(valor++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		canal = new Canal();

		valor = 1;
		while(valor<1000){
		productor = new T();
		
		productor.start();
		sleep(1000);
		consumidor = new T();
		consumidor.start();

		//			productor.join();
		//			consumidor.join();
		System.out.println(valor);}




	}
}



public class Principal {

	static T a;
	static T b;
	static Semaforo sempharo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sempharo = new Semaforo(1);
		a = new T(sempharo,-1);
		b = new T(sempharo,1);
		a.start();
		b.start();
		
		System.out.println(a.darTotal());
	}

}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.crypto.SecretKey;


public class Main{

	public static void main(String[] args) throws Exception
	{
		
			Simetrico cifrado = new Simetrico();
			cifrado.cifrar();
			FileInputStream input = new FileInputStream("./doc/datoCifrado");
			ObjectInputStream ois = new ObjectInputStream(input);
			byte cipheredText[] = (byte[])ois.readObject();
			ois.close();
			cifrado.descifrar(cipheredText);
		
			Asimetrico asimetrico = new Asimetrico();
			cifrado.descifrar(asimetrico.cifrar());
	}
}

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

import javax.crypto.*;


public class Simetrico {

	private SecretKey desKey;
	private final static String ALGORITMO="AES";
	private final static String PADDING="AES/ECB/PKCS5Padding";

	public byte[] cifrar() {
		byte [] cipheredText;
		try {
			KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
			desKey = keygen.generateKey();
			Cipher cipher = Cipher.getInstance(PADDING);
			System.out.println("Escribir mensaje");
			BufferedReader stdIn = new BufferedReader(
					new InputStreamReader(System.in));
			String pwd = stdIn.readLine();
			byte [] clearText = pwd.getBytes();
			String s1 = new String (clearText);
			System.out.println("clave original: " + s1);
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			long startTime = System.nanoTime();
			cipheredText = cipher.doFinal(clearText);
			long endTime = System.nanoTime();
			String s2 = new String (cipheredText);
			System.out.println("clave cifrada: " + s2);
			System.out.println("Tiempo: " + (endTime - startTime));
			FileOutputStream farch = new FileOutputStream("./doc/datoCifrado");
			ObjectOutputStream oos = new ObjectOutputStream(farch);
			oos.writeObject(cipheredText);
			oos.close();
			FileOutputStream farch2 = new FileOutputStream("llave");
			ObjectOutputStream oos2 = new ObjectOutputStream(farch2);
			 
			oos2.writeObject(desKey);
			oos2.close();
			return cipheredText;
		}
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
			return null;
		}
	}
	
	public void descifrar(byte [] cipheredText) {
		try {
		Cipher cipher = Cipher.getInstance(PADDING);
		cipher.init(Cipher.DECRYPT_MODE, desKey);
		byte [] clearText = cipher.doFinal(cipheredText);
		String s3 = new String(clearText);
		System.out.println("clave original: " + s3);
		}
		catch (Exception e) {
		System.out.println("Excepcion: " + e.getMessage());
		}
		}
}

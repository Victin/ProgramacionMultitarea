package procesos;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;


public class Ejercicio2 {

	public static void main(String[] args) {
	
		String texto = JOptionPane.showInputDialog("Introduce un texto");
		
		ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C:\\Users\\alumno\\Documents\\Clase\\Eclipse\\GITProgramacionMultitarea\\Mayusculas2.jar", texto);
		//ProcessBuilder acepta dos argumentos(args) en su declaracion
		
		try {
			Process proceso = pb.start();

			InputStream is = proceso.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br =  new BufferedReader(isr);
			String linea = null;
			
			System.out.println("La salida del proceso hijo es: ");
			while((linea = br.readLine())!= null) {
				System.out.println(linea);
			}
			
			is.close();
		
			int exitValue = proceso.waitFor();//Espera a que termine el proceso
			System.out.println("Resultado de ejecucion ha sido: " + exitValue);
		} catch (IOException e) {
			System.out.println("Error entrada/salida");
			System.exit(-2);
		} catch (InterruptedException e) {
			System.out.println("Proceso interrumpido");
			System.exit(-3);
		}
	}
}

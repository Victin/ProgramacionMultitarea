package procesos;

import java.io.IOException;
import java.io.InputStream;

public class ProcessBuilderBasico {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			System.err.println("Debe inicia el comando a ejeutar");
			System.exit(-1);//0 es que el proceso termina bien(Creas tus propios codigos de error)
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		
		try {
			Process process = pb.start();
			
			int exitValue = process.waitFor();//Espera a que termine el proceso
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
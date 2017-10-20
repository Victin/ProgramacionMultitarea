package procesos;

import java.io.IOException;

public class RuntimeBasico {

	public static void main(String[] args) {

		if(args.length < 1) {
			System.err.println("Debe inicia el comando a ejeutar");
			System.exit(-1);//0 es que el proceso termina bien(Creas tus propios codigos de error)
		}
		
		Runtime runtime = Runtime.getRuntime();
		
		try {
			Process process = runtime.exec(args);
			
			int exitValue = process.waitFor();
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

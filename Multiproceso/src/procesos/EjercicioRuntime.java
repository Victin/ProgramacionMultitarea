package procesos;

import java.io.IOException;

public class EjercicioRuntime {

	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.err.println("Debe inicia el comando a ejeutar");
			System.exit(-1);
		}
		
		Runtime runtime = Runtime.getRuntime();
		
		try {
			Process process = runtime.exec(args);
			
			int exitValue = process.waitFor();
			System.out.println("Resultado de ejecucion ha sido: " + exitValue);
			System.out.println("Procesadores disponibles: " + runtime.availableProcessors());
			System.out.println("Memoria total: " + runtime.totalMemory() + " / Memoria maxima: " + runtime.maxMemory());
			int memoria = (int) runtime.freeMemory();
			System.out.println("Memoria libre: " + memoria);
			runtime.gc();
			int memoria2 = (int) runtime.freeMemory();
			System.out.println("Memoria libre despues del recolector de basura : " + runtime.freeMemory() + " / Memoria liberada: " + (memoria2 - memoria));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-2);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(-3);
		}
	}
}

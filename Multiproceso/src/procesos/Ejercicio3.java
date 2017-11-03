package procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String opcion = null;
		do {
			System.out.println("1-)Para ejecutar el proceso teclee 'get'");
			System.out.println("2-)Para salir teclee 'end'");
			opcion = sc.next();
			
			switch(opcion) {
				case "get": 
					System.out.println("Numero minimo");
					String minimo = sc.next();
					System.out.println("Numero maximo");
					String maximo = sc.next();
					
					ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C:\\Users\\alumno\\Documents\\Clase\\Eclipse\\GITProgramacionMultitarea\\Aleatorio.jar", minimo, maximo);
					
					/*
					File output = new File("C:\\Users\\alumno\\Documents\\Clase\\Eclipse\\GITProgramacionMultitarea\\Multiproceso\\Archivos\\output.txt");
					pb.redirectOutput(output); //Muestra la salida del proceso sin mostrarlo por consola
					
					File error = new File("C:\\Users\\alumno\\Documents\\Clase\\Eclipse\\GITProgramacionMultitarea\\Multiproceso\\Archivos\\error.txt");
					pb.redirectError(error);
					*/
						
					try {
						Process proceso = pb.start();
				
						InputStream is = proceso.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader br =  new BufferedReader(isr);
						String linea = null;
						
						while((linea = br.readLine())!= null) {
							System.out.println(linea);
						}
						
						is.close();
					
						int exitValue = proceso.waitFor();//Espera a que termine el proceso
						System.out.println("Resultado de ejecucion ha sido: " + exitValue);
						System.out.println("-------------------------------");
					} catch (IOException e) {
						System.out.println("Error entrada/salida");
						System.exit(-2);
					} catch (InterruptedException e) {
						System.out.println("Proceso interrumpido");
						System.exit(-3);
					}
					break;
				case "end":
					System.out.println("Goodbye");
					break;
			}
		}while(!opcion.equals("end"));
	}
}

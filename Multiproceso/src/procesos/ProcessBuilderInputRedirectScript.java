package procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProcessBuilderInputRedirectScript {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			System.err.println("Debe inicia el comando a ejeutar");
			System.exit(-1);//0 es que el proceso termina bien(Creas tus propios codigos de error)
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		//pb.directory(new File("C:\\"));//Directorio para hacer el dir
		try {
			/*
			Map<String, String> env = new HashMap<>();
			env.put("cuantas", "10");
			env.put("direccion", "127.0.0.30");
			pb.environment().putAll(env);
			*/ //Es lo mismo solo que creando el Map fuera y aņadiendoselo al environment
			
			pb.environment().put("cuantas", "10");
			pb.environment().put("direccion", "127.0.0.30");
			
			String consulta = pb.environment().get("direccion");
			Collection<String> valores = pb.environment().values();
			Set<String> keys = pb.environment().keySet();
			System.out.println("La direccion ip es: " + consulta);
			System.out.println("Total valores: " + valores.toString());
			System.out.println("Total keys: " + keys.toString());
			
			Process process = pb.start();
			
			//Mostrar lo que haria el proceso hijo
			//El proceso padre seria ejecutar la cmd y el proceso hijo hacer un dir
			//Sin esto ejecutaria el proceso pero no se podria ver el resultado
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br =  new BufferedReader(isr);
			String linea;
			
			System.out.println("La salida del proceso hijo es: ");
			while((linea = br.readLine())!= null) {
				System.out.println(linea);
			}
			is.close();
			//Fin de Mostrar lo que haria el proceso
			
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
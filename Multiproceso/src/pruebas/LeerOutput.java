package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerOutput {

	public static void main(String[] args) throws IOException {
		
		File archivo = new File("C:\\Users\\alumno\\Documents\\Clase\\Eclipse\\GITProgramacionMultitarea\\Multiproceso\\Archivos\\output.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		while((linea = br.readLine())!= null)
			System.out.println(linea);

	}
}

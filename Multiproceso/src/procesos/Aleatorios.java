package procesos;

public class Aleatorios {

	public static void main(String[] args) {
		
		int min = Integer.parseInt(args[0]);
		int max = Integer.parseInt(args[1]);
		
		int valorEntero = (int) Math.floor(Math.random()*(max- min + 1) + min); //M menor que N, ambos incluidos
		
		System.out.println(valorEntero);
	}
}

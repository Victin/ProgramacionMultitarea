package hilos;

public class Ejercicio2ThreadsMain {

	public static void main(String[] args) {
		
		final int size = 2;
		
		Ejercicio2Threads[] hilo = new Ejercicio2Threads[size];
		
		for (int i = 0; i < size; i++) {
			hilo[i] = new Ejercicio2Threads("Hilo " + i, 100 * (i + 1));
		}
		
		for (int i = 0; i < size; i++) {
			hilo[i].start();
		}
		
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo[0].stopHilo();
		System.out.println(hilo[0].isAlive());	
		
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo[1].stopHilo();
		
	}
}

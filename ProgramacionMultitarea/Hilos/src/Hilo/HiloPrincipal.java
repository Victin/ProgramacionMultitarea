package Hilo;

public class HiloPrincipal {

	public static void main(String[] args) {

		HiloPrueba hilo = new HiloPrueba("Hilo 1"); //Instanciar el objeto de la clase HiloPrueba
		HiloPrueba hilo2 = new HiloPrueba("Hilo 2");
		
		hilo.start(); //Ejecutar el hilo
		hilo2.start();

		System.out.println("Fin del proceso");
	}
}

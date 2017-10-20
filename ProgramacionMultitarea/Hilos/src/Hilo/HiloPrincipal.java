package Hilo;

public class HiloPrincipal {

	public static void main(String[] args) {

		HiloPrueba hilo = new HiloPrueba("Hilo 1"); //Instanciar el objeto de la clase HiloPrueba
		HiloPrueba hilo2 = new HiloPrueba("Hilo 2");
		HiloPrueba hilo3 = new HiloPrueba("Hilo 3");
		
		hilo.start(); //Ejecutar el hilo
		hilo2.start();
		hilo3.start(); 

		System.out.println("Fin del proceso");
	}
}

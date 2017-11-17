package hilos;

public class Ejercicio2Threads extends Thread{

	private boolean finaliza = true;
	private int milis;
	
	public Ejercicio2Threads(String nombre, int milis) {
		super(nombre);
		this.milis = milis;
	}
	
	public void stopHilo() {
		finaliza = false;
		this.interrupt();
	}
	
	public static boolean esPrimo(int numero){
		  int contador = 2;
		  boolean primo = true;
		  while ((primo) && (contador!=numero)){
		    if (numero % contador == 0) {
		      primo = false;
		      contador++;
		    }
	    }
		  return primo;
		}
	
	public boolean esPar(int numero) {
		return numero % 2 == 0;
	}
	
	public void run() {
		int cont = 1;
		while(finaliza || esPar(cont) && cont < 100) {
			System.out.println(cont + " " + this.getName());
			cont ++;
			try {
				this.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

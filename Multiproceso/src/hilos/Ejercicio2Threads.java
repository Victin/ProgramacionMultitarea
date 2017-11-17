package hilos;

public class Ejercicio2Threads extends Thread{

	private boolean finaliza = false;
	private int milis;
	
	public Ejercicio2Threads(String nombre, int milis) {
		super(nombre);
		this.milis = milis;
	}
	
	public void stopHilo() {
		finaliza = true;
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
		while(!finaliza || esPar(cont) && cont < 100) { //Si cuando finaliza es true(!) y esPar es false vuelve a hacer el while hasta que esPar sea true. Si una de las dos es false el while sigue
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

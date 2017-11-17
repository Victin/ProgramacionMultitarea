package hilos;

public class Ejercicio2Threads extends Thread{

	private boolean finaliza = true;
	private int milis;
	private int cont = 0;
	
	public Ejercicio2Threads(String nombre, int milis) {
		super(nombre);
		this.milis = milis;
	}
	
	public void stopHilo() {
		finaliza = false;
		if(cont % 2 == 0) {
			this.interrupt();
			System.out.println("Hilo ternimado en " + cont);
		}else {
			cont ++;
			this.interrupt();
			System.out.println("Hilo terminado en impar sumado uno " + cont);
		}
	}
	
	public void run() {
		while(finaliza && cont < 100) {
			System.out.println(cont + " " +this.getName());
			cont ++;
			try {
				this.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

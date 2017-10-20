package Hilo;

public class HiloPrueba extends Thread {
	
	public HiloPrueba(String nombre) {
		super(nombre);
	}
	
	public void run() {
		for(int i=0; i < 10; i++) {
			if(getName().equals("Hilo 1"))
				System.out.println(i + " " + getName() + " <---");
			else if (getName().equals("Hilo 2"))
				System.out.println(i + " " + getName() + " --->");
			else
				System.out.println(i + " " + getName() + " <--->");
		try {
			Thread.sleep(2000); //Para el hilo (Durante 2 segundos)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		
		System.out.println("Finaliza " + getName());
	}
}

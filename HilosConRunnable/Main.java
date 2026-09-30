package HilosConRunnable;

public class Main {

	public static void main (String [] args) {
		
	
	Thread hilo1 = new Thread(new HiloFonsi("Buenos dias!! :)"));
	Thread hilo2 = new Thread(new HiloFonsi("Bunas noches :)"));
	
	hilo1.start();
	hilo2.start();
	}
}

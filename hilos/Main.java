package hilos;

public class Main {
	public static void main (String [] args) {
		HiloJunior hilo1 = new HiloJunior("Pepe", 500);
		HiloJunior2 hilo2 = new HiloJunior2("Jose", 1000);
		
		hilo1.start();
		hilo2.start();
	}
}



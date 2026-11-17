package actividadesRepasoHilos;

public class Main_Esperas {

	public static void main (String [] args) throws InterruptedException {
		
		Runnable persona1 = new Act4_Esperas();
		Runnable persona2 = new Act4_Esperas();
		
		Thread hilo1 = new Thread(persona1);
		Thread hilo2 = new Thread(persona2);
		
		hilo1.setName("Mari");
		hilo2.setName("Pili");
		
		hilo1.start();
		hilo2.start();
		
		hilo1.join();
		hilo2.join();
		
		System.out.println("Todos los hilos han acabado");
	}
}

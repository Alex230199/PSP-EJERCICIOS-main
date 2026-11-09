package actividadesRepasoHilos;

public class Main_interrupciones {

	public static void main (String[] args) {
		
	
	Thread trabajador = new Thread (new Act7_Interrupciones());
	
	trabajador.start();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	trabajador.interrupt();
	
	try {
		trabajador.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	System.out.println("El trabajador ha acabado");
	
	}
}

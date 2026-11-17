package actividadesRepasoHilos;

public class Main_saludo_Runnable {

	public static void main (String[] args) {
		
		Act2_Saludo_Runnable tarea1 = new Act2_Saludo_Runnable ("A");
		Act2_Saludo_Runnable tarea2 = new Act2_Saludo_Runnable ("B");
		
		Thread hilo1 = new Thread(tarea1);
		Thread hilo2 = new Thread(tarea2);
		
		hilo1.start();
		hilo2.start();
	}
}

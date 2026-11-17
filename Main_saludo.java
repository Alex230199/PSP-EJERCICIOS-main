package actividadesRepasoHilos;

public class Main_saludo {
	
	public static void main (String[] args) {
		

	Act1_Saludo hilo1 = new Act1_Saludo("A");
	Act1_Saludo hilo2 = new Act1_Saludo("B");
	
	
	//hilo1.start();
	//hilo2.start();
	hilo1.run();
	hilo2.run();
	
	//el run() hace que primero acabe uno y luego el otro
	//mientras que el start() instercala ambos procesos a la vez.
	}
}

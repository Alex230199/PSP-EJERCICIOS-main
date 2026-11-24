package practicaexamen;

public class Main_SaludoRunnable {

	public static void main (String [] args) {
		
		Saludo_Runnable tarea1 = new Saludo_Runnable("Pepa");
		Saludo_Runnable tarea2 = new Saludo_Runnable("Abelino");
		
		Thread h1 = new Thread(tarea1);
		Thread h2 = new Thread(tarea2);
		
		h1.start();
		h2.start();
	}
}

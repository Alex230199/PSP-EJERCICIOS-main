package practicaexamen;

public class Main_Saludo {

	public static void main (String [] args) {
		
		Saludo hilo1 = new Saludo("Pepa");
		Saludo hilo2 = new Saludo ("Abelino");
		
		hilo1.start();
		hilo2.start();
		
		/*
		 hilo1.run();
		 hilo2.run();
		 */
	}
	
}

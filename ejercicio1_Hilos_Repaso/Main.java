package ejercicio1_Hilos_Repaso;

public class Main {
	
	public static void main (String[] args) {
		
		SaludoThread hiloA = new SaludoThread ("A");
		SaludoThread hiloB = new SaludoThread ("B");
		
		hiloA.start();
		hiloB.start();
	}
	
}

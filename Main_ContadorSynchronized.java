package actividadesRepasoHilos;

public class Main_ContadorSynchronized {
	
	public static void Main (String[] args) throws InterruptedException {
		
		Act6_Contador_Synchronized contadorUnico = new Act6_Contador_Synchronized();
		
		Runnable p1 = new Act6_FuncionamientoContador_Synchronized(contadorUnico);
		Runnable p2 = new Act6_FuncionamientoContador_Synchronized(contadorUnico);
		Runnable p3 = new Act6_FuncionamientoContador_Synchronized(contadorUnico);
		Runnable p4 = new Act6_FuncionamientoContador_Synchronized(contadorUnico);
		
		Thread hilo1 = new Thread(p1);
		Thread hilo2 = new Thread(p2);
		Thread hilo3 = new Thread(p3);
		Thread hilo4 = new Thread(p4);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
		hilo1.join();
		hilo2.join();
		hilo3.join();
		hilo4.join();
		
		System.out.println("El valor final del contador es: " + contadorUnico.getValor());
		
		
	}
}



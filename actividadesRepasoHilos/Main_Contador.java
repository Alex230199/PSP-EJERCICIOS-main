package actividadesRepasoHilos;

public class Main_Contador {

	public static void Main (String[] args) throws InterruptedException {
		
		Act5_Contador contadorUnico = new Act5_Contador();
		
		Runnable p1 = new Act5_FuncionamientoContador(contadorUnico);
		Runnable p2 = new Act5_FuncionamientoContador(contadorUnico);
		Runnable p3 = new Act5_FuncionamientoContador(contadorUnico);
		Runnable p4 = new Act5_FuncionamientoContador(contadorUnico);
		
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

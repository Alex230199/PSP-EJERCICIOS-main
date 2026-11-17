package actividadesRepasoHilos;

public class Main_BarrerayTrabajadores {

	public static void main (String [] args) throws InterruptedException{
		
		int numTrabajadores = 4;
		Act18_Barrera barrera = new Act18_Barrera(numTrabajadores);
		
		Thread[] hilos = new Thread [numTrabajadores];
		
		for (int i = 0; i < numTrabajadores; i++) {
			hilos[i] = new Thread (new Act18_Trabajador(i + 1, barrera));
			hilos[i].start();
		}
		
		/* --- PRUEBA DE CANCELACIÓN (Opcional) ---
         Descomenta las siguientes líneas para probar la interrupción de un trabajador:
        
        Thread.sleep(100); // Dejar trabajar un momento
        hilos[0].interrupt(); // Interrumpimos al trabajador 1
        */
		
		for (int i = 0; i < numTrabajadores; i++) {
			hilos[i].join();
		}
		
		System.out.println("fIn del programa. Todos los hilos han  terminado");
	}
}

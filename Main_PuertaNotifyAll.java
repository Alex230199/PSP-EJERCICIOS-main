package actividadesRepasoHilos;

public class Main_PuertaNotifyAll {

	public static void main (String [] args) {
		
		System.out.println("PRUEBA 1: CREACION DE CINCO HILOS ESPERANDO A LA VEZ--");
		
		Act10_PuertaNotifyAll puerta = new Act10_PuertaNotifyAll();
		
		Thread[] hilos = new Thread[5];
		
		for(int i = 0; i < 5; i++) {
			hilos[i] = new Thread (new Act10_PuertaEsperaNotifyAll(puerta), " HiloA: " + (i + 1));
			hilos[i].start();
		}
		
		Thread hAbierta = new Thread (new Act10_PuertaAbiertaNotifyAll(puerta), "HiloAbre");
		hAbierta.start();
		
		try {
			for(int i = 0; i< 5; i++) {
				hilos[i].join();
			}
			hAbierta.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("PRUEBA 2: SE ABRE LA PUERTA ANTES DE ARRANCAR A LOS CINCO HILOS");
		
		Act10_PuertaNotifyAll puerta2 = new Act10_PuertaNotifyAll();
		
		puerta2.abierta = true;
		
		Thread[] hilos2 = new Thread[5];
		for(int i = 0; i < 5; i++) {
			hilos[i] = new Thread (new Act10_PuertaEsperaNotifyAll(puerta2), " HiloB: " + (i + 1));
			hilos2[i].start();
		}
		
		try {
			for(int i = 0; i < 5; i++) {
				hilos2[i].join();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Fin del programa principal");
	}
}

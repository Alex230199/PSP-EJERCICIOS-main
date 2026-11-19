package actividadesRepasoHilos;

public class Main_PuertaNotifyAll {
	
	/*
	 Concepto nuevo: Notificación mediante notifyAll.
Amplía el ejercicio 9: ahora cinco hilos quieren pasar por la misma puerta. Cuando se abra, todos deben 
poder continuar.
1. Cada uno de los cinco hilos esperará en un while mientras abierta sea false. Usará wait() y el 
monitor de la misma puerta.
2. El hilo que abre cambiará abierta a true y ejecutará notifyAll() sobre la puerta dentro de 
synchronized.
3. Escribe el nombre de cada hilo cuando pase. Espera a todos con join().
4. Repite la prueba abriendo la puerta antes de arrancar a los cinco hilos, como en la segunda prueba del 
ejercicio 9.
COMPRUEBA
Los cinco hilos pasan una sola vez y todos terminan. No tienen por qué hacerlo en el mismo orden en que 
arrancaron; cada uno debe volver a adquirir el monitor.
EXPLICA
¿Por qué una sola llamada a notify() no garantiza que terminen los cinco hilos si ya estaban esperando?
	 */

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

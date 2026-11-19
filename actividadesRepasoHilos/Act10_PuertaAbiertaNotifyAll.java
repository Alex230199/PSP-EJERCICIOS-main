package actividadesRepasoHilos;

public class Act10_PuertaAbiertaNotifyAll implements Runnable{
	
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
 
	private Act10_PuertaNotifyAll puerta;

	public Act10_PuertaAbiertaNotifyAll (Act10_PuertaNotifyAll puerta) {
		
		this.puerta = puerta;
	}
	
	@Override
	
	public void run() {
		
		try {
			Thread.sleep(200);
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
		
		synchronized (puerta) {
			puerta.abierta = true;
			puerta.notifyAll();
		}
	}
}

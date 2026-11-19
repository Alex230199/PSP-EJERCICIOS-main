package actividadesRepasoHilos;

public class Main_PuertaNotify {
	
	/*
	 Concepto nuevo: Notificación mediante notify.
Modifica el ejercicio 8 para que un único hilo espere sin comprobar la puerta cada 200 ms. El hilo que abre 
se encargará de avisarle.
1. Sustituye wait(200) por wait(). Conserva el while que comprueba si la puerta sigue cerrada.
2. El hilo que abre debe cambiar abierta a true y llamar a notify() sobre la misma puerta, dentro del 
mismo bloque synchronized.
3. Prueba con ambos hilos arrancados. Haz además otra ejecución en la que arranques primero al que 
abre, esperes a que termine con join() y después arranques al que quiere pasar.
4. Mantén la gestión de interrupciones del ejercicio 8 y espera a todos los hilos antes de terminar main.
COMPRUEBA
En ambas pruebas aparece «Paso permitido» y el programa termina. En la segunda, el receptor encuentra 
la puerta abierta y no debe quedarse esperando un aviso pasado.
EXPLICA
¿Por qué sigue siendo necesario guardar abierta aunque se utilice notify()?

	 */
	
	public static void main (String [] args) {
		
		System.out.println("--PRUEBA 1: AMBOS HILOS SE ARRANCAN A LA VEZ--");
		
		Act9_PuertaNotify puerta = new Act9_PuertaNotify();
		
		Thread hEspera = new Thread (new Act9_PuertaEsperaNotify(puerta));
		Thread hAbierta = new Thread (new Act9_PuertaAbiertaNotify(puerta));
		
		hEspera.start();
		hAbierta.start();
		
		try {
			hEspera.join();
			hAbierta.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("--PRUEBA 2: ARRANCA PRIMERO EL QUE ABRE YDESPUÉS ARRANCO AL QUE QUIERE PASAR");
		
		Act9_PuertaNotify puerta2 = new Act9_PuertaNotify();
		
		Thread hEspera2 = new Thread (new Act9_PuertaEsperaNotify(puerta2));
		Thread hAbierta2 = new Thread (new Act9_PuertaAbiertaNotify(puerta2));
		
		hEspera2.start();
		
		try {
			hEspera2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		hAbierta2.start();
		
		try {
			hAbierta2.join();
			
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("FIN DEL PROGRAMA");
	}
}

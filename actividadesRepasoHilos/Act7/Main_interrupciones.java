package actividadesRepasoHilos.Act7;

public class Main_interrupciones {
	
	/*
	 Crea un hilo que repita un mensaje y haga una pausa de 200 ms en cada vuelta. Main le pedirá que 
termine al cabo de aproximadamente un segundo.
1. El bucle del trabajador continuará mientras Thread.currentThread().isInterrupted() sea 
false. Esa consulta indica si tiene una petición de interrupción pendiente.
2. Arranca el trabajador. Desde main, espera unos 1 000 ms y llama a interrupt() sobre el objeto 
Thread del trabajador.
3. Si sleep() lanza InterruptedException, termina run(). En ese catch, antes de salir, usa 
Thread.currentThread().interrupt() para restaurar la marca que la excepción ha limpiado.
4. Después de pedir la interrupción, main hará join() y escribirá «Trabajador terminado».
COMPRUEBA
El trabajador deja de repetir mensajes y el programa termina. No exijas una cantidad exacta de mensajes: 
depende del momento en que se atienda la interrupción.
EXPLICA
¿Por qué el trabajador necesita comprobar la petición o atender la excepción para terminar?

	 */

	public static void main (String[] args) {
		
	
	Thread trabajador = new Thread (new Act7_Interrupciones());
	
	trabajador.start();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	trabajador.interrupt();
	
	try {
		trabajador.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	System.out.println("El trabajador ha acabado");
	
	}
}

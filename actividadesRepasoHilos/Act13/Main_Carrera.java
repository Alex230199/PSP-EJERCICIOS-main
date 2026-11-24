package actividadesRepasoHilos.Act13;

public class Main_Carrera {
	
	/*
	 Conceptos: Thread, Runnable, synchronized, wait, notifyAll y join.
Cuatro corredores esperarán una señal antes de empezar. El árbitro será una subclase de Thread y cada 
corredor una tarea Runnable.
1. Crea un objeto compartido con salidaDada inicialmente false. Cada corredor esperará con while y 
wait() hasta que sea true.
2. El árbitro mostrará una cuenta atrás de 3 a 1, con pausas fuera del monitor. Después, dentro de 
synchronized, escribirá «Salida», pondrá salidaDada a true y llamará a notifyAll().
3. Cada corredor escribirá tres pasos después de la señal. Main esperará a todos con join().
4. En otra ejecución, deja que uno de los cuatro corredores arranque después de que el árbitro haya 
terminado. Usa join() del árbitro para asegurar ese caso.
COMPRUEBA
En ambas pruebas aparecen doce pasos y ninguno precede al mensaje «Salida». El corredor que llega tarde 
también debe terminar.
EXPLICA
¿Qué le permite continuar al corredor que llega después del aviso?
	 */

	public static void main (String [] args) {
		
		Act13_SalidaCompartida buzonSalida = new Act13_SalidaCompartida();
		Act13_Arbitro arbitro = new Act13_Arbitro(buzonSalida);
		
		Thread corredor1 = new Thread(new Act13_Corredor("corredor 1 ", buzonSalida));
		Thread corredor2 = new Thread(new Act13_Corredor("corredor 2 ", buzonSalida));
		Thread corredor3 = new Thread(new Act13_Corredor("corredor 3 ", buzonSalida));
		Thread corredor4 = new Thread(new Act13_Corredor("corredor 4 ", buzonSalida));
		
		corredor1.start();
		corredor2.start();
		corredor3.start();
		arbitro.start();
		
		try {
			
			arbitro.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		corredor4.start();
		
		try {
			corredor1.join();
			corredor2.join();
			corredor3.join();
			corredor4.join();
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Fin de la carrera");
		
	}
}

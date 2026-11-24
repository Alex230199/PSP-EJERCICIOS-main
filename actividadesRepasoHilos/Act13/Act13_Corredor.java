package actividadesRepasoHilos.Act13;

public class Act13_Corredor implements Runnable {
	
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

	private String nombre;
	private Act13_SalidaCompartida salida;
	
	public Act13_Corredor (String nombre, Act13_SalidaCompartida salida) {
		this.nombre = nombre;
		this.salida = salida;
	}
	
	@Override
	
	public void run() {
		
		try {
			salida.esperarSalida();
			
			for(int i = 1; i <= 3; i++) {
				System.out.println(nombre + " da el paso " + i);
			}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

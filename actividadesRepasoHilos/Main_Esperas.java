package actividadesRepasoHilos;

public class Main_Esperas {
	
	/*
	 Concepto nuevo: Métodos estáticos de Thread.
Crea dos tareas Runnable que escriban cinco mensajes cada una. La primera esperará 200 ms entre 
mensajes y la segunda, 400 ms.
1. Pon nombres a los dos hilos. Dentro de run(), obtén el nombre del hilo que está ejecutando la tarea 
mediante Thread.currentThread().getName().
2. Entre mensajes, usa Thread.sleep(...) con el tiempo de cada tarea. Escribe la llamada con el 
nombre de la clase Thread.
3. Para compilar sin estudiar aún las interrupciones, coloca el código de run() dentro de try y añade 
catch (InterruptedException e) { return; }. En este ejercicio no llames a interrupt().
4. Arranca ambos hilos y espera a que terminen con join(), como en el ejercicio 3.
COMPRUEBA
Aparecen diez mensajes con sus nombres. Las pausas aproximan el ritmo, pero no garantizan una 
alternancia ni tiempos exactos.
EXPLICA
¿Se detiene el programa entero durante Thread.sleep(...) o solo el hilo que realiza esa llamada?
	 */

	public static void main (String [] args) throws InterruptedException {
		
		Runnable persona1 = new Act4_Esperas();
		Runnable persona2 = new Act4_Esperas();
		
		Thread hilo1 = new Thread(persona1);
		Thread hilo2 = new Thread(persona2);
		
		hilo1.setName("Mari");
		hilo2.setName("Pili");
		
		hilo1.start();
		hilo2.start();
		
		hilo1.join();
		hilo2.join();
		
		System.out.println("Todos los hilos han acabado");
	}
}

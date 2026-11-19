package actividadesRepasoHilos;

public class Main_saludo_Runnable {
	
	/*
	 Concepto nuevo: Creación de hilos mediante Runnable.
Repite los saludos del ejercicio 1 utilizando una clase que implemente Runnable. Mantén dos tareas y 
cinco mensajes por tarea.
1. Crea TareaSaludo, que implemente Runnable. Añade el atributo etiqueta, su constructor y el método 
run().
2. En main, crea una tarea con la etiqueta A y otra con la etiqueta B. Cada tarea tendrá su propio objeto.
3. Crea un Thread para cada tarea, pasándola al constructor. Arranca los dos objetos Thread con 
start().
COMPRUEBA
Deben aparecer diez saludos. Cada tarea conserva su numeración del 1 al 5. El orden entre tareas puede 
cambiar.
EXPLICA
En tu programa, ¿qué objeto contiene el trabajo que hay que hacer y qué objeto permite ejecutarlo en 
otro hilo
	 */

	public static void main (String[] args) {
		
		Act2_Saludo_Runnable tarea1 = new Act2_Saludo_Runnable ("A");
		Act2_Saludo_Runnable tarea2 = new Act2_Saludo_Runnable ("B");
		
		Thread hilo1 = new Thread(tarea1);
		Thread hilo2 = new Thread(tarea2);
		
		hilo1.start();
		hilo2.start();
	}
}

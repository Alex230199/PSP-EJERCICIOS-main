package actividadesRepasoHilos.Act2;

public class Act2_Saludo_Runnable implements Runnable {
	
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

	private String etiqueta;

	public Act2_Saludo_Runnable (String texto) {
		
		this.etiqueta = texto;
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(this.etiqueta + " saluda " + i);
			
		}
	}

}

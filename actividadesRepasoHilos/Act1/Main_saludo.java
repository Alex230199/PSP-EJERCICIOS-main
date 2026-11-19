package actividadesRepasoHilos.Act1;

public class Main_saludo {
	
	/*
	 Concepto nuevo: Creación de hilos mediante Thread.
Vas a crear dos hilos que escriban saludos en la consola. Cada uno debe escribir cinco mensajes, 
numerados del 1 al 5.
1. Crea la clase SaludoThread como subclase de Thread. Su constructor recibirá una etiqueta de texto y la 
guardará en un atributo.
2. Sobrescribe run(). Dentro, escribe los cinco mensajes con la etiqueta y el número, por ejemplo: «A 
saluda 1».
3. En main, crea dos objetos SaludoThread con las etiquetas A y B. Llama a start() sobre los dos. No 
añadas pausas ni datos que ambos modifiquen.
4. Ejecuta tres veces. Después, en una copia del programa, cambia las dos llamadas a start() por 
llamadas a run().
COMPRUEBA
En ambas versiones aparecen diez saludos. Con start(), A y B pueden mezclarse o aparecer por grupos; 
cada etiqueta conserva el orden del 1 al 5. Con las llamadas directas a run(), una tarea se ejecuta 
completa antes de la otra.
EXPLICA
¿Por qué run() y start() no tienen el mismo efecto, aunque alguna ejecución muestre los mensajes en 
el mismo orden?
	 */
	
	public static void main (String[] args) {
		

	Act1_Saludo hilo1 = new Act1_Saludo("A");
	Act1_Saludo hilo2 = new Act1_Saludo("B");
	
	
	//hilo1.start();
	//hilo2.start();
	hilo1.run();
	hilo2.run();
	
	//el run() hace que primero acabe uno y luego el otro
	//mientras que el start() instercala ambos procesos a la vez.
	}
}

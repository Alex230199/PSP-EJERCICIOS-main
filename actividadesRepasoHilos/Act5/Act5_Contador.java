package actividadesRepasoHilos.Act5;

public class Act5_Contador {
	
	/*
	 Concepto nuevo: Acceso a un recurso compartido.
Cuatro tareas van a incrementar el mismo contador. El objetivo es observar qué puede ocurrir cuando 
varias tareas modifican un dato sin coordinarse.
1. Crea Contador con un atributo int valor inicializado a cero y un método incrementar() que ejecute 
valor++.
2. En main, crea un único objeto Contador. Pasa ese mismo objeto a las cuatro tareas; no crees un 
contador por tarea.
3. Cada tarea llamará 100 000 veces a incrementar(). Arranca los cuatro hilos, espera a todos con 
join() y muestra el valor final. No imprimas dentro del bucle.
4. Repite diez ejecuciones y anota el resultado de cada una. Todavía no uses synchronized ni otro 
mecanismo de protección.
COMPRUEBA
Si no se perdiera ningún incremento, el total sería 400 000. Puede aparecer un valor menor. Que las diez 
pruebas den el total esperado tampoco demuestra que el código sea seguro.
EXPLICA
¿Cómo podrían perderse incrementos si dos hilos leen el mismo valor antes de escribir el siguiente?

	 */

	private int valor = 0;
	
	public void incrementar() {
		
		valor++;
	}
	
	public int getValor() {
		return valor;
	}
}

package actividadesRepasoHilos;

public class Main_Contador {
	
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

	public static void Main (String[] args) throws InterruptedException {
		
		Act5_Contador contadorUnico = new Act5_Contador();
		
		Runnable p1 = new Act5_FuncionamientoContador(contadorUnico);
		Runnable p2 = new Act5_FuncionamientoContador(contadorUnico);
		Runnable p3 = new Act5_FuncionamientoContador(contadorUnico);
		Runnable p4 = new Act5_FuncionamientoContador(contadorUnico);
		
		Thread hilo1 = new Thread(p1);
		Thread hilo2 = new Thread(p2);
		Thread hilo3 = new Thread(p3);
		Thread hilo4 = new Thread(p4);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
		hilo1.join();
		hilo2.join();
		hilo3.join();
		hilo4.join();
		
		System.out.println("El valor final del contador es: " + contadorUnico.getValor());
		
		
	}
}

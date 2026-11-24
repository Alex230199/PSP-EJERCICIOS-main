package actividadesRepasoHilos.Act6;

public class Main_ContadorSynchronized {
	
	/*
	 *Concepto nuevo: Protección con synchronized.
Corrige el contador del ejercicio 5. Los cuatro hilos deben actualizarlo sin que se pierdan incrementos.
1. Haz privado el atributo valor y convierte incrementar() en un método synchronized. Todas las 
tareas seguirán usando el mismo Contador.
2. Mantén cuatro hilos y 100 000 incrementos por hilo. Añade un método para consultar el total y úsalo 
desde main después de todos los join().
3. En una segunda versión, quita synchronized de la declaración del método y protege valor++ con un 
bloque synchronized sobre el mismo Contador.
4. Usar el mismo objeto como cerrojo permite que solo un hilo ejecute esa parte protegida cada vez. Ese 
mecanismo de acceso se denomina monitor.
COMPRUEBA
Las dos versiones deben producir 400 000. Ejecuta cada una diez veces.
EXPLICA
¿Por qué no bastaría con que cada tarea protegiera el incremento utilizando un objeto diferente como 
cerrojo?
	 */
	
	public static void Main (String[] args) throws InterruptedException {
		
		Act6_Contador_Synchronized contadorUnico = new Act6_Contador_Synchronized();
		
		Runnable p1 = new Act6_FuncionamientoContador_Synchronized(contadorUnico);
		Runnable p2 = new Act6_FuncionamientoContador_Synchronized(contadorUnico);
		Runnable p3 = new Act6_FuncionamientoContador_Synchronized(contadorUnico);
		Runnable p4 = new Act6_FuncionamientoContador_Synchronized(contadorUnico);
		
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



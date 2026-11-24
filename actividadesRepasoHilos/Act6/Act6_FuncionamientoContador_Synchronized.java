package actividadesRepasoHilos.Act6;

public class Act6_FuncionamientoContador_Synchronized implements Runnable {
	
	/*
	 Concepto nuevo: Protección con synchronized.
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
	
	private Act6_Contador_Synchronized contador;
	
	public Act6_FuncionamientoContador_Synchronized (Act6_Contador_Synchronized contador) {
		
		this.contador = contador;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 100000; i++) {
			
			contador.incrementar();
		}
	}
}

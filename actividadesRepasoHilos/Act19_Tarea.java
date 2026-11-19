package actividadesRepasoHilos;

public class Act19_Tarea {
	
	
	/*
	 Conceptos: Runnable, synchronized, wait, notifyAll, interrupciones y join.
Crea un servicio con tres hilos trabajadores y una cola de hasta cuatro tareas pendientes. Los 
trabajadores reutilizan su hilo para ejecutar varias tareas. Este conjunto se conoce como pool 
de trabajadores.
1. Cada tarea tendrá un identificador y simulará su trabajo con una pausa fuera del monitor. 
Considera que termina correctamente cuando esa pausa acaba sin interrupción.
2. enviar() espera con while si la cola está llena. Devuelve true si encola la tarea y false
si el servicio ya está cerrado. Si se interrumpe la espera, propaga 
InterruptedException. Todos los cambios de estado usan el mismo monitor.
3. Los trabajadores esperan si la cola está vacía y el servicio sigue abierto. Retiran una tarea 
bajo el monitor, avisan de que queda espacio y la ejecutan fuera de él.
4. cerrar() impide nuevos envíos y despierta a quienes esperan. Permite ejecutar todo lo 
aceptado: cada trabajador sale cuando el servicio está cerrado y ya no hay tareas en la 
cola.
5. cancelarAhora() también cierra el servicio, retira y registra las tareas pendientes y 
despierta a quienes esperan. Después solicita la interrupción de los trabajadores. Una 
tarea ya retirada que no llegue a completarse se registra como cancelada.
6. Prueba por separado el cierre normal tras aceptar doce tareas, la cancelación con trabajo 
pendiente y un cierre mientras un hilo intenta enviar. Espera a todos los hilos fuera del 
monitor.
COMPRUEBA
En el cierre normal se completan las doce tareas, una vez cada una. En cancelación, cada tarea 
aceptada aparece como completada, cancelada tras retirarla o retirada de la cola por 
cancelarAhora(). Las tareas rechazadas se cuentan aparte. Nadie queda esperando 
después del cierre.
EXPLICA
¿Cómo decides si una tarea se acepta cuando enviar() y cerrar() se ejecutan casi al 
mismo tiempo?
	 */

	private int id;
	
	public Act19_Tarea (int id) {
		
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}

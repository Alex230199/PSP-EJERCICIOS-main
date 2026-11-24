package actividadesRepasoHilos.Act3;

public class Main_setName {
	
	/* 
	 Concepto nuevo: Métodos de instancia de Thread.
Crea dos tareas Runnable que impriman veinte mensajes cada una. El programa principal debe mostrar 
los nombres de sus hilos y esperar a que ambos terminen.
1. Antes de arrancar, asigna los nombres Trabajador1 y Trabajador2 con setName(). Muestra esos 
nombres desde main con getName().
2. Consulta isAlive() en tres momentos: antes de start(), después de arrancar y después de esperar 
a la terminación.
3. Arranca los dos hilos antes de llamar a join() sobre cada uno. Al terminar las dos esperas, escribe 
«Todos han terminado».
4. Para usar join() sin desarrollar aún la cancelación, puedes declarar main con throws 
InterruptedException.
COMPRUEBA
isAlive() vale false antes del arranque y después de join(). Justo después de start() puede valer 
true o false, según haya terminado ya el hilo. El mensaje final debe aparecer después de los cuarenta 
mensajes de las tareas.
EXPLICA
¿Qué ocurriría si hicieras start() y join() del primer hilo antes de arrancar el segundo?
	 */

	public static void main (String[]args) throws InterruptedException {
		
		Runnable trab1 = new Act3_setName();
		Runnable trab2 = new Act3_setName();
		
		Thread trabajador1 = new Thread(trab1);
		Thread trabajador2 = new Thread(trab2);
		
		trabajador1.setName("Pepe");
		trabajador2.setName("Carla");
		
		System.out.println("Nombre del hilo 1: " + trabajador1.getName());
		System.out.println("Nombre del hilo 2: " + trabajador2.getName());
		
		System.out.println("Trabajador 1 Is Alive (antes de start() ) " + trabajador1.isAlive());
		System.out.println("Trabajador 2 Is Alive (antes de start() )" + trabajador2.isAlive());
		
		trabajador1.start();
		trabajador2.start();
		
		System.out.println("Trabajador 1 Is Alive (despues de start() ) " + trabajador1.isAlive());
		System.out.println("Trabajador 2 Is Alive (despues de start() )" + trabajador2.isAlive());
		
		trabajador1.join();
		trabajador2.join();
		
		System.out.println("Trabajador 1 Is Alive (despues de join() ) " + trabajador1.isAlive());
		System.out.println("Trabajador 2 Is Alive (despues de join() )" + trabajador2.isAlive());
		
		System.out.println("Todos han terminado");
		
	}
}

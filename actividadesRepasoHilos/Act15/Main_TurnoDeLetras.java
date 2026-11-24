package actividadesRepasoHilos.Act15;

public class Main_TurnoDeLetras {
	
	/*
	 Conceptos: Estado compartido, synchronized, wait, notifyAll e interrupciones.
Dos hilos imprimirán las letras A y B, por turnos, hasta obtener exactamente ABABABABAB.
1. Crea una variable compartida turno, inicialmente A. Cada hilo esperará con while y 
wait() mientras no le toque.
2. En una misma sección sincronizada, imprime la letra sin salto de línea, cambia el turno y 
llama a notifyAll(). Cada hilo imprimirá cinco veces. No uses sleep para organizar los 
turnos.
3. Añade cancelado, inicialmente false. Si un participante detecta una interrupción o recibe 
InterruptedException, pondrá cancelado a true bajo el monitor y avisará a todos.
4. Ambos deben consultar cancelado antes de esperar y antes de imprimir. Prueba una 
ejecución normal y otra en la que main interrumpa a uno; espera a ambos con join().
COMPRUEBA
La prueba normal produce ABABABABAB. Si la cancelación llega a tiempo, puede salir solo el 
principio de esa secuencia, como ABA. Si ya han terminado, la secuencia estará completa. 
Nunca debe quedar uno esperando al otro.
EXPLICA
¿Por qué avisar al otro hilo no es suficiente si este solo comprueba a quién le toca?
	 */

	public static void main (String [] args) throws InterruptedException {
		
		
		System.out.println("===PRUEBA NORMAL===");
		Act15_ControlTurno control1 = new Act15_ControlTurno();
		Thread hilo1 = new Thread (new Act15_Letras(control1, 'A'));
		Thread hilo2 = new Thread (new Act15_Letras(control1, 'B'));
		
		hilo1.start();
		hilo2.start();
		
		
		hilo1.join();
		hilo2.join();
		
		System.out.println();
		
		
		System.out.println("===PRUEBA CON INTERRUPCION");
		Act15_ControlTurno control2 = new Act15_ControlTurno();
		Thread hiloB1 = new Thread (new Act15_Letras(control2, 'A'));
		Thread hiloB2 = new Thread (new Act15_Letras(control2, 'B'));
		
		hiloB1.start();
		hiloB2.start();
		
		Thread.sleep(15);
		hiloB1.interrupt();
		
		hiloB1.join();
		hiloB2.join();
		
		System.out.println("Fin de las pruebas");
	}
}

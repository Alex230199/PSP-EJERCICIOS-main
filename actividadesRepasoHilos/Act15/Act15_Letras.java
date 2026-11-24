package actividadesRepasoHilos.Act15;

public class Act15_Letras implements Runnable {
	
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

	private Act15_ControlTurno control;
	private char letra;
	
	public Act15_Letras (Act15_ControlTurno control, char letra) {
		
		this.control = control;
		this.letra = letra;
		
	}
	
	@Override
	
	public void run() {
		
		try {
			for (int i = 0; i < 5; i++) {
				control.imprimirLetra(letra);
			}
		}catch (InterruptedException e) {
			synchronized (control) {
				control.marcaCancelado();
			}
			
			Thread.currentThread().interrupt();
		}
	}
}

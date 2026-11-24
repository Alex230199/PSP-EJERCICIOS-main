package actividadesRepasoHilos.Act18;

public class Main_BarrerayTrabajadores {
	

	/*
	 Conceptos: synchronized, wait, notifyAll e interrupciones.
Cuatro trabajadores realizarán tres fases. Ninguno podrá empezar la fase siguiente hasta que 
los cuatro hayan terminado la actual. Construirás una barrera: un punto donde el grupo se 
reúne antes de continuar.
1. Cada trabajador mostrará «Inicio fase N», simulará trabajo con una pausa y mostrará «Fin 
fase N». Después llamará al método de la barrera. Las pausas se hacen fuera del monitor.
2. La barrera tendrá un contador de llegadas y una generación, es decir, un número que 
identifica cada reunión del grupo. Protege ambos con el mismo monitor.
3. Cada trabajador recuerda la generación a la que llega. El último en llegar reinicia el 
contador, avanza la generación y llama a notifyAll(). Los demás esperan con while
mientras no cambie su generación y la barrera no esté cancelada.
4. Añade cancelar(). Si un trabajador se interrumpe durante el trabajo o la espera, activará 
esa condición bajo el monitor y avisará a todos. Una llamada a la barrera debe distinguir 
entre reunión completada y cancelación.
5. Los trabajadores comprobarán la cancelación antes de otra fase. Si alguno ya estaba 
trabajando cuando se cancela, puede acabar esa fase, pero debe salir al comprobar la 
cancelación. Main esperará a todos con join().
COMPRUEBA
En la prueba normal, antes de cualquier inicio de la fase 2 deben aparecer los cuatro finales 
de la fase 1; lo mismo entre las fases 2 y 3. En otra prueba, interrumpe a un trabajador y 
comprueba que ninguno queda bloqueado en la barrera.
EXPLICA
¿Qué problema habría si un trabajador rápido empezara la siguiente reunión mientras otros 
aún salen de la anterior y no existiera el número de generación?
	 */

	public static void main (String [] args) throws InterruptedException{
		
		int numTrabajadores = 4;
		Act18_Barrera barrera = new Act18_Barrera(numTrabajadores);
		
		Thread[] hilos = new Thread [numTrabajadores];
		
		for (int i = 0; i < numTrabajadores; i++) {
			hilos[i] = new Thread (new Act18_Trabajador(i + 1, barrera));
			hilos[i].start();
		}
		
		/* --- PRUEBA DE CANCELACIÓN (Opcional) ---
         Descomenta las siguientes líneas para probar la interrupción de un trabajador:
        
        Thread.sleep(100); // Dejar trabajar un momento
        hilos[0].interrupt(); // Interrumpimos al trabajador 1
        */
		
		for (int i = 0; i < numTrabajadores; i++) {
			hilos[i].join();
		}
		
		System.out.println("fIn del programa. Todos los hilos han  terminado");
	}
}

package actividadesRepasoHilos.Act8;

public class Main_Puerta {
	
	/*
	 Concepto nuevo: Espera mediante wait.
Crea un objeto Puerta con un atributo boolean abierta inicialmente false. Un hilo esperará para pasar y 
otro cambiará abierta a true.
1. Todas las consultas y modificaciones de abierta deben hacerse dentro de synchronized, utilizando la 
misma puerta como cerrojo.
2. El hilo que espera comprobará la condición con while. Mientras la puerta siga cerrada, llamará a 
wait(200) sobre esa puerta dentro del bloque sincronizado. Al verla abierta, escribirá «Paso 
permitido».
3. El otro hilo hará una pausa de unos 600 ms fuera de synchronized. Después entrará en el bloque 
sincronizado y abrirá la puerta.
4. Espera a ambos con join(). Si un hilo recibe InterruptedException, restaura su marca y termina
su run(). Todavía no uses notify ni notifyAll.
COMPRUEBA
El programa termina y solo se permite el paso con la puerta abierta. wait(200) libera temporalmente el 
monitor; al volver, hay que adquirirlo de nuevo y comprobar la condición, incluso si la espera termina 
antes de lo previsto.
EXPLICA
¿Por qué el otro hilo puede abrir la puerta mientras el primero está dentro de wait()?
	 */
	
	public static void main (String [] args) {
		Act8_Puerta puerta = new Act8_Puerta();
		
		Thread hEspera = new Thread (new Act8_PuertaEspera(puerta));
		Thread hAbierta = new Thread (new Act8_PuertaAbierta(puerta));
		
		hEspera.start();
		hAbierta.start();
		
		try {
			hEspera.join();
			hAbierta.join();
			
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}

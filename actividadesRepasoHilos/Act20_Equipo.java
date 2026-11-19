package actividadesRepasoHilos;

public class Act20_Equipo extends Thread {
	
	/*
	 Conceptos: Recursos compartidos, synchronized, wait, notifyAll e interrupciones.
Cinco equipos comparten dos cámaras y tres micrófonos. Cada equipo necesita una cámara y 
un micrófono a la vez para hacer una grabación. Representa cada equipo con un hilo.
1. Crea un objeto compartido que guarde las cantidades disponibles. reservar() esperará 
mientras falte una cámara o un micrófono. Usa while, wait() y el mismo monitor para 
todas las consultas y cambios.
2. Cuando haya ambos recursos, descuenta los dos dentro de la misma sección sincronizada. 
Una reserva solo se considera realizada después de ese descuento conjunto.
3. Cada equipo intentará hacer tres grabaciones. Simula cada grabación con sleep() fuera 
del monitor. Registra una grabación como completada solo si esa pausa termina 
normalmente.
4. Devuelve los dos recursos en finally, también si se interrumpe la grabación. Hazlo solo si 
la reserva se realizó: un hilo interrumpido mientras esperaba no debe devolver nada. La 
devolución debe estar sincronizada y avisar con notifyAll().
5. Prueba primero sin cancelación. Después, en otra ejecución, main interrumpirá a todos y 
hará join() a todos. Los equipos atenderán la interrupción durante la espera, durante la 
grabación y antes de intentar otra reserva.
COMPRUEBA
Sin cancelación se completan quince grabaciones. Las cantidades disponibles nunca son 
negativas ni superan dos cámaras y tres micrófonos. Al acabar cualquiera de las pruebas, 
todos los recursos vuelven a estar disponibles y no quedan hilos activos.
EXPLICA
¿Por qué despertar a todos con notifyAll() no garantiza que los equipos consigan los 
recursos por orden de llegada?
	 */

	private Act20_BaulCantidades cosas;
	private String nombre;
	
	public Act20_Equipo (String nombre, Act20_BaulCantidades cosas) {
		
		this.cosas = cosas;
		this.nombre = nombre;
		
	}
	
	@Override
	public void run() {
		
		int grabacionesRealizadas = 0;
		
		while (grabacionesRealizadas < 3) {
			
			if (Thread.currentThread().isInterrupted()) {
				break;
			}
			
			boolean estaReservado = false;
			
			try {
				cosas.reservar();
				estaReservado = true;
				
				Thread.sleep(800);
				
				grabacionesRealizadas ++;
				
			} catch (InterruptedException e) {
				System.out.println(nombre +  " Fue parado");
				
				Thread.currentThread().interrupt();
				
				break;
			} finally {
				
				if (estaReservado) {
					
					cosas.devolver();
				}
			}
		}
	}
	
}

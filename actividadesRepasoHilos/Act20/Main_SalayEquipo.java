package actividadesRepasoHilos.Act20;

public class Main_SalayEquipo {
	
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

	public static void main (String [] args) throws InterruptedException {
		
		//Prueba 1
		
		Act20_BaulCantidades cosasPrueba1 = new Act20_BaulCantidades();
		Thread[] equipos1 = new Thread[5];
		
		for ( int i = 0; i < 5; i++) {
			equipos1[i] = new Thread(new Act20_Equipo ("equipo " + (i + 1), cosasPrueba1));
			equipos1[i].start();
		}
		
		for (int i = 0; i < 5; i++) {
			equipos1[i].join();
		}
 		
		
		System.out.println("FIN DE LA PRUEBA 1");
		
		//Prueba 2
		
		Act20_BaulCantidades cosasPrueba2 = new Act20_BaulCantidades();
		Thread[] equipos2 = new Thread[5];
		
		
		for (int i = 0; i < 5; i++) {
			equipos2[i] = new Thread(new Act20_Equipo ("equipo " + (i + 1), cosasPrueba2));
			equipos2[i].start();
			
		}
		
		Thread.sleep(500);
		
		System.out.println("aqui se para este hilo en la prueba 2");
		
		for (int i = 0; i < 5; i++) {
			equipos2[i].join();
			
			
		}
		
		System.out.println("Fin de la prueba 2 y FIN DEL PROGRAMA!!");
	}
}

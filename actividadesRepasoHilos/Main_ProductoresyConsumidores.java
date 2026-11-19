package actividadesRepasoHilos;

public class Main_ProductoresyConsumidores {
	
	/*
	 Conceptos: Runnable, synchronized, wait, notifyAll e interrupciones.
Dos productores introducirán datos en un almacén de capacidad cinco. Tres consumidores los 
retirarán. Cada productor intentará introducir diez datos con identificadores distintos, por 
ejemplo P1-1 y P2-1.
1. Protege el almacén con un único monitor. Para almacenar, espera mientras esté lleno. Para 
retirar, espera mientras esté vacío y todavía queden productores trabajando. Usa while y 
wait().
2. Guarda un contador de productores activos, inicialmente 2. Cada productor lo reducirá 
exactamente una vez al terminar, también si se interrumpe. Comunica ese cambio y los 
cambios de ocupación con notifyAll().
3. Cuando el almacén esté vacío y no queden productores, retirar() devolverá una señal 
de fin, como null, para que los consumidores terminen. Los datos normales no podrán ser 
null.
4. Para esta actividad, un dato cuenta como consumido en el momento de retirarlo. Registra 
su identificador y la retirada dentro de la misma sección sincronizada. Cualquier pausa 
posterior simula trabajo y se hace fuera del monitor.
5. Prueba el funcionamiento normal, capacidad uno y consumidores lentos. Después prueba 
cancelación: main interrumpirá a todos y hará join() a todos. Los bucles deben atender 
la interrupción.
COMPRUEBA
Sin cancelación se almacenan y retiran veinte identificadores, sin duplicados. La ocupación 
nunca supera la capacidad. Tras cancelar, los datos que llegaron a almacenarse deben 
coincidir exactamente con los retirados más los que siguen dentro; los que no llegaron a 
entrar se cuentan aparte.
EXPLICA
¿Por qué el último productor tiene que avisar aunque no haya añadido un dato nuevo?
	 */

	public static void main (String [] args) throws InterruptedException{
		Act16_Almacen almacen = new Act16_Almacen();
		
		Thread productor1 = new Thread (new Act16_Productor(1, almacen));
		Thread productor2 = new Thread (new Act16_Productor(2, almacen));
		Thread consumidor1 = new Thread (new Act16_Consumidor("Consumidor 1", almacen));
		Thread consumidor2 = new Thread (new Act16_Consumidor("Consumidor 2", almacen));
		Thread consumidor3 = new Thread (new Act16_Consumidor("Consumidor 3", almacen));
		
		productor1.start();
		productor2.start();
		consumidor1.start();
		consumidor2.start();
		consumidor3.start();
		
		/* Prueba de cancelacion
		 
		 Thread.sleep(50);
        p1.interrupt();
        p2.interrupt();
        c1.interrupt();
        c2.interrupt();
        c3.interrupt(); 
		  
		 
		 */
		
		productor1.join();
		productor2.join();
		consumidor1.join();
		consumidor2.join();
		consumidor3.join();
		
		System.out.println("Final del programa");
		
	}
}

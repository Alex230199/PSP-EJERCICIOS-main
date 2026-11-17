package actividadesRepasoHilos;

public class Main_ProductoresyConsumidores {

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

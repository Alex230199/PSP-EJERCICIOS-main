package actividadesRepasoHilos;

public class Main_Buzon {

	public static void main (String [] args) {
		
		Act12_Buzon buzon = new Act12_Buzon();
		
		Thread hProductor = new Thread(new Act12_Productor(buzon));
		Thread hConsumidor = new Thread(new Act12_Consumidor(buzon));
		
		hProductor.start();
		hConsumidor.start();
		
		/* COMPROBACION DE CANCELACIÓN (PUNTO 4)
		try {
			Thread.sleep(50);
			hProductor.interrupt();
			hConsumidor.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		try {
			hProductor.join();
			hConsumidor.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Fin del programa");
		
		
	}
}

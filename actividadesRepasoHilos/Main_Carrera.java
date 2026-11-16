package actividadesRepasoHilos;

public class Main_Carrera {

	public static void main (String [] args) {
		
		Act13_SalidaCompartida buzonSalida = new Act13_SalidaCompartida();
		Act13_Arbitro arbitro = new Act13_Arbitro(buzonSalida);
		
		Thread corredor1 = new Thread(new Act13_Corredor("corredor 1 ", buzonSalida));
		Thread corredor2 = new Thread(new Act13_Corredor("corredor 2 ", buzonSalida));
		Thread corredor3 = new Thread(new Act13_Corredor("corredor 3 ", buzonSalida));
		Thread corredor4 = new Thread(new Act13_Corredor("corredor 4 ", buzonSalida));
		
		corredor1.start();
		corredor2.start();
		corredor3.start();
		arbitro.start();
		
		try {
			
			arbitro.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		corredor4.start();
		
		try {
			corredor1.join();
			corredor2.join();
			corredor3.join();
			corredor4.join();
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Fin de la carrera");
		
	}
}

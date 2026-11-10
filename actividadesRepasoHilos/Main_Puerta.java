package actividadesRepasoHilos;

public class Main_Puerta {
	
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

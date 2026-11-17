package actividadesRepasoHilos;

public class Main_PuertaNotify {
	
	public static void main (String [] args) {
		
		System.out.println("--PRUEBA 1: AMBOS HILOS SE ARRANCAN A LA VEZ--");
		
		Act9_PuertaNotify puerta = new Act9_PuertaNotify();
		
		Thread hEspera = new Thread (new Act9_PuertaEsperaNotify(puerta));
		Thread hAbierta = new Thread (new Act9_PuertaAbiertaNotify(puerta));
		
		hEspera.start();
		hAbierta.start();
		
		try {
			hEspera.join();
			hAbierta.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("--PRUEBA 2: ARRANCA PRIMERO EL QUE ABRE YDESPUÉS ARRANCO AL QUE QUIERE PASAR");
		
		Act9_PuertaNotify puerta2 = new Act9_PuertaNotify();
		
		Thread hEspera2 = new Thread (new Act9_PuertaEsperaNotify(puerta2));
		Thread hAbierta2 = new Thread (new Act9_PuertaAbiertaNotify(puerta2));
		
		hEspera2.start();
		
		try {
			hEspera2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		hAbierta2.start();
		
		try {
			hAbierta2.join();
			
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("FIN DEL PROGRAMA");
	}
}

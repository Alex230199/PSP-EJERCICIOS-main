package actividadesRepasoHilos;

public class Act7_Interrupciones implements Runnable {

	@Override
	public void run() {
		
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("El trabajador está repitiendo el mensaje...");
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
}

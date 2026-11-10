package actividadesRepasoHilos;

public class Act10_PuertaAbiertaNotifyAll implements Runnable{
 
	private Act10_PuertaNotifyAll puerta;

	public Act10_PuertaAbiertaNotifyAll (Act10_PuertaNotifyAll puerta) {
		
		this.puerta = puerta;
	}
	
	@Override
	
	public void run() {
		
		try {
			Thread.sleep(200);
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
		
		synchronized (puerta) {
			puerta.abierta = true;
			puerta.notifyAll();
		}
	}
}

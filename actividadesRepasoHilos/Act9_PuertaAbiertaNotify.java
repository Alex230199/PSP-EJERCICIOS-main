package actividadesRepasoHilos;

public class Act9_PuertaAbiertaNotify implements Runnable {

	private Act9_PuertaNotify puerta;
	
	public Act9_PuertaAbiertaNotify ( Act9_PuertaNotify puerta) {
		
		this.puerta = puerta;
	}
	
	@Override
	
	public void run() {
		
		try{
			Thread.sleep(200);
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
		
		synchronized(puerta){
			puerta.abierta = true;
			puerta.notify();
		}
		
	}
}

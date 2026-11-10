package actividadesRepasoHilos;

public class Act8_PuertaAbierta implements Runnable {

	private Act8_Puerta puerta;
	
	public Act8_PuertaAbierta (Act8_Puerta puerta) {
		
		this.puerta = puerta;
	}
	
	@Override
	
	public void run() {
		
		try {
			Thread.sleep(null);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
		
		synchronized(puerta) {
			puerta.abierta = true;
		}
	}
}

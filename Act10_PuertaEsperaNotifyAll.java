package actividadesRepasoHilos;

public class Act10_PuertaEsperaNotifyAll implements Runnable {
	
	private Act10_PuertaNotifyAll puerta;

	public Act10_PuertaEsperaNotifyAll (Act10_PuertaNotifyAll puerta) {
		
		this.puerta = puerta;
	}
	
		@Override
	
		public void run() {
			synchronized (puerta) {
				
				while (!puerta.abierta) {
					
				try {
				 
					puerta.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						return;
					}
				}
			
			System.out.println("Paso permitido para: " + Thread.currentThread().getName());
		
		}
	}
}

package actividadesRepasoHilos;

public class Act9_PuertaEsperaNotify implements Runnable {

	private Act9_PuertaNotify puerta;
	
	public Act9_PuertaEsperaNotify ( Act9_PuertaNotify puerta) {
		
		this.puerta = puerta;
		
	}
	
@Override
	
	public void run() {
		
		synchronized(puerta) {
			
			while(!puerta.abierta) {
				
				try {
					puerta.wait();
				}catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
				
			}
			
			System.out.println("Paso permitido");
		}
	}
}

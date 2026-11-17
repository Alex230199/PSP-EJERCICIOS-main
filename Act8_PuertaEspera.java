package actividadesRepasoHilos;

public class Act8_PuertaEspera implements Runnable {

	private Act8_Puerta puerta;
	
	public Act8_PuertaEspera (Act8_Puerta puerta) {
		
		this.puerta = puerta;
		
	}
	
	@Override
	
	public void run() {
		
		synchronized(puerta) {
			
			while(!puerta.abierta) {
				
				try {
					puerta.wait(200);
				}catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
				
			}
			
			System.out.println("Paso permitido");
		}
	}
}

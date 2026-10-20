package bocadillo;

public class Cocinero implements Runnable {
	
	public Maquinabocadillo maquina;
	
	public Cocinero (Maquinabocadillo maquina) {
		this.maquina = maquina;
		
	}
	
	@Override
	public void run() {
		
		try {
			for (int i = 1; i <= 5; i++) {
				maquina.preparar(i);
				Thread.sleep(500);
			}
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	
}

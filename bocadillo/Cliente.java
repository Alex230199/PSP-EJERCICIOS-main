package bocadillo;

public class Cliente implements Runnable {
	
	public Maquinabocadillo maquina;
	
	public Cliente (Maquinabocadillo maquina) {
		this.maquina = maquina;
	}
	
	@Override
	public void run() {
		
		try {
			for (int i = 1; i <= 5; i++) {
				maquina.consumir(i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}

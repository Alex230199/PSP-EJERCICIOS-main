package actividadesRepasoHilos;

public class Act12_Consumidor implements Runnable {

	private Act12_Buzon buzon;
	
	public Act12_Consumidor( Act12_Buzon buzon) {
		
		this.buzon = buzon;
		
	}
	
	@Override
	
	public void run() {
		
		try {
			for (int i = 1; i <= 10; i++) {
				buzon.recoger();
				System.out.println("Consumidor recoge " + i);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Consumidor se ha interrumpido");
		}
	}
}

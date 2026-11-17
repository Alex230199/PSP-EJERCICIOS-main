package actividadesRepasoHilos;

public class Act12_Productor implements Runnable {

	private Act12_Buzon buzon;
	
	public Act12_Productor(Act12_Buzon buzon) {
		
		this.buzon = buzon;
		
	}
	
	@Override
	
	public void run() {
		
		try {
			for (int i = 1; i <= 10; i++ ) {
				buzon.poner(i);
				System.out.println("Productor envia " + i);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Productorinterrumpido");
		}
	}
}

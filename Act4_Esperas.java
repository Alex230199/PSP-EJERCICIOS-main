package actividadesRepasoHilos;

public class Act4_Esperas implements Runnable {

	private int milisegundos = 400;
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 5; i++) {
			
			try {
				
			
			System.out.println(Thread.currentThread().getName() + " mensaje: " + i);
			
			Thread.sleep(this.milisegundos);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
}

package actividadesRepasoHilos;

public class Act3_setName implements Runnable {

	@Override
	public void run() {
		
		for(int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + " - Mensaje " + i);
			
		}
	}
}

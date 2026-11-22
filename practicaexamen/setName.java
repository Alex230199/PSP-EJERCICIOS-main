package practicaexamen;

public class setName implements Runnable {
		
		@Override
		public void run() {
			
		
		for (int i = 1; i <= 20; i++) {
			System.out.println(Thread.currentThread().getName() + " envia mensaje numero " + i);
		}
		
	}
}


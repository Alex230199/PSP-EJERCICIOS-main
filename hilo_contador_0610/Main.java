package hilo_contador_0610;


public class Main {

	public static void main (String [] args) {
		
		
		Contador c1 = new Contador(0, 1);
        Contador c2 = new Contador(0, 2);
        Contador c3 = new Contador(0, 3);

        Thread hilo1 = new Thread(c1);
        Thread hilo2 = new Thread(c2);
        Thread hilo3 = new Thread(c3);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		while (true) {
			
			try {
				Thread.sleep(5000);
				
				System.out.println("petición de interrupción");
				
				hilo1.interrupt();
				hilo2.interrupt();
				hilo3.interrupt();
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

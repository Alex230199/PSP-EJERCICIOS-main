package ACT_HILOS;

public class Contador extends Thread {

	int pausa;
	
	Contador(int pausa){
		this.pausa = pausa;
	}
	
	public void run() {
		int c = 1;
		while (c <= 5) {
			
			System.out.println(c);
			
			try {
				Thread.sleep(pausa);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			c++;
		}
	}
}

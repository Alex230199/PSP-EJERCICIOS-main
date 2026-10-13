package ACT_HILOS;

public class ContadorNombrado extends Thread{

	String nombre;
	int pausa;
	
	ContadorNombrado(int pausa, String nombre){
		this.pausa = pausa;
		this.nombre = nombre;
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

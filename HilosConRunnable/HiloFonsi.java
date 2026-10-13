package HilosConRunnable;

public class HiloFonsi implements Runnable {
	
	String mensaje;
	
	HiloFonsi(String m){
		
		this.mensaje = m;
		
	}
	@Override
	public void run() {
		
		for (int i = 0; i<100;i++) {
			System.out.println(this.mensaje);
			
			try {
				Thread.sleep(100);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			}
		
	}

}

package actividadesRepasoHilos;

public class Act15_Letras implements Runnable {

	private Act15_ControlTurno control;
	private char letra;
	
	public Act15_Letras (Act15_ControlTurno control, char letra) {
		
		this.control = control;
		this.letra = letra;
		
	}
	
	@Override
	
	public void run() {
		
		try {
			for (int i = 0; i < 5; i++) {
				control.imprimirLetra(letra);
			}
		}catch (InterruptedException e) {
			synchronized (control) {
				control.marcaCancelado();
			}
			
			Thread.currentThread().interrupt();
		}
	}
}

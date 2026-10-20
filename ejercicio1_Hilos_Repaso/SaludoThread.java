package ejercicio1_Hilos_Repaso;

public class SaludoThread extends Thread {

	private String texto;
	
	public SaludoThread (String texto) {
		this.texto = texto;
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 5; i ++) {
			System.out.println(texto + " saluda..."+ i);
		}
		
	}
}

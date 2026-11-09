package actividadesRepasoHilos;

public class Act1_Saludo extends Thread {
	
	private String etiqueta;

	public Act1_Saludo (String texto) {
		
		this.etiqueta = texto;
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(this.etiqueta + " saluda " + i);
			
		}
	}
}

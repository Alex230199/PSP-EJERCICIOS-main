package actividadesRepasoHilos;

public class Act2_Saludo_Runnable implements Runnable {

	private String etiqueta;

	public Act2_Saludo_Runnable (String texto) {
		
		this.etiqueta = texto;
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(this.etiqueta + " saluda " + i);
			
		}
	}

}

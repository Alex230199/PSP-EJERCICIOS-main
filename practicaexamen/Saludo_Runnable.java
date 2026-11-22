package practicaexamen;

public class Saludo_Runnable implements Runnable{
	
	
	private String texto;
	
	public Saludo_Runnable (String etiqueta) {
		
		this.texto = etiqueta;
		
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			System.out.println(this.texto + "Saluda a " + i);
		}
	}

	
}

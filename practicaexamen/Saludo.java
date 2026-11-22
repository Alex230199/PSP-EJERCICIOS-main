package practicaexamen;


public class Saludo extends Thread {

	private String mensaje;
	
	public Saludo (String etiqueta) {
		
		this.mensaje = etiqueta;
		
	}
	
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			System.out.println(this.mensaje + "saluda a " + i );
		}
		
	}
}

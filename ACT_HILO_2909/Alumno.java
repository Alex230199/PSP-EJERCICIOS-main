package ACT_HILO_2909;

public class Alumno implements Runnable {
	
	String nombre;
	String mensaje;
	
	Alumno(String nombre){
		
		this.nombre = nombre;
		this.mensaje = "Hola soy " + this.nombre + " y este es mi mensaje número...";
		
	}
	
	@Override
	public void run() {
		
		int c = 0;
		for (int i = 0; i <= 5; i++ ) {
			
			System.out.println(this.mensaje + c);
		try {
			Thread.sleep(100);
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		c++;
		
		}
		
	}
}

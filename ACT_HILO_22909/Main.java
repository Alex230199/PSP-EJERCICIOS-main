package ACT_HILO_22909;

public class Main {
	public static void main (String [] args) {
		
		String nombre1 = "Marina";
		String nombre2 = "Pepe";
		String nombre3 = "Rebeca";
		
	Thread hilo1 = new Thread(new Alumno("Buenos dias!! :)" + nombre1));
	Thread hilo2 = new Thread(new Alumno("Bunas noches :)" + nombre2));
	Thread hilo3 = new Thread(new Alumno("Bunas noches :)" + nombre3));
	
	
	hilo1.start();
	hilo2.start();
	hilo3.start();
	
	
	} 
}

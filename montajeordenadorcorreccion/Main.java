package montajeordenadorcorreccion;

public class Main {

	public static void main (String [] args) throws InterruptedException  {//Esto solo va en el main
		//REVISAR EL CANAL "PILDORASINFORMATICA" SOBRE LAS EXCEPCIONES.
		
		PlacaBase trabajador1 = new PlacaBase();
		Almacenamiento trabajador2 = new Almacenamiento();
		TarjetaGrafica trabajador3 = new TarjetaGrafica();
		
		trabajador1.start();
		trabajador2.start();
		trabajador3.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		trabajador3.interrupt();
		
		trabajador1.join(); //el join hace que espere a que los otros hilos acaben.
		trabajador2.join();
		trabajador3.join();
		
		System.out.println("Todos los componentes están acabados");
		
		Thread.sleep(2000);
		
		System.out.println("ordenador termiando.");
	}
}

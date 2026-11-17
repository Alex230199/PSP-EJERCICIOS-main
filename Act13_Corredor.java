package actividadesRepasoHilos;

public class Act13_Corredor implements Runnable {

	private String nombre;
	private Act13_SalidaCompartida salida;
	
	public Act13_Corredor (String nombre, Act13_SalidaCompartida salida) {
		this.nombre = nombre;
		this.salida = salida;
	}
	
	@Override
	
	public void run() {
		
		try {
			salida.esperarSalida();
			
			for(int i = 1; i <= 3; i++) {
				System.out.println(nombre + " da el paso " + i);
			}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

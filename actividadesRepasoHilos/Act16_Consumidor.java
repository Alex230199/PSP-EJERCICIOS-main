package actividadesRepasoHilos;

public class Act16_Consumidor implements Runnable {
	
	private String nombre;
	private Act16_Almacen almacen;
	
	public Act16_Consumidor (String nombre, Act16_Almacen almacen) {
		
		this.nombre = nombre;
		this.almacen = almacen;
		
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				String dato = almacen.retirar();
				
				if ( dato ==null) {
					break;
				}
				
				System.out.println(nombre + "procesa " + dato);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}

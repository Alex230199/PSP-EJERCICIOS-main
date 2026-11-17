package actividadesRepasoHilos;

public class Act16_Productor implements Runnable {

	private int id;
	private Act16_Almacen almacen;
	
	public Act16_Productor (int id, Act16_Almacen almacen) {
		
		this.id = id;
		this.almacen = almacen;
		
	}
	
	@Override
	public void run() {
		
		try {
			for (int i = 1; i <= 10; i++) {
				
				String dato = "P " + id + "-" + i;
				almacen.almacenar(dato);
				System.out.println("PRODUCTOR " + id + "almacena: " + dato);
			}
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			
		} finally {
			almacen.terminarProductor();
		}
	}
}

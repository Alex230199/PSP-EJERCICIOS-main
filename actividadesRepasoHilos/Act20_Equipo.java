package actividadesRepasoHilos;

public class Act20_Equipo extends Thread {

	private Act20_BaulCantidades cosas;
	private String nombre;
	
	public Act20_Equipo (String nombre, Act20_BaulCantidades cosas) {
		
		this.cosas = cosas;
		this.nombre = nombre;
		
	}
	
	@Override
	public void run() {
		
		int grabacionesRealizadas = 0;
		
		while (grabacionesRealizadas < 3) {
			
			if (Thread.currentThread().isInterrupted()) {
				break;
			}
			
			boolean estaReservado = false;
			
			try {
				cosas.reservar();
				estaReservado = true;
				
				Thread.sleep(800);
				
				grabacionesRealizadas ++;
				
			} catch (InterruptedException e) {
				System.out.println(nombre +  " Fue parado");
				
				Thread.currentThread().interrupt();
				
				break;
			} finally {
				
				if (estaReservado) {
					
					cosas.devolver();
				}
			}
		}
	}
	
}

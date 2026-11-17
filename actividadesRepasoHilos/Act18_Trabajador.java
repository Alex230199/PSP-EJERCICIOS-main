package actividadesRepasoHilos;

public class Act18_Trabajador implements Runnable {

	private int id;
	private Act18_Barrera barrera;
	
	public Act18_Trabajador (int id, Act18_Barrera barrera) {
		
		this.id = id;
		this.barrera = barrera;
		
	}
	
	@Override
	public void run() {
		
		try {
			for (int i = 1; i <= 3;i++) {
				
				if (barrera.estaCancelada()) {
					break;
				}
				
				System.out.println("El trabajador " + id + ": inicio base " + i);
				
				Thread.sleep(200);
				
				System.out.println("Trabajador " + id + ": Fin fase" + i);
				
				boolean exito = barrera.esperar();
				if (!exito) {
					break;
				}
			}
		} catch (InterruptedException e) {
			barrera.cancelar();
			Thread.currentThread().interrupt();
		}
	}
}

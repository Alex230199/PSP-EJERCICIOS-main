package actividadesRepasoHilos;

public class Act19_Trabajador implements Runnable {

	private Act19_Pool servicio;
	
	private int completadas = 0;
	private int canceladasEnCurso = 0;
	
	public Act19_Trabajador (Act19_Pool servicio) {
		
		this.servicio = servicio;
		
	}
	
	@Override 
	
	public void run() {
		
		try {
			
			while (true) {
				Act19_Tarea t = servicio.extraer();
				
				if (t == null) {
					break;
				}
				
				try {
					
					Thread.sleep(30);
					completadas++;
				} catch (InterruptedException e) {
					canceladasEnCurso++;
					Thread.currentThread().interrupt();
					break;
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public int getCompletadas() {
		return completadas;
	}
	
	public int getCanceladasEnCurso() {
		return canceladasEnCurso;
	}
}

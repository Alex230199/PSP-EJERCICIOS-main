package actividadesRepasoHilos;

public class Act14_Trabajador implements Runnable {

	private Act14_Cola cola;
	
	private int[] completados = new int[5];
	private int totalCompletados = 0;
	private int cancelado = -1;
	private boolean hayCancelado = false;
	
	public Act14_Trabajador (Act14_Cola cola) {
		this.cola = cola;
	}
	
	@Override
	public void run() {
		
		try {
			while (true) {
				int encargo = cola.extraer();
				
				try {
					Thread.sleep(300);
					completados[totalCompletados] = encargo;
					totalCompletados++;
					
				} catch (InterruptedException e) {
					cancelado = encargo;
					this.hayCancelado = true;
					Thread.currentThread().interrupt();
					break;
					
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public int[] getCompletados() {
		
		int[] resultado = new int[totalCompletados];
		for (int i = 0; i <totalCompletados; i++) {
			resultado[i] = completados[i];
			
		}
		
		return resultado;
				
	}
	
	public boolean tieneCancelado() {
		return hayCancelado;
		
	}
	
	public int getCancelado() {
		return cancelado;
	}
}

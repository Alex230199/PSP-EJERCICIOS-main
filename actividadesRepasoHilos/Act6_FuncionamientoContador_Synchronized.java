package actividadesRepasoHilos;

public class Act6_FuncionamientoContador_Synchronized implements Runnable {
	
	private Act6_Contador_Synchronized contador;
	
	public Act6_FuncionamientoContador_Synchronized (Act6_Contador_Synchronized contador) {
		
		this.contador = contador;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 100000; i++) {
			
			contador.incrementar();
		}
	}
}

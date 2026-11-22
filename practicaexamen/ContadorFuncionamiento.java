package practicaexamen;

public class ContadorFuncionamiento implements Runnable {
	
	private Contador contador;
	
	public ContadorFuncionamiento (Contador contador) {
		
		this.contador = contador;
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 100000; i++) {
			contador.incrementar();
		}
	}

	
}

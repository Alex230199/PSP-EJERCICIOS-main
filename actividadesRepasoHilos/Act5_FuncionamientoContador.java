package actividadesRepasoHilos;

public class Act5_FuncionamientoContador implements Runnable{

	private Act5_Contador contador;
	
	public Act5_FuncionamientoContador(Act5_Contador contador) {
		
		this.contador = contador;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 100000; i++) {
			
			contador.incrementar();
		}
	}
}

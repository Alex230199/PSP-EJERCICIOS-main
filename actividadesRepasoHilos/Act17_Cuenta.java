package actividadesRepasoHilos;

public class Act17_Cuenta {
 
	private int id;
	private int saldo;
	
	
	public Act17_Cuenta (int id, int saldoInicial) {
		
		this.id = id;
		this.saldo = saldoInicial;
	}
	
	public int getId() {
		return id;
		
	}
	
	public synchronized int getSaldo() {
		return saldo;
		
	}
	
	public synchronized void retirar (int cantidad) {
		saldo -= cantidad;
	}
	
	public synchronized void depositar(int cantidad) {
		saldo += cantidad;
	}
}

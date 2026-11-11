package actividadesRepasoHilos;

public class Act11_Entradas {

	private int quedanEntradas;
	private int siguienteEntrada;
	
	public Act11_Entradas(int totalEntradas) {
		this.quedanEntradas = totalEntradas;
		this.siguienteEntrada = 1;
	}
	
	public synchronized int vender() {
		
		if (quedanEntradas <= 0) {
			return -1;
		}
		
		int entradaEntregada = siguienteEntrada;
		siguienteEntrada++;
		quedanEntradas--;
		
		return entradaEntregada;
		
	}
}

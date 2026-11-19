package actividadesRepasoHilos;

public class Act11_Entradas {
	
	/*
	 Conceptos: Runnable, métodos de instancia y synchronized.
Tres vendedores, cada uno en su propio hilo, venderán veinte entradas numeradas del 1 al 20. Todos 
usarán un único objeto compartido InventarioEntradas.
1. Crea vender(): devolverá el número de una entrada disponible o -1 cuando se hayan agotado. 
Comprueba y actualiza las existencias en una sola sección sincronizada.
2. Cada vendedor llamará a vender() hasta recibir -1. Guardará los números vendidos en una lista 
propia. Si añades pausas, colócalas fuera de synchronized.
3. Después de todos los join(), main reunirá las listas y mostrará las entradas vendidas por cada hilo y el 
total.
COMPRUEBA
Con veinte entradas se venden exactamente los números del 1 al 20, sin repetidos. También deben 
terminar las pruebas con cero entradas y con una entrada. No se exige repartir las ventas por igual.
EXPLICA
¿Qué error podría ocurrir si comprobar las existencias y descontar una entrada fueran operaciones 
separadas sin protección conjunta?

	 */

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

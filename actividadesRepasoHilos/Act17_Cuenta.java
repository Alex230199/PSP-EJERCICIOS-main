package actividadesRepasoHilos;

public class Act17_Cuenta {
	
/*
 Conceptos: Varios recursos compartidos, synchronized, interrupciones y join.
Crea tres cuentas con identificadores 1, 2 y 3 y un saldo inicial de 1 000 unidades cada una. 
Tres hilos realizarán transferencias usando cantidades enteras.
1. Cada transferencia debe comprobar el saldo, descontar del origen y sumar al destino como 
una operación indivisible: los demás hilos no deben observarla a medias.
2. Protege las dos cuentas con sus monitores. Adquiérelos siempre por identificador 
creciente, aunque el dinero viaje de la cuenta 3 a la 1.
3. Cada trabajador intentará 1 000 transferencias. Usa una lista fija de operaciones o un 
generador aleatorio con semilla fija para repetir los datos de entrada. El orden de 
ejecución entre hilos sí podrá variar.
4. Rechaza, sin cambiar saldos, las transferencias con importe no positivo, saldo insuficiente u 
origen igual al destino. Registra cuáles se aceptan y cuáles se rechazan.
5. Comprueba la interrupción entre transferencias. Una transferencia iniciada debe terminar 
completa antes de salir. No hagas sleep() ni join() mientras mantengas monitores. 
Main mostrará el balance después de todos los join().
COMPRUEBA
Los saldos nunca son negativos y su suma final es 3 000. Prueba transferencias simultáneas en 
sentidos opuestos y cancelación. Un hilo esperando entrar en synchronized no abandona 
esa espera por recibir interrupt(); atenderá la petición cuando pueda avanzar.
EXPLICA
¿Cómo evita el orden de los identificadores que dos hilos se queden esperando mutuamente?
 */
 
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

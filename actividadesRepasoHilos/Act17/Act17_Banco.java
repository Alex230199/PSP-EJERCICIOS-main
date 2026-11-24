package actividadesRepasoHilos.Act17;

public class Act17_Banco {
	
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

	private int aceptadas = 0;
	private int rechazadas = 0;

	public boolean realizarTransferencia(Act17_Cuenta origen, Act17_Cuenta destino, int importe) {

		if (origen.getId() == destino.getId() || importe <= 0) {
			rechazadas++;
			return false;
		}

		Act17_Cuenta primero, segundo;
		if (origen.getId() < destino.getId()) {
			primero = origen;
			segundo = destino;
		} else {
			primero = destino;
			segundo = origen;

		}

		synchronized (primero) {
			synchronized (segundo) {
				if (origen.getSaldo() < importe) {
					rechazadas++;
					return false;
				}

				origen.retirar(importe);
				destino.depositar(importe);
				aceptadas++;
				return true;
			}
		}

	}

	public void mostrarEstadisticas() {

		System.out.println("Transferencias aceptadas " + aceptadas);
		System.out.println("Transferencias rechazadas " + rechazadas);

	}
}

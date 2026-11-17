package actividadesRepasoHilos;

public class Act17_Banco {

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

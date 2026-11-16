package actividadesRepasoHilos;

public class Act13_Arbitro extends Thread {

	private Act13_SalidaCompartida salida;

	public Act13_Arbitro(Act13_SalidaCompartida salida) {
		this.salida = salida;
	}

	@Override
	public void run() {

		try {

			for (int i = 3; i >= 1; i--) {
				System.out.println(i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		salida.darSalida();
	}
}

package montajeordenadorcorreccion;

public class TarjetaGrafica extends Thread {
	public void run() {
		for (int i = 0; i < 3; i++) {

			switch (i) {

			case 0:
				System.out.println("TG: 1");
				break;

			case 1:
				System.out.println("TG: 2");
				break;

			case 2:
				System.out.println("TG: 3");
				break;

			case 3:
				System.out.println("TG: FIN");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("He detectado un problema:");
				System.out.println("Estoy solucionando la incidencia");
				System.out.println("Ya esta. Continuo");
			}

		}
	}
}

package montajeordenadorcorreccion;

public class Almacenamiento extends Thread {

	public void run() {
		for (int i = 0; i < 3; i++) {

			switch (i) {

			case 0:
				System.out.println("Almacenamiento: colocar SD");
				break;

			case 1:
				System.out.println("Almacenamiento: colocar cable de datos");
				break;

			case 2:
				System.out.println("Almacenamiento Acabar");
				break;

			case 3:
				System.out.println("Fin");

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}
	}
}

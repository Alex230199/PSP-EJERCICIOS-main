package hilos;

public class HiloJunior extends Thread {
	String nombre;
		int pausa;
		
		HiloJunior(String nombre, int pausa) {
			this.nombre = nombre;
			this.pausa = pausa;
		}
		
		  public void run() {
			    int c = 0;
			    while (c < 1000) {
			      System.out.println("Hilo número (" + nombre + "): " + c);
			      try {
					Thread.sleep(pausa); // milisegundos
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      c++;
			    }
		  }

}

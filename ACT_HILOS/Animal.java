package ACT_HILOS;
                    //HERENCIA  HILO
public class Animal extends     Thread{

	String Nombre;
	int posicionInicial;
	int pausa;
	int paso;
	
	Animal(String Nombre, int posicionInicial, int pausa, int paso){
		
		this.Nombre = Nombre;
		this.pausa = pausa;
		this.posicionInicial = 0;
		this.paso = paso;
		
	}
	
	public void run() {
		/*
		int m = 1;
		while (m <= 10) {
			
			System.out.println("El..." + Nombre + "ha avanzado..." + m);
			
			try {
				Thread.sleep(pausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			m++;
		}
		*/
		
		while(this.posicionInicial <= 10) {
			
			System.out.println("El animal..." + this.Nombre + "está en la posicion..." + this.posicionInicial);
			
			try {
				Thread.sleep(pausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.posicionInicial = this.posicionInicial + this.paso;
		}
		System.out.println("El..." + Nombre + "...ha ganado");
		
	}
	
	
}

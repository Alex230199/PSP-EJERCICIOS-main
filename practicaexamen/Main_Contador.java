package practicaexamen;

public class Main_Contador {
	
	public static void main (String [] args) throws InterruptedException {

	Contador contadorUnico = new Contador();
	
	Runnable tarea1 = new ContadorFuncionamiento(contadorUnico);
	Runnable tarea2 = new ContadorFuncionamiento(contadorUnico);
	Runnable tarea3 = new ContadorFuncionamiento(contadorUnico);
	Runnable tarea4 = new ContadorFuncionamiento(contadorUnico);
	
	Thread h1 = new Thread(tarea1);
	Thread h2 = new Thread(tarea2);
	Thread h3 = new Thread(tarea3);
	Thread h4 = new Thread(tarea4);
	
	h1.start();
	h2.start();
	h3.start();
	h4.start();
	
	h1.join();
	h2.join();
	h3.join();
	h4.join();
	
	System.out.println("el valor total final es: " + contadorUnico.getValor());
	
	
	}
	
}

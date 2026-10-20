package bocadillo;

public class Main {

	public static void main (String [] args) {
		Maquinabocadillo maquina = new Maquinabocadillo();
		
		Thread hiloCocinero = new Thread (new Cocinero(maquina));
		Thread hiloCliente = new Thread (new Cliente(maquina));
		
		hiloCocinero.start();
		hiloCliente.start();
	}
}

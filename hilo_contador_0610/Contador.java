package hilo_contador_0610;

public class Contador implements Runnable {

	int valor;
	int aumento;
	
	Contador (int valor, int aumento){
		
		this.valor = valor;
		this.aumento = aumento;
		
	}
	
	@Override
	public void run () {
		
		while (true) {
			
			  this.valor += this.aumento;
            try {
            

                System.out.println("Contador suma: "  + this.aumento + " .Valor actual: " + this.valor);                
            
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
             
                System.out.println(" Interrupción recibida en contador con aumento " + this.aumento);
                
                
                if (this.valor > 50) {
                    System.out.println(">>> El valor es " + this.valor + " (mayor que 50). Reiniciando a 0.");
                    this.valor = 0;
                } else {
                    System.out.println(">>> El valor es " + this.valor + " (50 o menor). Continuando normalmente...\n");
                }
                
                
            }
        }
    }
}

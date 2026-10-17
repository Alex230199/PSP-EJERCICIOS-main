package cajaregistradora;

public class Caja {
	
	
private double total = 0;
    

    public synchronized void cobrar(double cantidad) {
        
        total = total + cantidad;
        
    }
    
    public double getTotal() {
        
        return total;
        
    }
		
	}
}

package cajaregistradora;

public class Empleado {
	public class Empleado implements Runnable {
	    
	    Caja caja;
	    String nombre;
	    
	    public Empleado(Caja c, String n) {
	        
	        caja = c;
	        nombre = n;
	        
	    }
	    
	    @Override
	    public void run() {
	        
	       
	        double[] ventas = {10.0, 20.0, 30.0};
	        
	        for (int i = 0; i < ventas.length; i++) {
	            
	            double importe = ventas[i];
	            
	            caja.cobrar(importe);
	            
	            System.out.println("Empleado " + nombre + " cobro " + importe + " euros.");
	            
	            try {
	                
	                Thread.sleep(1000);
	                
	            } catch (InterruptedException e) {
	                
	                e.printStackTrace();
	                
	            }
	            
	        }
	        
	    }
}

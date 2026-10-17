package cajaregistradora;

public class Main {
	
public static void main(String[] args) {
        
        Caja miCaja = new Caja();
        
        Empleado emp1 = new Empleado(miCaja, "Hermingo");
        Empleado emp2 = new Empleado(miCaja, "Fulgencio");
        
        Thread hilo1 = new Thread(emp1);
        Thread hilo2 = new Thread(emp2);
        
        hilo1.start();
        hilo2.start();
        
        try {
            
            hilo1.join();
            hilo2.join();
            
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        }
        
        System.out.println("----------------------------------");
        System.out.println("El total final en la caja es: " + miCaja.getTotal());
        
    }
}

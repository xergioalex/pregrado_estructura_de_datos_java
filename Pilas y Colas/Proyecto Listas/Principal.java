
/**
 * Es la clase que contiene al programa principal e implementa el uso de la clase CabezaLista
 */
import java.util.Random;
public class Principal
{




public static void main(String[] args)
   {
     Lista lst  = new Lista (0,null,null);
     Cola p = new Cola(lst);
      
     Objeto x = new Objeto();
     x.cambiarId(1);
     x.cambiarNombre("Luis");  
     p.agregarCola(x);

     
     
     x = new Objeto();
     x.cambiarId(2);
     x.cambiarNombre("Maria");   
     p.agregarCola(x);

     
     x = new Objeto();
     x.cambiarId(3);
     x.cambiarNombre("Jaime");   
     p.agregarCola(x);

     
     x = new Objeto();
     x.cambiarId(7);
     x.cambiarNombre("Alejandro"); 
     p.agregarCola(x);
     

     x = new Objeto();
     x.cambiarId(9);
     x.cambiarNombre("Marcela"); 
     p.agregarCola(x);
     
    } 

   
}


 /**
 * Describe la clase para representar una pila
 */
public class Pila
{
   private Lista pila; 
    
public  Pila()
    {
    }
    
// Para crear una pila se debe llamar al método con los parámetros (0, null, null)

public  Pila (Lista l)
    {
        pila = l;
    }

    
public Lista listaPila()
{
   return pila;
}    
 

public int longitudPila()
   {
       return pila.longitudLista();
   }

   
public boolean esVaciaPila ()
   {
       if (longitudPila() == 0)
          return true;
       return false;
    }


public Objeto top()
   {
       if (esVaciaPila())  throw new StackException("La Pila está vacía");
       pila.primeroLista();
       return pila.datoVentana();   
    }  
    
    
public void push (Objeto x)
    {
       pila.cambiarVentana(0);
       pila.insertarLista(x);
    }
    
       
public void pop ()
   {   Objeto x;
       if (esVaciaPila())  throw new StackException("Pilas que la pila no puede ser vacia.");
       pila.cambiarVentana(0);
       pila.eliminarLista();
    }
   
}

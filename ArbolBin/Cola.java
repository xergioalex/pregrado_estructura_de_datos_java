
/**
 * Clase de objetos para manejo de colas
 */
public class Cola
{
    Lista cola; 
    
public  Cola()
{
}
    
// Para crear una cola se debe llamar al m�todo con los par�metros (0, null, null)

public  Cola (Lista l)
    {
        cola = l;
    }


public int longitudCola()
   {
       return cola.longitudLista();
   }

   
public boolean esVaciaCola ()
   {
       if (longitudCola() == 0)
          return true;
       return false;
    }


public NodoArbolBin cabezaCola()
   {
       if (esVaciaCola())  throw new StackException("La Cola est� vac�a");
          cola.primeroLista();
       return cola.datoVentana();   
    }  
    
    
public void agregarCola (NodoArbolBin x)
    {
       cola.ultimoLista();
       cola.anexarLista(x);
    }
    
       
 public void sacarCola ()
   {  
       if (esVaciaCola())  throw new StackException("Cola est� vac�a.");
       cola.primeroLista();
       cola.eliminarLista();
    }
   

 public Lista listaCola()
 {
    return cola;
  }

   
}

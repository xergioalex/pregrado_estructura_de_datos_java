
/**
 *Clase que representa cada nodo de la lista de datos.
 */
public class NodoArco
{
   
    private ObjetoArco info;
    private NodoArco siguiente;
    
 public  NodoArco()
    {
    }
    
 public  NodoArco (ObjetoArco d, NodoArco k)
    {
        info = d;
        siguiente = k;
    }
    
 public ObjetoArco infoNodo()
 {
     return info;
    }

 public NodoArco siguienteNodo()
 {
     return siguiente;
    }
    
 public void cambiarInfo(ObjetoArco x)
 {
     info = x;
    }
  
    
 public void cambiarSiguiente(NodoArco p)
 {
     siguiente = p;
    }
      
}

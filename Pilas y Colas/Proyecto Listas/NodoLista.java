
/**
 *Clase que representa cada nodo de la lista de datos.
 */
public class NodoLista
{
   
    private Objeto info;
    private NodoLista siguiente;
    
 public  NodoLista()
    {
    }
    
 public  NodoLista (Objeto d, NodoLista k)
    {
        info = d;
        siguiente = k;
    }
    
 public Objeto infoNodo()
 {
     return info;
    }

 public NodoLista siguienteNodo()
 {
     return siguiente;
    }
    
 public void cambiarInfo(Objeto x)
 {
     info = x;
    }
  
    
 public void cambiarSiguiente(NodoLista p)
 {
     siguiente = p;
    }
      
}


/**
 *Clase que representa cada nodo de la lista de datos.
 */
public class NodoLista
{
   
    private NodoArbolBin info;
    private NodoLista siguiente;
    
 public  NodoLista()
    {
    }
    
 public  NodoLista (NodoArbolBin d, NodoLista k)
    {
        info = d;
        siguiente = k;
    }
    
 public NodoArbolBin infoNodo()
 {
     return info;
    }

 public NodoLista siguienteNodo()
 {
     return siguiente;
    }
    
 public void cambiarInfo(NodoArbolBin x)
 {
     info = x;
    }
  
    
 public void cambiarSiguiente(NodoLista p)
 {
     siguiente = p;
    }
      
}


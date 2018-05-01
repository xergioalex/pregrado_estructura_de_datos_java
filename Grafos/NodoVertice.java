
/**
 *Clase que representa cada nodo de la lista de datos.
 */
public class NodoVertice
{
   
    private ObjetoVertice info;
    private NodoVertice siguiente;
    
 public  NodoVertice()
    {
    }
    
 public  NodoVertice (ObjetoVertice d, NodoVertice k)
    {
        info = d;
        siguiente = k;
    }
    
 public ObjetoVertice infoNodo()
 {
     return info;
    }

 public NodoVertice siguienteNodo()
 {
     return siguiente;
    }
    
 public void cambiarInfo(ObjetoVertice x)
 {
     info = x;
    }
  
    
 public void cambiarSiguiente(NodoVertice p)
 {
     siguiente = p;
    }
      
}

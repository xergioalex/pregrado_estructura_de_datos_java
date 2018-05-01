/**
 * Describe el nodo que se usa como cabeza de la lista
 */
public class Lista
{
    private int longitud;
    private NodoLista primero;
    private NodoLista ventana;
    
public  Lista()
    {
    }
    
public  Lista (int a, NodoLista p, NodoLista v)
    {
        longitud = a;
        primero = p;
        ventana = v;
    }
    
public int longitudLista()
{
   return longitud;
}


public NodoLista apprimeroLista()
{
   return primero;
}

public NodoLista ventanaLista()
{
   return ventana;
}


void cambiarLongitud(int q)
{
    longitud = q;
}

void cambiarPrimero(NodoLista p)
{
    primero = p;
}

void cambiarVentana(NodoLista v)
{
    ventana = v;
}



//  1. La funcion crearLista desaparece pues es el mismo metodo  creado con new Lista()
 
public boolean vaciaLista()
//  2. devuelve verdadero si la lista es vacía y falso sino
{
    if (primero == null)
       return true;
    return false;
}


public void anexarLista (NodoArbolBin x)
// 4. Anexa un objeto en un nodo despues de donde apunta ventana
//    Si la lista es vacia queda como unico nodo de la lista
{
      NodoLista p = new NodoLista(x, null);

      if (vaciaLista())
          primero = p;
      else
        {
            p.cambiarSiguiente(ventana.siguienteNodo());  
            ventana.cambiarSiguiente(p);
        }
      ventana = p;
      longitud++;
    }
    

public NodoArbolBin datoVentana()
// 5. Retorna el objeto que hay en el nodo donde apunta la ventana.
// Precondicion: la lista NO puede estar vacia
  {
    return ventana.infoNodo();
  }

  

public void cambiarVentana (int k)
// 7. Cambia la posicion de la ventana a un nuevo valor K. La nueva posicion
// debe corresponder a un valor válido de acuerdo a la cantidad de datos existentes.
// el primer dato de la lista esta en la posicion dada por k = 0

{     NodoLista p = primero;
      if ((k >= 0) && (k < longitud))
        {
         for (int i=0; i<k; i++)
            p = p.siguienteNodo();
         ventana = p;
         }
}
 


public void insertarLista (NodoArbolBin x)
//  8. Agrega un dato en la lista antes de la ventana.
// Si la lista es vacia, se agrega el dato en la primera
//  posicion y la ventana queda referenciando esa posicion.
{
      NodoLista k;
      NodoLista p = new NodoLista(x, null);
    
      if (vaciaLista())
          primero = p;
      else
         { 
             if (ventana == primero)
                {
                    p.cambiarSiguiente(ventana);
                    primero = p;
                }
             else
                {
                    k=primero;
                    while (k.siguienteNodo() != ventana)
                       k = k.siguienteNodo();
                    p.cambiarSiguiente(ventana);
                    k.cambiarSiguiente(p);
                 }
          }
      ventana = p;
      longitud++;
 }


public void eliminarLista ()
// 10. Se elimina el objeto de la lista apuntado por la ventana, si la lista no es vacia.
//     La ventana queda apuntando al primero de la lista si existe.
{  
     NodoLista k;
     if (longitud > 0)
      {
        if (ventana == primero)
               primero = ventana.siguienteNodo();
         else
           {
              k=primero;
              while (k.siguienteNodo() != ventana)
                  k = k.siguienteNodo();
              k.cambiarSiguiente(ventana.siguienteNodo());
           }
          ventana = primero;
          longitud--;
        }
      else
         System.out.println("El Objeto NO existe");
}
 

public void siguienteLista ()
// 9. Pone la ventana a apuntar a la siguiente posicion
{
    if ((!vaciaLista ()) && (ventana.siguienteNodo() != null))
           ventana = ventana.siguienteNodo();

}


 public void primeroLista ()
// 7. Pone la ventana a apuntar a la primera posicion
{
    ventana = primero;
}



   public void ultimoLista ()
// 8. Pone la ventana a apuntar a la ultima posicion
{
    primeroLista();
    if (!vaciaLista ())
       while (ventana.siguienteNodo() != null)
           ventana = ventana.siguienteNodo();
}


 
 public void mostrarLista()
 {
     ventana = primero;
     while (ventana != null)
        {
            ventana.infoNodo().infoNodo().mostrarDatos();
            ventana = ventana.siguienteNodo();
    }
}
}
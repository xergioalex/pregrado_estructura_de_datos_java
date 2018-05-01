/**
 * Describe el nodo que se usa como cabeza de la lista
 */
public class ListaArco
{
    private int longitud;
    private  NodoArco primero;
    private  NodoArco ventana;
    
public  ListaArco()
    {
    }
    
public  ListaArco (int a,  NodoArco p,  NodoArco v)
    {
        longitud = a;
        primero = p;
        ventana = v;
    }
    
public int longitudLista()
{
   return longitud;
}


public  NodoArco apprimeroLista()
{
   return primero;
}

public  NodoArco ventanaLista()
{
   return ventana;
}


void cambiarLongitud(int q)
{
    longitud = q;
}

void cambiarPrimero( NodoArco p)
{
    primero = p;
}

void cambiarVentana( NodoArco v)
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


public void anexarLista (ObjetoArco  x)
// 4. Anexa un objeto en un nodo despues de donde apunta ventana
//    Si la lista es vacia queda como unico nodo de la lista
{
       NodoArco p = new NodoArco(x, null);

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
    

public ObjetoArco  datoVentana()
// 5. Retorna el objeto que hay en el nodo donde apunta la ventana.
// Precondicion: la lista NO puede estar vacia
  {
    return ventana.infoNodo();
  }


  
public int existeDato (ObjetoArco  x)
// 6. Indica si un dato existe o no en la lista. Retorna la posicion si existe (el primer elemento es 0)
// o -1 sino existe.
{
     NodoArco p = primero;
    for (int i = 0; i < longitud; i++)
      {
        if (p.infoNodo().compararObjeto (x))
            return i;
        p = p.siguienteNodo();
        }
    return -1;
}
  

public void cambiarVentana (int k)
// 7. Cambia la posicion de la ventana a un nuevo valor K. La nueva posicion
// debe corresponder a un valor válido de acuerdo a la cantidad de datos existentes.
// el primer dato de la lista esta en la posicion dada por k = 0

{      NodoArco p = primero;
      if ((k >= 0) && (k < longitud))
        {
         for (int i=0; i<k; i++)
            p = p.siguienteNodo();
         ventana = p;
         }
}
 


public void insertarLista (ObjetoArco  x)
//  8. Agrega un dato en la lista antes de la ventana.
// Si la lista es vacia, se agrega el dato en la primera
//  posicion y la ventana queda referenciando esa posicion.
{
       NodoArco k;
       NodoArco p = new NodoArco (x, null);
    
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

 
 
public void modificarDato (ObjetoArco  x)
// 9. Modifica el valor de la posicion referenciada en la ventana por el nuevo objeto.
{
      if (!vaciaLista())
         ventana.cambiarInfo( x);
      else
         System.out.println("\n error: LA LISTA ESTA VACIA");
}




public void eliminarLista ()
// 10. Se elimina el objeto de la lista apuntado por la ventana, si la lista no es vacia.
//     La ventana queda apuntando al primero de la lista si existe.
{  
      NodoArco k;
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




    
    public void listar()
// Esta funcion muestra los datos de los objetos.
 {    NodoArco p = primero;
     for (int i = 0; i<longitud; i++)
        {
            p.infoNodo().mostrarDatos();
            p = p.siguienteNodo();
        }
    }


  public void antLista ()
// 10. Pone la ventana en la poscion anterior si no es vacia o no esta de primera
   {   
     NodoArco p=primero;
    
    if ((!vaciaLista ()) && (ventana != primero))
      {
        while (p.siguienteNodo() != ventana)
           p=p.siguienteNodo();
        ventana = p;
      }
   }
   
   
   public void mostrarLista()
 {
     ventana = primero;
     while (ventana != null)
        {
            ventana.infoNodo().mostrarDatos();
            ventana = ventana.siguienteNodo();
    }
}

}
 

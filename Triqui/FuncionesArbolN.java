
/**
 * Funciones para el manejo de Arboles n-arios.
 */
public class FuncionesArbolN
{

    // Indica si un arbol es o no vacia
    public boolean esVacioArbolN (ArbolN a)
    {
      if (a == null)
         return true;
      return false;
    }

    
  // Busca un objeto que tenga oid == k. Devuelve un apuntador a ese objeto 
  // si lo encuentra o null sino.
   public ArbolN encontrarArbolN (ArbolN a, int k)
  {
   if (esVacioArbolN (a))
      return null;
   if (a.raizArbolN().oidObjeto() == k)
      return a;
   ArbolN p = encontrarArbolN (a.hijoArbolN(), k);
   if (esVacioArbolN (p))
      p = encontrarArbolN (a.hermanoArbolN(), k);
   return  p;
  }

  
  // crea un nodo raiz con el nuevo objeto y cuelga el arbol existente como
  // hijo.
   public ArbolN insertarRaiz (ArbolN a, Objeto x)
  {  
     ArbolN z = new ArbolN (x, a, null, null);
     if (!esVacioArbolN(a))
        a.cambiarPadre(z);
     return z;
  }


  
  
  // Inserta un nodo como ultimo hijo del arbolN a, siempre y cuando 
  // este arbol no sea vacio
public void insertarHijo (ArbolN a, int p, Objeto x)
{
   ArbolN q = encontrarArbolN (a, p);
   if (!esVacioArbolN(q))
      {
          ArbolN k;
           ArbolN n = new ArbolN (x, null, null, q);
           if (q.hijoArbolN() == null)
              q.cambiarHijo(n);
           else
              {
                 k=q.hijoArbolN();
                 while (k.hermanoArbolN() != null)
                   k = k.hermanoArbolN();
                 k.cambiarHermano(n);                 
              }
      }

}

  // Hace un recorrido en preorden mostrando los nodos del arbol y su padre.
  public void preorden (ArbolN a)
  {
    if (!esVacioArbolN(a))
       {
           a.raizArbolN().mostrarObjeto();                      
           preorden(a.hijoArbolN());
           preorden(a.hermanoArbolN());
           
        }
  }    
 
  
//  6.	Calcular la altura de un arbol n-ario.
public int alturaArbolN (ArbolN a)
{
   int k = 0;
   ArbolN x;
   if (a == null)
      return 0;
   x=a.hijoArbolN();
   while (!esVacioArbolN(x))
     {
        if (alturaArbolN(x) > k)
           k = alturaArbolN(x);
        x = x.hermanoArbolN();
     }
   return (k+1);
} 

//8.	Calcular el nivel de un elemento en un arbol n-ario.
public int nivelArbolN(ArbolN a)
{
    int n = 0;
    ArbolN aux = a;
    while (aux.padreArbolN()!=null)
    {
        aux=aux.padreArbolN();
        n++;
    }
    
    return n;    
}

// Calcula el numero de hojas de un arbol n-ario
public int numHojas (ArbolN a)
{
    if (esVacioArbolN (a))
       return 0;
    if (a.hijoArbolN() == null)
       return 1+numHojas(a.hermanoArbolN());
    return numHojas(a.hijoArbolN()) + numHojas(a.hermanoArbolN());
}

        
    
}



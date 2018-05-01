
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
           System.out.print("\n Nodo ");
           a.raizArbolN().mostrarObjeto();
           if (!esVacioArbolN(a.padreArbolN()))
              {   System.out.print(" Padre: ");
                  a.padreArbolN().raizArbolN().mostrarObjeto();
                }

           preorden(a.hijoArbolN());
           preorden(a.hermanoArbolN());
        }
  }    
  


//1.    Calcular el peso de un arbol n-ario.
public int pesoArbolN(ArbolN a)  
{   
    ArbolN x;
    int k=0;
    if (a==null)
        return 0;
    x=a.hijoArbolN();
    while(!esVacioArbolN(x))
        {
            k= k + pesoArbolN(x);
            x=x.hermanoArbolN();
        }
    return (k+1);
}

// 2.   Contar cuantas hojas tiene un arbol n-ario.
public int numHojas (ArbolN a)
{
    if (esVacioArbolN (a))
       return 0;
    if (a.hijoArbolN() == null)
       return 1+numHojas(a.hermanoArbolN());
    return numHojas(a.hijoArbolN()) + numHojas(a.hermanoArbolN());
}

//3.    Indicar con una función boolean, si dos arboles n-arios son iguales.
public boolean igualesArbonN(ArbolN a, ArbolN b)
{
    if (a==null&&b==null)
        return true;
    if (!a.raizArbolN().compararObjeto(b.raizArbolN()))
        return false;
    return ( igualesArbonN(a.hermanoArbolN(),b.hermanoArbolN()) &&  igualesArbonN(a.hijoArbolN(),b.hijoArbolN()));             
}

//4.    Indicar con una función boolean, si dos arboles n-arios son isomorfos.
public boolean isomorfosArbonN(ArbolN a, ArbolN b)
{
    if (a==null&&b==null)
        return true;
    if ((a==null&&b!=null)||(a!=null&&b==null))
        return false;
    return ( isomorfosArbonN(a.hermanoArbolN(),b.hermanoArbolN()) &&  isomorfosArbonN(a.hijoArbolN(),b.hijoArbolN()) );             
}

//5.    Un arbol de valores enteros es estable, si para todo elemento su padre es mayor. 
//Hacer una función que reciba un arbol n-ario de enteros e indique si es estable.
public boolean estableArbonN(ArbolN a)
{
    if (a==null)
        return true;
    if (a.padreArbolN()!=null && a.raizArbolN().oidObjeto()>= a.padreArbolN().raizArbolN().oidObjeto())
        return false;
    if (a.hijoArbolN()==null&&a.hermanoArbolN()==null)
        return true;
    return estableArbonN(a.hijoArbolN())&&estableArbonN(a.hermanoArbolN());             
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

//9.	Retornar el ancestro común más proximo de dos elementos en un arbol n-ario.
public ArbolN ancestroComunArbolN(ArbolN a, ArbolN b)
{   
    if(a.padreArbolN()==null||b.padreArbolN()==null)
        return null;
    ArbolN auxA,auxB;
    int na = nivelArbolN(a);
    int nb = nivelArbolN(b);
    System.out.println("1 na: "+na+"  nb: "+nb);
    auxA=a;
    auxB=b;
    if (na>nb)
    {
        while(na>nb)
        {
            auxA=auxA.padreArbolN();
            na--;
        }
    }
    if (nb>na)
    {
        while(nb>na)
        {
            auxB=auxB.padreArbolN();
            nb--;
        }
    }
    System.out.println("2 na: "+na+"  nb: "+nb);
    while (auxA!=auxB)
    {
        auxA=auxA.padreArbolN();
        auxB=auxB.padreArbolN();
    }
    return auxA;
}
        
    
}



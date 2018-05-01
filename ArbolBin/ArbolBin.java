

public class ArbolBin
{   private NodoArbolBin raiz;
    private NodoArbolBin ventana;

    public ArbolBin()
    {
    }

    
    public ArbolBin(NodoArbolBin r, NodoArbolBin v)
    {
        raiz = r;
        ventana = v;
    }
    
    
    public NodoArbolBin raizArbolBin()
      {
          return raiz;
       }
       

    public NodoArbolBin ventanaArbolBin()
      {
          return ventana;
       }
       
       
    public void cambiarRaiz (NodoArbolBin r)
    {
        raiz = r;
    }
    
    public void cambiarVentana (NodoArbolBin v)
    {
        ventana = v;
    }
    
      
    
  public boolean esVacioArbolBin ()
       // Devuelve verdadero si el arbol es vacio
    {
      if (raiz == null)
         return true;
      return false;
    }

  
   public Objeto datoVentana() 
   // Devuelve el objeto apuntado por la ventana.
   // Pre: el arbol no puede estar vacio.
     {
         if (ventana == null)  throw new ArbolBinException(" ERROR. El arbol es vacio ");
         else
           return ventana.infoNodo();
     }
   
   
     
   public NodoArbolBin buscarObjeto (NodoArbolBin p, Objeto x)  
   // busca el objeto x dentro del arbol a partir de la direccion de nodo p,
   // si lo encuentra retorna la direccion del objeto sino retorna null.
     {
         NodoArbolBin r;

         if ((p == null) || (p.infoNodo().compararObjeto(x)))
          {
            if (p != null)
              cambiarVentana(p);
            return p;
          }
         r = buscarObjeto (p.hijoIzqNodo(), x);
         if (r == null)
             r = buscarObjeto (p.hijoDerNodo(), x);
         return  r;
     }
   
   
   public NodoArbolBin existeObjeto (Objeto x)
  // Encuentra un objeto si existe en el arbol (en ese caso devuelve la direccion y 
  // asigna la ventana a esa direccion), de lo contrario retorna null
  // apuntando a ese objeto
    {  NodoArbolBin k = buscarObjeto(raiz,x);
       if (k != null)
          ventana = k;
       return k;
    }
      
      

   public void insertarRaizIzq (Objeto x)
 // Crea un nodo con el objeto x como raiz del arbol y cuelga por la izquierda el
 // arbol que habia.
   
   {  
     NodoArbolBin z = new NodoArbolBin (x, null, null);
     z.cambiarHijoIzq(raiz);
     raiz = z;
     ventana = raiz;
  }


  public void insertarRaizDer (Objeto x)
 // Crea un nodo con el objeto x como raiz del arbol y cuelga por la derecha el
 // arbol que habia.
{  
     NodoArbolBin z = new NodoArbolBin (x, null, null);
     z.cambiarHijoDer(raiz);
     raiz = z;
     ventana = raiz;
}



public void insertarHijoIzq (Objeto x)
  // Inserta un nodo como hijo izquierdo del objeto apuntado por la ventana.
  // la ventana queda apuntando al nuevo nodo
  // Pre: el objeto apuntado por la ventana no tiene el hijo izquierdo previamente.
{
   
   if ((!esVacioArbolBin()) && (ventana.hijoIzqNodo() == null))
      {
           NodoArbolBin n = new NodoArbolBin (x, null, null);
           ventana.cambiarHijoIzq(n);
           ventana = n;
      }
   else  throw new ArbolBinException("ERROR: imposible agregar hijo por la izquierda");
}


  // este arbol no sea vacio y no tenga el hijo derecho.
public void insertarHijoDer (Objeto x)
  // Inserta un nodo como hijo derecho del objeto apuntado por la ventana.
  // la ventana queda apuntando al nuevo nodo
  // Pre: el objeto apuntado por la ventana no tiene el hijo derecho previamente.
{
   if ((!esVacioArbolBin()) && (ventana.hijoDerNodo() == null))
      {
           NodoArbolBin n = new NodoArbolBin (x, null, null);
           ventana.cambiarHijoDer(n);
           ventana = n;
      }
   else  throw new ArbolBinException("ERROR: imposible agregar hijo por la derecha");
}
  


  public void removerHoja()
   // Elimina el nodo apuntado por la ventana.
   // Pre: Este nodo es hoja del arbol, es decir no tiene hijos.
   // Deja la ventana apuntando a la raiz o a null si el arbol queda vacio
  {
      NodoArbolBin p;
      if ((ventana != null) && (ventana.hijoIzqNodo() == null) && 
          (ventana.hijoDerNodo() == null))
          {
              if (ventana == raiz)
                 raiz = null;
              else
                {
                    p = padreArbolBin(ventana, raiz);
                    if (p.hijoIzqNodo() == ventana)
                       p.cambiarHijoIzq(null);
                    else
                       p.cambiarHijoDer(null);
                }
              ventana = raiz;
          }
      else  throw new ArbolBinException("ERROR: imposible remover nodo");
  }

  
  public void recorridoPreorden (NodoArbolBin a)
   { 
       if ( a != null)
       {
           a.infoNodo().mostrarDatos();
           recorridoPreorden(a.hijoIzqNodo());
           recorridoPreorden(a.hijoDerNodo());
           
      
           
        }
    }
    
    
  public void preorden (){
  // Hace un recorrido en preorden mostrando los nodos del arbol
       if (raiz == null)
          System.out.println("El arbol esta vacio");
       else
          recorridoPreorden(raiz);
  }
   
  
  
   public boolean esCompletoArbolBin()
   {   
       return esCompleto(this.raiz);
    }
       
   
   public boolean esCompleto(NodoArbolBin p)
   {
       if(p==null||p.esHoja())
          return true;
       if ((p.hijoIzqNodo()!=null && p.hijoDerNodo()==null)  || (p.hijoDerNodo()!=null && p.hijoIzqNodo()==null))
          return false;
       return esCompleto(p.hijoIzqNodo()) && esCompleto(p.hijoDerNodo());
    }

   
   public  int max (int a, int b)
   {
      if (a > b)
          return a;
      return b;
    }

 //2.   Calcular el peso de un arbol binario.  
   public int pesoArbol (NodoArbolBin p)
   {
       if (p == null)
         return 0;
       return (1 +  pesoArbol(p.hijoIzqNodo()) + pesoArbol(p.hijoDerNodo()));
    }

    public int pesoArbolBin()
   // devuelve el numero de nodos de un arbol binario
   {  
       return pesoArbol (raiz);
    }
       
   //3. Calcular la altura de un arbol binario.
   public int alturaArbol (NodoArbolBin p)
   {
       if (p == null)
         return 0;
       return (1 +  max(alturaArbol(p.hijoIzqNodo()), alturaArbol(p.hijoDerNodo())));
    }

    public int alturaArbolBin()
   // devuelve la altura de un arbol binario
   {  
       return alturaArbol (raiz);
    }    
    
    //4.    Contar cuantas hojas tiene un arbol binario.       
   public int hojasArbol (NodoArbolBin p)
   {
       if ((p.hijoIzqNodo() == null) && (p.hijoDerNodo() == null))
         return 1;
       return (hojasArbol(p.hijoIzqNodo()) + hojasArbol(p.hijoDerNodo()));
    }

    public int hojasArbolBin()
   // devuelve el numero de hojas de un arbol binario
    {  
       if (esVacioArbolBin())
          return 0;
       return hojasArbol (raiz);
    }
       
    
    //5.    Hacer una función que devuelva el padre de un elemento dado en el árbol.
  public NodoArbolBin padreArbolBin (NodoArbolBin v, NodoArbolBin p)
   // Pre: v no corresponde a la raiz.
   // retorna la direccion del nodo padre de v.
   {
         NodoArbolBin r;

         if ((p == null) || (p.hijoIzqNodo() == v) || (p.hijoDerNodo() == v))
            return p;
         r = padreArbolBin (v, p.hijoIzqNodo());
         if (r == null)
             r = padreArbolBin (v, p.hijoDerNodo());
         return  r;

    }
    //funcion auxiliar. Sube un nivel dentro del arbol
    public void subirNivel()
    {
        if(ventana!=raiz)
            ventana=this.padreArbolBin(ventana,raiz);
            
        }
        
        
    
    //8.    Indicar con una función boolean si dos árboles binarios son semejantes (tienen los mismos elementos aunque no tengan la misma forma)
    public boolean semejantes(NodoArbolBin x)
    {
        if(x==null)
            return true;
        if( this.existeObjeto(x.infoNodo())==null)
            return false;
        if(x.hijoIzqNodo()==null && x.hijoDerNodo()==null)
            return true;
        else
            return semejantes(x.hijoIzqNodo())&&semejantes(x.hijoDerNodo());
        }
        
     public boolean semejanteA(ArbolBin x)
     {
         if (this.pesoArbolBin()==x.pesoArbolBin())
            return semejantes(x.raiz);
         else
            return false;
        }
            
    /*------------------------------------------------------------------------------------------------*/            
    
    //11.   Hacer una función que indique cuantos elementos tiene un arbol binario en un nivel dado.
    public int nodosNivelArbolBin(NodoArbolBin v, int n)
    {
        if (n==0&&v!=null)
            return 1;
        if (v==null)
            return 0;
        else
            return (nodosNivelArbolBin(v.hijoIzqNodo(), n-1)) + (nodosNivelArbolBin(v.hijoDerNodo(), n-1));
        }
        
    public int nodosNivel(int n)
    {
        return nodosNivelArbolBin(raiz,n);
    }
        
    
        /*------------------------------------------------------------------------------------------------*/
     //Ejercicio 12: Recorrer un Arbol Por Niveles  
  public void porNiveles()
  // Hace un recorrido por niveles mostrando los nodos del arbol
  {
      Lista l = new Lista();
      Cola c = new Cola(l);
       
      if(raiz != null){
           c.agregarCola(this.raiz);
           recorridoPorNiveles (c);
      }
      else System.out.println("El arbol esta Vacio");
  }
    public void recorridoPorNiveles (Cola c)
   { 
       
       
       if (!c.esVaciaCola())
       {
           c.cabezaCola().infoNodo().mostrarDatos();
           if(c.cabezaCola().hijoIzqNodo() != null){
              c.agregarCola(c.cabezaCola().hijoIzqNodo());
           }
           if(c.cabezaCola().hijoDerNodo() != null){
              c.agregarCola(c.cabezaCola().hijoDerNodo());
           }
           c.sacarCola();
           recorridoPorNiveles (c);

        }
        
  }
  
  
  
    
    /*------------------------------------------------------------------------------------------------*/
    //14.   Hacer una función que reciba dos elementos e indique si son primos (sus padres son hermanos).
    //Pre: ambos nodos deben pertenecer al arbol del cual son llamados.
    public boolean Primos(NodoArbolBin a,NodoArbolBin b)
    {
    
        if ((padreArbolBin(a,raiz)!=padreArbolBin(b,raiz))&& padreArbolBin(padreArbolBin(a,raiz),raiz)==padreArbolBin(padreArbolBin(b,raiz),raiz))
            return true;
        else 
            return false;
        }

 /*------------------------------------------------------------------------------------------------*/
  //Ejercicio 15: Decir si un Arbol es Estable
  public boolean esEstable(){
        return arbolEstable(this.raiz);
    
  }
  
  public boolean arbolEstable(NodoArbolBin p){
       if( p == null)
          return true;
       if( (p.hijoIzqNodo() == null) && (p.hijoDerNodo() == null))
          return true;
       if(  (p.hijoIzqNodo() != null) && (p.hijoIzqNodo().infoNodo().idObjeto() > p.infoNodo().idObjeto()) || (p.hijoDerNodo() != null) && (p.hijoDerNodo().infoNodo().idObjeto() > p.infoNodo().idObjeto())   )
          return false;
       return arbolEstable(p.hijoIzqNodo()) && arbolEstable(p.hijoDerNodo());
  }
  

  
       
    /*------------------------------------------------------------------------------------------------*/    
    //17.   Hacer una función que retorne una lista con los elementos que forman un camino desde la raíz hasta un elemento dado.
    public Lista caminoRaizNodo(NodoArbolBin n)
    {
        Lista lst = new Lista(0,null,null);
        Pila p = new Pila(lst);
        ventana=n;
        while(ventana!=raiz)
        {
            p.push(ventana);
            this.subirNivel();
        }
        p.push(ventana);
        return p.listaPila();
    }
    
        
  /*------------------------------------------------------------------------------------------------*/
    //Ejercicio 24: Eliminar Hojas
  public void eliminarHojasArbol(){
        eliminarHojas(this.raiz);   
  }    
  
  public void eliminarHojas(NodoArbolBin p){
       if ( p != null)
       {
           if (p.esHoja()){
               ventana = p;
               removerHoja();
           }
              
           
           eliminarHojas(p.hijoIzqNodo());
           eliminarHojas(p.hijoDerNodo());

       }           
  }
  
    
   /*------------------------------------------------------------------------------------------------*/
  
    // 26.  Haga una función boolean que indique si un árbol binario está ordenado.
    public boolean Ordenado (NodoArbolBin n)
    {
        if (n==null||(n.hijoDerNodo()==null&&n.hijoIzqNodo()==null))
            return true;
        if ( (n.hijoIzqNodo()!=null)&&(elementoDer(n.hijoIzqNodo()).idObjeto()>n.infoNodo().idObjeto()) ||
             (n.hijoDerNodo()!=null)&&(elementoIzq(n.hijoDerNodo()).idObjeto()>n.infoNodo().idObjeto()) ) 
             return false;
        else 
            return Ordenado (n.hijoDerNodo())&&Ordenado(n.hijoIzqNodo());
    }
    

    public Objeto elementoDer(NodoArbolBin p)
    {
        return ((p.hijoDerNodo()==null)?p.infoNodo():elementoDer(p.hijoDerNodo()));
    }
    
    public Objeto elementoIzq(NodoArbolBin p)
    {
         return ((p.hijoIzqNodo()==null)?p.infoNodo():elementoIzq(p.hijoIzqNodo()));
    }      
  
  
  /*------------------------------------------------------------------------------------------------*/  
  //Ejercicio 27: Metodo de insercion para arboles ordenados
  public void insercionArbolBin(Objeto p){
       ventana = raiz;
       if( raiz == null)
          insertarRaizIzq(p);
       else{
           while(!ventana.esHoja()){
                if(p.idObjeto() > ventana.infoNodo().idObjeto())
                    ventana = ventana.hijoDerNodo();
                else 
                    ventana = ventana.hijoIzqNodo();
          }
          if(p.idObjeto() > ventana.infoNodo().idObjeto())
              insertarHijoDer(p);
          else
              insertarHijoIzq(p);
       }
  }
  
  public void insercion(NodoArbolBin a,Objeto p){
      if(!a.esHoja()){
          if(p.idObjeto() > a.infoNodo().idObjeto()){
             a = a.hijoDerNodo();
          }
          else{ 
              insercion(a.hijoIzqNodo(),p);
              ventana = a;
          }
      }

      
  }
  
  
    /*------------------------------------------------------------------------------------------------*/
    /*------------------------------------------------------------------------------------------------*/
    //Arboles Binarios Ordenados y Balanceados 
    //29.   Hacer una función que reciba un árbol binario e indique si es AVL (si esta balanceado en altura).
    public boolean balenceadoAlturaArbolBin()
    {
        return balanceadoAltura(raiz);
    }
    
    public boolean balanceadoAltura(NodoArbolBin n)
    {   
        if (n==null||n.esHoja())
            return true;
        n.infoNodo().mostrarDatos();
        if (!diferenciaDeUno( alturaArbol(n.hijoIzqNodo()),alturaArbol(n.hijoDerNodo()) ) )
            return false;
        return (balanceadoAltura(n.hijoIzqNodo())&&balanceadoAltura(n.hijoDerNodo()));
    }
            
   public boolean diferenciaDeUno(int a, int b)
   {
       System.out.println(a+" y "+b);
       if ((a-b)==1||(a-b)==0||(b-a)==1)
        return true;
       return false;
    } 
  
  
  
   }
    
        
        
        
            
        

   


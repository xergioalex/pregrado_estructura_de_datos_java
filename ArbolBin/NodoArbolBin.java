

public class NodoArbolBin
{

 private Objeto info;
 private NodoArbolBin hijoIzq, hijoDer;
 
 public  NodoArbolBin()
    {
    }
    
 public  NodoArbolBin (Objeto x, NodoArbolBin i, NodoArbolBin d)
    {
       info = x;
       hijoIzq = i;
       hijoDer = d;
    }
    
    
 public Objeto infoNodo()
 {
     return info;
    }
    
    
 public NodoArbolBin hijoIzqNodo()
   {
     return hijoIzq;
    }


    public NodoArbolBin hijoDerNodo()
    {
     return hijoDer;
 }


 public void cambiarInfo(Objeto k)
 {
   info = k;
 }

 public void cambiarHijoIzq(NodoArbolBin i)
 {
   hijoIzq = i;
 }


 public void cambiarHijoDer(NodoArbolBin d)
 {
   hijoDer = d;
 }

    public boolean esHoja(){
       if(hijoIzq == null && hijoDer == null)
          return true;
       return false;
   }




}








/**
 *Clase para manejo de arboles n-arios
 */
public class ArbolN
{
    private Objeto raiz;
    private ArbolN hijo, hermano, padre;
    
 public  ArbolN()
    {
    }
    
 public  ArbolN (Objeto r, ArbolN h, ArbolN s, ArbolN p)
    {
        raiz = r;
        hijo = h;
        hermano = s;
        padre = p;
    }
    

    
public Objeto raizArbolN()
{
    return raiz;
}

public void modificarRaiz(Objeto x)
{
   raiz = x;
}

public ArbolN hijoArbolN()
{
   return hijo;
}

public void cambiarHijo(ArbolN a)
{
   hijo = a;
}


public ArbolN hermanoArbolN()
{
   return hermano;
}

public void cambiarHermano(ArbolN a)
{
   hermano = a;
}



public ArbolN padreArbolN()
{
   return padre;
}

public void cambiarPadre(ArbolN a)
{
   padre = a;
}



}

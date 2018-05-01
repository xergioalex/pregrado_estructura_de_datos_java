
/**
 * Contiene el tipo de datos Objeto que se va a manejar en la lista
 */
public class ObjetoArco
{
    private int origen;
    private int destino;
    private int costo;
    
    
 public  ObjetoArco()
    {
    }
    
 public  ObjetoArco (int or, int des, int c)
    {
       origen = or;
       destino = des;
       costo = c;
    }
    
    
 public int costoArco()
 {
     return costo;
    }
    
public int origen()
{   
    return origen;
}

public int destino()
{   
    return destino;
}

public void cambiarOrigen(int or)
{   
    origen = or;
}

public void cambiarDestino(int dest){
    this.destino=dest;
}


     

public void cambiarCosto(int c)
{
   costo = c;
}


public boolean compararObjeto (ObjetoArco x)
{
   if ((origen == x.origen) && (destino == x.destino))
      return true;
   return false;
}

    
 public void mostrarDatos()
 {
     System.out.println ("\n origen     = "+origen);
     System.out.println (" destino = "+destino);
     System.out.println (" Costo = "+costo);
    }
    
}

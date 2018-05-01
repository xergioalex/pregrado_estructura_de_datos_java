
/**
 * Contiene el tipo de datos Objeto que se va a manejar en la lista
 */
public class ObjetoVertice
{
    private int id;  
    private boolean marca;
    
 public  ObjetoVertice()
    {
    }
    
 public  ObjetoVertice (int x)
    {
       id = x;
    }        
    
    
 public int idObjeto()
 {
     return id;
    }
 public boolean marcaObjeto()
 {
     return marca;
    }
   

public void cambiarId(int k)
{
   id = k;
}

public void cambiarMarca(boolean b)
{
    marca=b;
}
    

public boolean compararObjeto (ObjetoVertice x)
{
   if (id == x.id)
      return true;
   return false;
}

    
 public void mostrarDatos()
 {
     System.out.println ("\n id     = "+id);
     System.out.println ("Marca     = "+marca);
     
    }
    
}

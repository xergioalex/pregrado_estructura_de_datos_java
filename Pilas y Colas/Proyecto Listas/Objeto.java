
/**
 * Contiene el tipo de datos Objeto que se va a manejar en la lista
 */
public class Objeto
{
    private int id;
    private String nombre;
    
    
 public  Objeto()
    {
    }
    
 public  Objeto (int x, String s)
    {
       id = x;
       nombre = s;
    }
    
    
 public int idObjeto()
 {
     return id;
    }
    
    
 public String nombreObjeto()
 {
     return nombre;
    }

public void cambiarId(int k)
{
   id = k;
}


public boolean compararObjeto (Objeto x)
{
   if ((id == x.id) && (nombre == x.nombre))
      return true;
   return false;
}


public void cambiarNombre(String s)
{
   nombre = s;
}
    
 public void mostrarDatos()
 {
     System.out.println ("\n id     = "+id);
     System.out.println (" nombre = "+nombre);
    }
    
}

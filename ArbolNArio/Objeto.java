
/**
 *Objeto que se maneja en el arbol n-ario.
 */
import java.io.*;
public class Objeto
{
    private int oid;
    private String nombre;
    
    
 public  Objeto()
    {
    }
    
 public  Objeto (int d, String o)
    {
       oid = d;
       nombre = o;
    }
    
 public int oidObjeto()
 {
     return oid;
    }
    
 public String nombreObjeto()
 {
     return nombre;
    }
    
    
 public void modificarOid (int d)
    {
       oid = d;
    }
    
 public void modificarNombre (String o)
    {
       nombre = o;
    }
    

public void mostrarObjeto ()
   {
       System.out.println ("\n oid = "+oid+"     nombre = "+nombre);
    }


public boolean compararObjeto (Objeto x)
{
   if ((oid == x.oid) && (nombre == x.nombre))
      return true;
   return false;
}



// Guarda en un archivo los datos del objeto.
public void salvarObjeto (RandomAccessFile archivo) throws IOException 
   {
         archivo.writeUTF( nombre );       // Se guarda la cadena al archivo 
         archivo.writeInt( oid );             // Se guarda el entero 
   }
    
// Carga de un archivo el siguiente objeto.
public void recuperarObjeto (RandomAccessFile archivo) throws IOException 
   {
         nombre = archivo.readUTF();       // Se guarda la cadena al archivo 
         oid = archivo.readInt();             // Se guarda el entero 
   }
    
    
}
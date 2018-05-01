
/**
 *Objeto que se maneja en el arbol binario
 */
import java.io.*;
public class Objeto
{
    private int id;
    private String nombre;
    private String car;

 public  Objeto()
    {
    }

 public  Objeto (int x, String s)
    {
       id = x;
       nombre = s;
    }

 public void cambiarCar(String c){
     this.car = c;
  }

  public String carObjeto(){
     return car;
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



public void cambiarNombre(String s)
{
   nombre = s;
}


public boolean compararObjeto (Objeto x)
{
   if ((id == x.id) && (nombre == x.nombre))
      return true;
   return false;
}



public void mostrarDatos()
 {
     //System.out.println ("\nid     = "+id);
     //System.out.println ("nombre = "+nombre);
     System.out.println ("car    = "+car);
    }

// Guarda en un archivo los datos del objeto.
public void salvarObjeto (RandomAccessFile archivo) throws IOException
   {
         archivo.writeUTF( nombre );       // Se guarda la cadena al archivo
         archivo.writeInt( id );             // Se guarda el entero
   }

// Carga de un archivo el siguiente objeto.
public void recuperarObjeto (RandomAccessFile archivo) throws IOException
   {
         nombre = archivo.readUTF();       // Se guarda la cadena al archivo
         id = archivo.readInt();             // Se guarda el entero
   }

}

/**
 *Objeto que se maneja en el arbol binario
 */
import java.io.*;
public class Objeto
{
    private int matriz[][]= new int[3][3];;
    private int oid;
    
 public  Objeto()
    {
        
    }
    
 public  Objeto (int m[][], int id)
    {
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                matriz[i][j]=m[i][j];
            }
        }
        oid=id;
    }
    
 public int oidObjeto()
 {
     return oid;
    }       
    
 public void modificarOid (int d)
    {
       oid = d;
    }
    
    
 public void cambiarMatriz(int m[][]){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                matriz[i][j]=m[i][j];
            }
        }
  }     
    
 public int[][] matrizObjeto()
 {
     return matriz;
    }   

       public void mostrarObjeto()
   {   
       System.out.println("\nId: "+oid);
       System.out.print("   0  1  2");
       for(int i=0;i<3;i++)
        {
            System.out.print("\n"+i+" ");
            for (int j=0;j<3;j++)
            {                
                if(matriz[i][j]==0)
                    System.out.print("| |");
                if(matriz[i][j]==1)
                    System.out.print("|X|");    
                if(matriz[i][j]==2)
                    System.out.print("|O|");    
            }
        }
        System.out.println();
       
    }
    
    
}
import java.util.Scanner;
/**
 *Contiene las funciones que usan la clase ArbolBin
 */
public class Principal
{   
   
   public static void main( String[] args )
   {
       int [][] t = new int[3][3];
       
       FuncionesArbolN f = new FuncionesArbolN();
       inicializarMatriz(t);       
       imprimirMatriz(t);
       ingresarJugada(t);
       imprimirMatriz(t);
       //primera jugada usuario
       if(t[1][1]==0)
          t[1][1]=1;
       else t[0][0]=1;
       imprimirMatriz(t);
       ingresarJugada(t);
       imprimirMatriz(t);
       Objeto x = new Objeto(t,1);       
       ArbolN a= new ArbolN (x,null,null,null);
       llenarArbol(0,1,1,t,a);                       
       minMax(1,a);            
       //f.preorden(a);
       while(!triqui(t)&&!empate(t))
       {
           a=mejorHijo(a);
           copiarMatriz(a.raizArbolN().matrizObjeto(),t);
           imprimirMatriz(t);
           if(!triqui(t)&&!empate(t)){
           ingresarJugada(t);
           a=hijoEscogido(a,t);
           copiarMatriz(a.raizArbolN().matrizObjeto(),t);
           imprimirMatriz(t);}
        }
        
        if(triqui(t))
            System.out.println("PERDISTE!");
        else
            System.out.println("Empate!");

       
       //System.out.println("altura: "+f.alturaArbolN(a)+"\nhojas: "+f.numHojas(a));
 
   }
   
   //Inicializa la matriz t llenando las 9 posiciones de ceros.
   public static void inicializarMatriz(int t[][])   
   {
        for(int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                t[i][j]=0;
            }
        }
    }
   
   //Imprime la matriz de 3x3 que se le envia como parametro
   public static void imprimirMatriz(int t[][])
   {   
       System.out.print("   0  1  2");
       for(int i=0;i<3;i++)
        {
            System.out.print("\n"+i+" ");
            for (int j=0;j<3;j++)
            {                
                if(t[i][j]==0)
                    System.out.print("| |");
                if(t[i][j]==1)
                    System.out.print("|X|");    
                if(t[i][j]==2)
                    System.out.print("|O|");    
            }
        }
        System.out.println();
       
    }
    
    //copia toda la matriz ma a la matriz t
    public static void copiarMatriz(int ma[][],int t[][])
    {
        for(int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                t[i][j]=ma[i][j];
            }
        }        
        
    }
    
   //esta funcion pide una jugada al usuario y la inserta en la matriz del triqui si es posible, sino puede jugar allí vuelve a pedir los datos
   public static void ingresarJugada(int t[][])
   {
       Scanner entrada = new Scanner(System.in);
       int f,c,band=0;
       
       while(band==0)
       {
            System.out.println("Ingrese la fila en la cual desea jugar");
            f=entrada.nextInt();
            System.out.println("Ingrese la columna en la cual desea jugar");
            c=entrada.nextInt();
            if(t[f][c]==0||f>2||f<0||c>2||c<0)
                {   t[f][c]=2;
                    band=1;}
            else System.out.println("La casilla ya esta ocupada o es incorrecta, intente de nuevo");        
        }
    }
  
  //esta funcion indica si en la matriz t hay un triqui  
  public static boolean triqui(int t[][])
  {
    if((t[0][0]!=0&&t[0][0]==t[0][1]&&t[0][0]==t[0][2])||(t[1][0]!=0&&t[1][0]==t[1][1]&&t[1][0]==t[1][2])||(t[2][0]!=0&&t[2][0]==t[2][1]&&t[2][0]==t[2][2])
     ||(t[0][0]!=0&&t[0][0]==t[1][0]&&t[0][0]==t[2][0])||(t[0][1]!=0&&t[0][1]==t[1][1]&&t[0][1]==t[2][1])||(t[0][2]!=0&&t[0][2]==t[1][2]&&t[0][2]==t[2][2])
     ||(t[0][0]!=0&&t[0][0]==t[1][1]&&t[0][0]==t[2][2])||(t[0][2]!=0&&t[0][2]==t[1][1]&&t[0][2]==t[2][0]) )
     return true;
     else return false;
    }
  
  //indica si en la matriz t hay un empate (todas las casillas estan ocupadas y no hay triqui)  
  public static boolean empate(int t[][])
  {
      if(triqui(t))
        return false;
      for (int i=0;i<3;i++)
      {
          for (int j=0;j<3;j++)
          {
              if (t[i][j]==0)
                return false;
            }
        }        
        return true;         
    }
    
  //de acuerdo a la posicion i y j, la funcion retorna un numero del 0 al  8
  public static int posIJ(int i,int j)
  {
      if(i==0)
      {
          if(j==0) return 0;
          if(j==1) return 1;
          if(j==2) return 2;
        }
      if(i==1)
      {
          if(j==0) return 3;
          if(j==1) return 4;
          if(j==2) return 5;
        }
      if(i==2)
      {
          if(j==0) return 6;
          if(j==1) return 7;
          if(j==2) return 8;
        }  
     return 9;   
    }
  
  //esta funcion llena el arbolN a con todas las posibles jugadas y si hay triqui o empate asigna el valor correspondiente (0,9,-9)
  public static void llenarArbol(int padre, int hijoN, int turno, int t[][], ArbolN a)
  {
      FuncionesArbolN f = new FuncionesArbolN();
      int nuevoId = padre*10+hijoN;
      boolean band=false;
      Objeto x= new Objeto(t,nuevoId);            
      
      if(triqui(t))
        {
            band=true;            
            if(turno==1)
                x.modificarOid(-9);
            else  
                x.modificarOid(9);            
        }  
      else if(empate(t))
        {
            x.modificarOid(0);
            band=true;
        }  
            
      f.insertarHijo(a,padre,x);     
      
      if(!band)
      {
        for(int i=0;i<3;i++)
        {
          for (int j=0; j<3;j++)
              {
                  if (t[i][j]==0)
                  {
                      t[i][j]=turno;
                      if(turno==1)//cambio de turno
                        turno=2;
                      else turno=1;            
                      llenarArbol(nuevoId, posIJ(i,j), turno,t,a);  
                      t[i][j]=0;//la dejo vacia de nuevo
                      if(turno==1)//devuelvo de turno
                        turno=2;
                      else turno=1;  
                    }
                  
                }            
            }
        }        
    } 
  
    //esta funcion se encarga de que todos los valores de los objetos sean 0,9 o -9. para esto recorre hasta las hojas del arbolN y dependiendo del turno
    //correspondiente al nivel retorna el mejor o el peor valor posible;
    public static int minMax(int turno,ArbolN a)
    {
        int valor = a.raizArbolN().oidObjeto();        
        
        if(valor==0||valor==9||valor==-9)
            return valor;
        else
        {
            int m=0,aux=0;
            ArbolN b= a.hijoArbolN();
            while(b!=null)
            {            
                if(turno==1)//cambio de turno
                    turno=2;
                else turno=1;                 
                
                aux = minMax(turno, b);
                
                if(turno==1)//devuelvo el turno
                    turno=2;
                else turno=1;  
                
                if(turno==1){//si es turno del computador tomo la mejor
                    if(aux>m)
                        m=aux;
                    }
                if(turno==2){//si no tomo la peor
                    if(aux<m)
                        m=aux;
                    }    
                b=b.hermanoArbolN();
            }
            a.raizArbolN().modificarOid(m);
            return m;                      
        }
    }
    
    //retorna el hijo de a con valor mas alto
    public static ArbolN mejorHijo(ArbolN a)
    {
        ArbolN q= a.hijoArbolN();
        int x=0 ;
        while(q!=null)
        {
            x=q.raizArbolN().oidObjeto();
            if(x==9)
                return q;
            q=q.hermanoArbolN();    
            }
        q= a.hijoArbolN();   
        while(q!=null)
        {
            x=q.raizArbolN().oidObjeto();
            if(x==0)
                return q;
            q=q.hermanoArbolN();
        }
        return a.hijoArbolN();
    }
    
    //dada una matriz que contiene la siguiente jugada a lo que hay en la raiz de a, retorna cual de los hijos del arbol tiene la jugada escogida por el jugador
    public static ArbolN hijoEscogido(ArbolN a, int t[][])
    {
        ArbolN q=a.hijoArbolN();
        while(q!=null)
        {
            if (matricesIguales(q.raizArbolN().matrizObjeto(),t))
                return q;
            q=q.hermanoArbolN();
        }
        System.out.println("no encontro hijo escogido");
        return a.hijoArbolN();
        
    }
    
    //retorna verdadero si dos matrices son iguales
    public static boolean matricesIguales(int m[][],int t[][])
    {
        for (int i=0;i<3;i++)
      {
          for (int j=0;j<3;j++)
          {
              if (m[i][j]!=t[i][j])
                return false;
            }
        }        
        return true;         
    }
        
            
}

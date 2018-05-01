
/**
 *Contiene las funciones que usan la clase ArbolBin
 */
public class Principal
{


    public static void main(String[] args)
    {
       //NodoArbolBin b = new NodoArbolBin (null,null,null);
       ArbolBin a = new ArbolBin (null, null);
       ArbolBin b = new ArbolBin (null, null);
       a = arbolSintaxis("/*58-82");     
       
       System.out.println("ARBOL SINTAXIS");
       System.out.println("PREORDEN");
       sintaxisPreorden(a);
       System.out.println("Inorden con parentesis");
       sintaxisInorden(a);
       System.out.println("ALTURA");
       System.out.println(a.alturaArbolBin());
       System.out.println("Resultado: "+ resolverArbol(a));
       System.out.println();
       
       
       
       
       
       b = arbolSintaxisParentesis("(/(*52)(-83))");
       
       System.out.println("ARBOL SINTAXIS PARENTESIS");
       System.out.println("PREORDEN");
       sintaxisPreorden(b);
       System.out.println("Inorden con parentesis");
       sintaxisInorden(b);
       System.out.println("ALTURA");
       System.out.println(b.alturaArbolBin());
       System.out.println("Resultado: "+ resolverArbol(b));
       
       
       /* PRUEBA PARA SABER SI UN ARBOL ES COMPLETO
       ArbolBin a = new ArbolBin (null, null);
       NodoArbolBin b = new NodoArbolBin (null,null,null);
       Objeto x = new Objeto();     
       Objeto y = new Objeto();
 
       
       x.cambiarId(25);
       x.cambiarNombre("Jaime");
       a.insertarRaizIzq(x);
       
       x = new Objeto();
       x.cambiarId(17);
       x.cambiarNombre("Maria");
       a.insertarHijoDer(x);
       
       a.subirNivel();
       a.subirNivel();           
       
       x = new Objeto();
       x.cambiarId(12);
       x.cambiarNombre("Sofia");
       a.insertarHijoIzq(x);
  
       x = new Objeto();
       x.cambiarId(32);
       x.cambiarNombre("Marta");
       a.insertarRaizDer(x);

       x = new Objeto();
       x.cambiarId(11);
       x.cambiarNombre("Ramiro");
       a.insertarHijoIzq (x);
       
       x = new Objeto();
       x.cambiarId(7);
       x.cambiarNombre("Valeria");
       a.insertarHijoIzq(x);         
       
       a.subirNivel();
       
       x = new Objeto();
       x.cambiarId(14);
       x.cambiarNombre("Daniela");
       a.insertarHijoDer (x);

       System.out.println ("El arbol queda asi: ");
       a.porNiveles();
       
       if(a.esCompletoArbolBin())
           System.out.println("Arbol Completo");
       else System.out.println("Arbol Incompleto");
       */
      
       /* PRUEBA PARA BALANCEO POR ALTURA
       ArbolBin a = new ArbolBin (null, null);
       NodoArbolBin b = new NodoArbolBin (null,null,null);
       Objeto x = new Objeto();     
       Objeto y = new Objeto();
 
       
       x.cambiarId(25);
       x.cambiarNombre("Jaime");
       a.insertarRaizIzq(x);
       
       x = new Objeto();
       x.cambiarId(30);
       x.cambiarNombre("Maria");
       a.insertarHijoDer(x);

       y = new Objeto();
       y.cambiarId(28);
       y.cambiarNombre("Daniela");
       a.insertarHijoIzq(y);
       
       a.subirNivel();
       a.subirNivel();           
       
       x = new Objeto();
       x.cambiarId(20);
       x.cambiarNombre("Sofia");
       a.insertarHijoIzq(x);
  
       x = new Objeto();
       x.cambiarId(12);
       x.cambiarNombre("Marta");
       a.insertarRaizDer(x);

       x = new Objeto();
       x.cambiarId(11);
       x.cambiarNombre("Ramiro");
       a.insertarHijoIzq (x);
       
       x = new Objeto();
       x.cambiarId(7);
       x.cambiarNombre("Valeria");
       a.insertarHijoIzq(x);     
       
       x = new Objeto();
       x.cambiarId(8);
       x.cambiarNombre("Aleja");
       a.insertarHijoDer(x);                


       
       System.out.println ("El arbol queda asi: ");
       a.preorden();
       
       if(a.balenceadoAlturaArbolBin())
        System.out.println ("El arbol esta balanceado por altura");
       else
        System.out.println ("El arbol NO esta balanceado por altura");       
       */

       
      
   }

 //EJERCICIOS TALLER
   
   
       static int maximoPesoArbolBin(int n)
       {
           int peso=0;
           for (int i=0;i<n;i++)
           {
               peso=peso+exp(2,i);
            }
            return peso;           
        }  
       
        static int minimoPesoArbolBin(int n)
        {
            return 2*n-1;
        }
       
        static int exp(int b,int e)
        {
            if (e==0)
            return 1;
            if (e==1)
            return b;
            return b*exp(b,e-1);
        }
        
        static double expdouble(double b,double e)
        {
            if (e==0)
            return 1;
            if (e==1)
            return b;
            return b*expdouble(b,e-1);
        }
       
        //b) N?mero m?nimo de niveles en un ?rbol de peso P.
        static int alturaMinimaPeso(int p)
        {
            int aux=p;
            int i=0;
            while(aux>0)
            {
                i++;
                aux=p;
                aux= aux- maximoPesoArbolBin(i);               
            }
            return i;
        }
       
        //c) N?mero maximo de hojas en un ?rbol con N nivelesc) N?mero m?ximo de hojas en un ?rbol con N niveles
        static int maximoHojasAltura(int a)
        {
            return exp(2,a-1);
        } 
        
         /*-----------------------------------------------------------------------------------------------*/
        
        //EJERCICIO 6: DECIR SI DOS ARBOLES BINARIOS SON IGUALES
        static boolean comparacionPreorden (NodoArbolBin a, NodoArbolBin b)
        { 

              if(a== null && b == null)
                 return true;
              else if(a== null || b == null)
                 return false;
              else if(a.infoNodo().compararObjeto(b.infoNodo())){
                 return comparacionPreorden(a.hijoIzqNodo(),b.hijoIzqNodo()) && comparacionPreorden(a.hijoDerNodo(),b.hijoDerNodo());
              }
              else return false;
        }
    
        /*-----------------------------------------------------------------------------------------------*/
        
        static boolean compararArboles(ArbolBin a, ArbolBin b)
        // Hace un recorrido en preorden mostrando los nodos del arbol
        {
            if(a.alturaArbolBin() == b.alturaArbolBin() && a.pesoArbolBin() == b.pesoArbolBin() && a.raizArbolBin().infoNodo().compararObjeto(b.raizArbolBin().infoNodo())){
                return comparacionPreorden(a.raizArbolBin(),b.raizArbolBin());
            }
            return false;
            
        }
        
        //EJERCICIO 9: DECIR SI DOS ARBOLES BINARIOS SON IGUALES
        static boolean arbolLleno(ArbolBin a){
            if(a.pesoArbolBin() == maximoPesoArbolBin(a.alturaArbolBin()))
                return true;
            return false;
            
        }
        
        /*-----------------------------------------------------------------------------------------------*/
        
        static  int max (int a, int b)
        {
          if (a > b)
             return a;
          return b;
        }
        
        static int alturaNodo (NodoArbolBin p)
        {
           if (p == null)
              return 0;
           return (1 +  max(alturaNodo(p.hijoIzqNodo()), alturaNodo(p.hijoDerNodo())));
        }
        
        static int pesoNodo (NodoArbolBin p)
        {
           if (p == null)
              return 0;
           return (1 +  pesoNodo(p.hijoIzqNodo()) + pesoNodo(p.hijoDerNodo()));
        }

        
        static boolean compararNodoArbol(NodoArbolBin p1,NodoArbolBin p2){
            
            if(p1 == null && p2 == null)
               return true;
            if((alturaNodo(p1) < alturaNodo(p2)) )
               return false;
            if( pesoNodo(p1) < pesoNodo(p2) )   
               return false;   
            if(comparacionPreorden(p1,p2) )
                return true;
            else return compararNodoArbol(p1.hijoIzqNodo(),p2) || compararNodoArbol(p1.hijoDerNodo(),p2)  ;

        }
        
        
        //Ejercicio 18: Decir si un arbol es subarbol de otro
        static boolean esSubArbol(ArbolBin a1,ArbolBin a2){
            if( a2.raizArbolBin() == null)
               return false;
            return compararNodoArbol(a1.raizArbolBin() , a2.raizArbolBin());
        }
        
         /*-----------------------------------------------------------------------------------------------*/
        
        static NodoArbolBin mayorElementoNodo(NodoArbolBin a,NodoArbolBin b){
             if(a.infoNodo().idObjeto() > b.infoNodo().idObjeto() )
                return a;
             return b;
        }
        
        static NodoArbolBin mayorNodo(NodoArbolBin p, NodoArbolBin mayor){
            if ( p == null)
               return mayor;
            if(p.hijoIzqNodo() != null)
                mayor = mayorElementoNodo(p.hijoIzqNodo(),mayor);
            if (p.hijoDerNodo() != null)
                mayor = mayorElementoNodo(p.hijoDerNodo(),mayor);
            return mayorElementoNodo(mayorNodo(p.hijoIzqNodo(),mayor),mayorNodo(p.hijoDerNodo(),mayor));
        }
  
         //Ejercicio 21: Mayor Elemento Arbol
         static NodoArbolBin mayorNodoArbol(ArbolBin a){
              NodoArbolBin p = new NodoArbolBin();
              p = a.raizArbolBin();
              return mayorNodo(a.raizArbolBin(),p);
          }
          
        /*------------------------------------------------------------------------------------------------*/
        
        static boolean comprobarExp(String s)
        {
            int bandera = 0;
            int n,o;
            String[] expresion = {"^","+","-","*","/","0","1","2","3","4","5","6","7","8","9"};
            if(s.substring(0,1).equals("/") ||  s.substring(0,1).equals("*") ||  s.substring(0,1).equals("+") ||  s.substring(0,1).equals("-") ||  s.substring(0,1).equals("^") ){
               for (int i = 1; i<s.length(); i++){
                  for (int j = 0; j< expresion.length; j++){  
                      if(s.substring(i,i+1).equals(expresion[j])) 
                        bandera = 1;
                  }
                  if (bandera == 0)
                     return false;
                  else 
                     bandera = 0;
               }
               return true;
            }
            return false;
        
        }
             
        
        static boolean esNumero(String car){
            String[] numero = {"0","1","2","3","4","5","6","7","8","9"};
            for (int i = 0; i< numero.length; i++){
                if (car.equals(numero[i]))
                   return true;            
            }
            return false;
        }
        
         
        //ARBOLES DE SINTAXIS
        //33.Hacer una función que reciba una cadena de caracteres con una expresion en preorden donde cada operando es un número de una cifra y los operadores son +, -, * y /.       
        //35.   Hacer el ejercicio 34 pero incluyendo el operador exponente ‘^’ de tal manera que se pueda escribir un polinomio donde la base es un número de una cifra.
        static ArbolBin  arbolSintaxis (String s)
        {
           ArbolBin a= new ArbolBin(null, null); 
           if (!comprobarExp(s)){
                System.out.println("No sea Bruto");
                return a;
           }       
           NodoArbolBin n = new NodoArbolBin (null,null,null);
           Objeto x = new Objeto();
           
           x.cambiarCar(s.substring(0,1));
           a.insertarRaizIzq(x);
           
           for (int i = 1; i<s.length(); i++)
           {
               x = new Objeto();
               x.cambiarCar(s.substring(i,i+1));
               if(!esNumero(s.substring(i-1,i) ))                   
                    a.insertarHijoIzq(x);
               else{
                   
                   do{
                       a.subirNivel();
                       if(a.ventanaArbolBin().hijoDerNodo()==null)
                          a.insertarHijoDer(x);
                       if(a.ventanaArbolBin() == a.raizArbolBin()   && a.ventanaArbolBin().hijoDerNodo() != null){
                          System.out.println("La expresion no es Correcta hay elementos de mas");
                          a= new ArbolBin(null, null); 
                          return a;
                       } 
                    }while(a.ventanaArbolBin().hijoDerNodo() != null);
                }
            }
            if (!a.esCompletoArbolBin()){
               a= new ArbolBin(null, null); 
               System.out.println("La expresion no es Correcta, arbol Incompleto");
            }
            
            return a; 
        }

        
        static boolean comprobarExpParentesis(String s)
        {
            int bandera = 0;
            int n,o,pa=1,pc=0;
            String[] expresion = {"(",")","^","+","-","*","/","0","1","2","3","4","5","6","7","8","9"};
            if(s.substring(0,1).equals("(")){
               for (int i = 1; i<s.length(); i++){
                  for (int j = 0; j< expresion.length; j++){  
                      if(s.substring(i,i+1).equals(expresion[j])) 
                        bandera = 1;

                  }
                  //cuento parentesis abiertos y parentesis cerrados  
                  if(s.substring(i,i+1).equals("("))
                  pa++;
                  if(s.substring(i,i+1).equals(")"))
                  pc++;  
                  
                  if (bandera == 0)
                     return false;
                  else 
                     bandera = 0;
               }
               if(pa==pc)
                return true;
            }
            return false;
        
        }   
         //34.  Hacer una función que reciba una expresión binaria bien construida en preorden con paréntisis y devuelva el árbol de sintaxis correspondiente.
         //36.  Hacer el mismo ejercicio 35 incluyendo el operador exponente ‘^’.
        static ArbolBin  arbolSintaxisParentesis (String s)
        {
           ArbolBin a= new ArbolBin(null, null); 
           if (!comprobarExpParentesis(s)){
                System.out.println("No sea Bruto");
                return a;
           }       
           NodoArbolBin n = new NodoArbolBin (null,null,null);
           Objeto x = new Objeto();
           Objeto ant = new Objeto();//anterior
           
           ant.cambiarCar(s.substring(0,1));
           x.cambiarCar(s.substring(1,2));
           a.insertarRaizIzq(x);
           
           for (int i = 2; i<s.length(); i++)
           {    
               x = new Objeto();
               x.cambiarCar(s.substring(i,i+1));
               
               if(!x.carObjeto().equals(")")&&!x.carObjeto().equals("("))
               {
               
                   if(!esNumero(ant.carObjeto())&&!ant.carObjeto().equals(")"))
                        a.insertarHijoIzq(x);
                    
                        else if (esNumero(ant.carObjeto())){                   
                            do{
                                a.subirNivel();
                                if(a.ventanaArbolBin().hijoDerNodo()==null)
                                a.insertarHijoDer(x);
                                if(a.ventanaArbolBin()== a.raizArbolBin()   && a.ventanaArbolBin().hijoDerNodo() != null){
                                   System.out.println("La expresion no es Correcta hay elementos de mas");
                                   a= new ArbolBin(null, null); 
                                   return a;
                                } 
                            }while(a.ventanaArbolBin().hijoDerNodo() != null);
                        }
                   ant=x; 
                }
            } 
               if (!a.esCompletoArbolBin()){
                  System.out.println("La expresion no es Correcta, arbol Incompleto");
                  a= new ArbolBin(null, null); 
               }
               return a;
 
            }
            
        /*---------------------------------------------------------------*/    
        static void recorridoSintaxisPreorden (NodoArbolBin a)  
        { 
           if ( a != null)
           {
                System.out.print(a.infoNodo().carObjeto());
                recorridoSintaxisPreorden(a.hijoIzqNodo());
                recorridoSintaxisPreorden(a.hijoDerNodo());
            }
        }
        
        //37.   Hacer una función que reciba un árbol de sintaxis y muestre por pantalla la expresión que corresponde en preorden        
        static void sintaxisPreorden (ArbolBin a){
        if (a.raizArbolBin() == null)
          System.out.println("El arbol esta vacio");
        else          
          recorridoSintaxisPreorden(a.raizArbolBin());
          System.out.println();
        }  
        
        /*---------------------------------------------------------------*/
        static void recorridoSintaxisInorden (NodoArbolBin a)  
        { 
           if ( a != null)
           {    
                if(!esNumero(a.infoNodo().carObjeto()))
                    System.out.print("(");
                recorridoSintaxisInorden(a.hijoIzqNodo());
                System.out.print(a.infoNodo().carObjeto());
                recorridoSintaxisInorden(a.hijoDerNodo());
                if(!esNumero(a.infoNodo().carObjeto()))
                    System.out.print(")");
                
            }
        }
        
        //38.   Hacer el mismo ejercicio anterior mostrando la expresión en inorden y encerrando en paréntisis las expresiones binarias.
        static void sintaxisInorden (ArbolBin a){
        if (a.raizArbolBin() == null)
          System.out.println("El arbol esta vacio");
        else
          recorridoSintaxisInorden(a.raizArbolBin());
          System.out.println();
        }                  
        
        //39.   Hacer una función que reciba un árbol de sintaxis y la resuelva retornando el valor resultante.
        
        static double resolverArbol(ArbolBin a)
        {
            if (a==null){
                System.out.println("El arbol esta vacio");
                return 0;
            }
            else return resolverArbolSintaxis(a.raizArbolBin());
        }
            
            
        static double resolverArbolSintaxis (NodoArbolBin a)
        {
            String s = a.infoNodo().carObjeto().substring(0,1);
            char c= s.charAt(0);
            double r=0;
            if (esNumero(s))
                r= Integer.parseInt(s.substring(0, 1));
            else{
                double i = resolverArbolSintaxis(a.hijoIzqNodo());
                double d = resolverArbolSintaxis(a.hijoDerNodo());
                if (c=='+')
                    r= i+d;
                else if (c=='-')
                    r= i-d;    
                else if (c=='*')
                    r= i*d;
                else if (c=='/')
                    r= i/d;
                else if (c=='^')
                    r= expdouble(i,d);                    
                }
                return r;
                
                
            }
        
        
            
  }

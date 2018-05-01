
/**
 *Clase principal para manejo de arboles n-arios
 */
public class PrincipalN
{


public static void main(String[] args)
   {
       ArbolN a = null;
       FuncionesArbolN arbol = new FuncionesArbolN();

       Objeto x = new Objeto();
       x.modificarOid(3);
       x.modificarNombre("Luis");
       a = arbol.insertarRaiz (a, x);

       x = new Objeto();
       x.modificarOid(8);
       x.modificarNombre("Orlando");
       arbol.insertarHijo (a, 3, x);
       
       x = new Objeto();
       x.modificarOid(34);
       x.modificarNombre("Ramona");
       arbol.insertarHijo (a, 3, x);
       
       x = new Objeto();
       x.modificarOid(21);
       x.modificarNombre("Nancy");
       arbol.insertarHijo (a, 3, x);
       
       x = new Objeto();
       x.modificarOid(11);
       x.modificarNombre("Luis Jr");
       arbol.insertarHijo (a, 3, x);
       
       x = new Objeto();
       x.modificarOid(25);
       x.modificarNombre("Josefa");
       arbol.insertarHijo (a, 21, x);
       
       x = new Objeto();
       x.modificarOid(60);
       x.modificarNombre("Javier");
       arbol.insertarHijo (a, 21, x);

       x = new Objeto();
       x.modificarOid(18);
       x.modificarNombre("Conny");
       arbol.insertarHijo (a, 8, x);
       
       x = new Objeto();
       x.modificarOid(49);
       x.modificarNombre("Eliseo");
       arbol.insertarHijo (a, 8, x);

       x = new Objeto();
       x.modificarOid(12);
       x.modificarNombre("Roberto");
       arbol.insertarHijo (a, 8, x);
       
       x = new Objeto();
       x.modificarOid(90);
       x.modificarNombre("Sandra");
       arbol.insertarHijo (a, 11, x);
       
       x = new Objeto();
       x.modificarOid(63);
       x.modificarNombre("Sergio");
       arbol.insertarHijo (a, 8, x);

       x = new Objeto();
       x.modificarOid(55);
       x.modificarNombre("Ernesto");
       arbol.insertarHijo (a, 49, x);

       x = new Objeto();
       x.modificarOid(61);
       x.modificarNombre("Paty");
       arbol.insertarHijo (a, 60, x);
       
       x = new Objeto();
       x.modificarOid(66);
       x.modificarNombre("Sofia");
       arbol.insertarHijo (a, 49, x);
       
       ArbolN b= arbol.encontrarArbolN(a,8);
       ArbolN c= arbol.encontrarArbolN(a,3);
       ArbolN an = arbol.ancestroComunArbolN(b,c);
       System.out.println (an.raizArbolN().oidObjeto());


   }
}

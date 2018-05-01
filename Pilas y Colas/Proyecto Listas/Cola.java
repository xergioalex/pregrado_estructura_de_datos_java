
/**
 * Clase de objetos para manejo de colas
 */
public class Cola
{
    Lista cola; 
    
public  Cola()
    {
    }
    
// Para crear una cola se debe llamar al método con los parámetros (0, null, null)

public  Cola (Lista l)
    {
        cola = l;
    }


public int longitudCola()
   {
       return cola.longitudLista();
   }

   
public boolean esVaciaCola ()
   {
       if (longitudCola() == 0)
          return true;
       return false;
    }


public Objeto cabezaCola()
   {
       if (esVaciaCola())  throw new StackException("La Cola está vacía");
          cola.primeroLista();
       return cola.datoVentana();   
    }  
    
    
public void agregarCola (Objeto x)
    {
       cola.ultimoLista();
       cola.anexarLista(x);
    }
    
       
public void sacarCola ()
   {  
       if (esVaciaCola())  throw new StackException("Cola está vacía.");
       cola.primeroLista();
       cola.eliminarLista();
    }
   

public Lista listaCola()
 {
    return cola;
  }

//1.    Invertir los elementos de una cola.  
public void invertirCola()
{
    Lista lst = new Lista(0,null,null);
    Pila temp = new Pila(lst);
    while(!esVaciaCola())
    {
        temp.push(cabezaCola());
        sacarCola();
    }
    while (!temp.esVaciaPila())
    {
        agregarCola(temp.top());
        temp.pop();
    }
}

//2.	Informar si el elemento X se encuentra presente en la cola C.    
public boolean existeObjetoCola (Objeto x)
{
    while (!esVaciaCola())
      {
          if (cabezaCola().compararObjeto(x))
             return true;
          sacarCola();
        }
    return false;
}    

//3.	Hacer una función boolean que indique si una cola se encuentra ordenada ascendentemente. 
public boolean colaOrdenada()
{
    int a=0,b=0;
    a=cabezaCola().idObjeto();
    sacarCola();
    while(!esVaciaCola())
    {
        b=cabezaCola().idObjeto();
        if (a>b)
        return false;
        b=a;
        sacarCola();
    }
    return true;
}

//4.	Indicar si las colas C1 y C2 son iguales (tienen los mismos elementos y en el mismo orden).
public boolean colaIgualA(Cola c2)
{
    if (longitudCola()!=c2.longitudCola())
        return false;
    else 
    {
        while(!esVaciaCola())
        {
            if(!cabezaCola().compararObjeto(c2.cabezaCola()))
                return false;
            else
            {
                sacarCola();
                c2.sacarCola();
            }
        }
        
        return true;
    }
}
            
 
//6.	Recibe una cola C, un elemento X y dos colas vacías C1 y C2, y deja en la cola C1 los elementos de C mayores que X y en C2 los otros.
public void separarLista(Objeto X, Cola c1, Cola c2)
{
    int r= X.idObjeto();
    while(!esVaciaCola())
    {
        if(cabezaCola().idObjeto()>r)
            c1.agregarCola(cabezaCola());
        else
            c2.agregarCola(cabezaCola());
       
        sacarCola();
    }    

}

//Listas con prioridad

//1.	Dada una cola con nombres de personas y prioridad, retorne el nombre de la persona con mayor prioridad.
public void prioritario()
{
    Objeto X = new Objeto();
    X=cabezaCola();
    sacarCola();
    while(!esVaciaCola())
    {
        if(cabezaCola().idObjeto()>X.idObjeto())
        X=cabezaCola();
        
        sacarCola();
    }
    System.out.println("La persona con mayor prioridad (Prioridad "+X.idObjeto()+") es "+ X.nombreObjeto());
}


//2.    Dada una cola de nombres de personas cada uno con prioridad, atender en orden de prioridad (listando en pantalla los nombres de las personas)
//que están en una cola. Solo puede usar los métodos para manejo de colas. AYUDA: utilice otra cola para ir guardando los objetos temporalmente.
public void mostrarColaPrioridad() 
{
    Lista lst = new Lista(0,null,null);
    Cola temp = new Cola(lst);
    int pMayor=0;
    int auxP=0;
   
    while(!esVaciaCola())
    {
        pMayor=0;

        while(!esVaciaCola())
        {
            if (pMayor<cabezaCola().idObjeto())
                {pMayor=cabezaCola().idObjeto();}
           
                temp.agregarCola(cabezaCola());
                sacarCola();
            }
           
        while(!temp.esVaciaCola())
        {
            if (temp.cabezaCola().idObjeto()==pMayor)
                temp.cabezaCola().mostrarDatos();
            else    
                agregarCola(temp.cabezaCola());            
               
            temp.sacarCola();
            }
        }
}


//3.	Hacer el mismo ejercicio anterior, pero aumentando la prioridad (en +1) a los objetos que estan antes de aquel que tiene la mayor prioridad. 
// Esto con el fin de que todos los objetos sean en algún momento atendidos en el caso de tener una aplicación que permita adicionar nuevos.
public void mostrarColaPrioridadAumentando() 
{
    Lista lst = new Lista(0,null,null);
    Cola temp = new Cola(lst);
    int pMayor=0;
    int auxP=0;
    int band=0;
   
    while(!esVaciaCola())
    {
        pMayor=0;
        band=0;
        while(!esVaciaCola())
        {
            if (pMayor<cabezaCola().idObjeto())
                {pMayor=cabezaCola().idObjeto();}
           
                temp.agregarCola(cabezaCola());
                sacarCola();
            }
           
        while(!temp.esVaciaCola())
        {
            if (temp.cabezaCola().idObjeto()==pMayor)
            {
                band=1;
                temp.cabezaCola().mostrarDatos();
            }
            else
            {  
                if(band==0)
                {
                    auxP=temp.cabezaCola().idObjeto()+1;
                    temp.cabezaCola().cambiarId(auxP);
                }
                agregarCola(temp.cabezaCola());
            }
               
            temp.sacarCola();
            }
        }
} 
    
}

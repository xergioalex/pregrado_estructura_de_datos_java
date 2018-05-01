

public class Grafo
{
    ListaVertice vertices;
    ListaArco arcos;
    
    public Grafo()
    {
        ListaVertice v = new ListaVertice (0, null, null);
        ListaArco a = new ListaArco (0, null, null);
        vertices = v;
        arcos = a;
    }

    public Grafo(ListaVertice lv, ListaArco la)
    {
        vertices = lv;
        arcos = la;
    }
    
    public void insertarVertice (ObjetoVertice v)
   {
       vertices.insertarLista(v);
    }
    
    public void insertarArco (ObjetoArco oa)
    {
        arcos.insertarLista(oa);
    }
    
    public boolean esVertice (ObjetoVertice v)
    {
        if(vertices.existeDato(v)!=-1)
            return true;
        return false;    
    }
    
    public int costoArco (int orig, int dest)
    {
       ObjetoArco a;
       for (int i=0; i < arcos.longitudLista(); i++)
         {
            arcos.cambiarVentana(i);   
            a = arcos.datoVentana();
            if ((orig == a.origen()) && (dest == a.destino()))
               return a.costoArco();
         }
       return -1;
    }
            
    public ListaVertice sucesores (int v)
    {
        ListaVertice lst = new ListaVertice();
        ObjetoVertice aux = new ObjetoVertice();
        arcos.primeroLista();
        for(int i=0;i<arcos.longitudLista();i++)
        {
            if (arcos.datoVentana().origen()==v)
            {   
                aux= new ObjetoVertice (arcos.datoVentana().destino());
                vertices.existeDato(aux);
                lst.insertarLista(vertices.datoVentana());
            }
            arcos.siguienteLista ();            
        }
        
        return lst;
    }
    
    public boolean existeCamino(int x, int y)
    {
        ListaVertice suc;
        if((x==y)||(costoArco(x,y)!=-1))
            return true;
        suc= sucesores(x);
        suc.marcarVertice(x);
        suc.primeroLista();
        for(int i=0;i<suc.longitudLista();i++)
            {
                suc.cambiarVentana(i);
                if(!suc.marcadoVertice(suc.datoVentana().idObjeto())&&existeCamino(suc.datoVentana().idObjeto(),y))
                    return true;
                }
        return false;
    }                
    
    public int ordenGrafo()//retorna el numero de vertices del grafo
    {
        return vertices.longitudLista();
    }
    
    public int[] dijkstra (int v)
    {
        int c,i;
        int numElem = this.ordenGrafo();
        int costo[] = new int[numElem];
        this.vertices.desmarcarTodos();
        for(i=0;i<numElem;i++)
            costo[i]= this.costoArco(v,i+1);
        this.vertices.marcarVertice(v);
        costo[v-1]=0;
        
        //System.out.println (this.siguienteVertice(costo,numElem));
        while((v=this.siguienteVertice(costo,numElem))!=-1)
        {
                
                this.vertices.marcarVertice(v);
                for(i=0;i<numElem;i++){
         
                    if((!this.vertices.marcadoVertice(i+1))&&((c=this.costoArco(v,i+1))!=-1))
                        {
                            
                            if (costo[i]==-1)
                                costo[i]=costo[v-1]+c;
                            else
                                costo[i]=min(costo[i],costo[v-1]+c);
                            
                        }
                }
           
        }
        return costo;
    }
    
    public int siguienteVertice(int costo[],int numElem)
    {
        int i, menor =-1;
        for (i=0;i<numElem;i++){
            if((!vertices.marcadoVertice(i+1))&&(costo[i]!=-1))
            
                if((menor==-1)||(costo[menor]>costo[i]))
                    menor=i;
                
        }
        return (menor==-1)?-1:menor+1;
   }
        
            
    public int min(int a,int b)
    {
        if (a<b)
            return a;
        else return b;
    }
    
    public void listarArcos ()
   {
       arcos.mostrarLista();
    }
    
    public void listarVertices ()
   {
       vertices.mostrarLista();
    }
                
}


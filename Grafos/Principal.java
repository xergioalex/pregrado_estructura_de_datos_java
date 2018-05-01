
/**
 * Es la clase que contiene al programa principal e implementa el uso de la clase CabezaLista
 */
import java.util.Random;
public class Principal
{
      public static void main(String[] args)
   {
      Grafo g = new Grafo();  // inicializa un grafo con la lista de vertices y arcos vacias

     ObjetoVertice x = new ObjetoVertice();
     ObjetoArco y = new ObjetoArco();

     
     //AGREGO LOS VERTICES
     x.cambiarId(7);
     g.insertarVertice(x);
     
     x = new ObjetoVertice();
     x.cambiarId(6);
     g.insertarVertice(x);
     
     x = new ObjetoVertice();
     x.cambiarId(5);
     g.insertarVertice(x);
     
     x = new ObjetoVertice();
     x.cambiarId(4);
     g.insertarVertice(x);
     
     x = new ObjetoVertice();
     x.cambiarId(3);
     g.insertarVertice(x);
     
     x = new ObjetoVertice();
     x.cambiarId(2);
     g.insertarVertice(x);
     
     x = new ObjetoVertice();
     x.cambiarId(1);
     g.insertarVertice(x);
     
     //AGREGO LOS ARCOS
     
     y.cambiarOrigen(1);
     y.cambiarDestino(2);
     y.cambiarCosto(10);
     g.insertarArco(y);
     
     y = new ObjetoArco();
     y.cambiarOrigen(1);
     y.cambiarDestino(3);
     y.cambiarCosto(18);
     g.insertarArco(y);

     y = new ObjetoArco();
     y.cambiarOrigen(2);
     y.cambiarDestino(3);
     y.cambiarCosto(6);
     g.insertarArco(y);
     
     y = new ObjetoArco();
     y.cambiarOrigen(2);
     y.cambiarDestino(5);
     y.cambiarCosto(3);
     g.insertarArco(y);
     
     y = new ObjetoArco();
     y.cambiarOrigen(3);
     y.cambiarDestino(4);
     y.cambiarCosto(3);
     g.insertarArco(y);
     
     y = new ObjetoArco();
     y.cambiarOrigen(4);
     y.cambiarDestino(3);
     y.cambiarCosto(2);
     g.insertarArco(y);

     y = new ObjetoArco();
     y.cambiarOrigen(4);
     y.cambiarDestino(7);
     y.cambiarCosto(2);
     g.insertarArco(y);
     
     y = new ObjetoArco();
     y.cambiarOrigen(5);
     y.cambiarDestino(4);
     y.cambiarCosto(8);
     g.insertarArco(y);
     
     y = new ObjetoArco();
     y.cambiarOrigen(5);
     y.cambiarDestino(7);
     y.cambiarCosto(10);
     g.insertarArco(y);
     
     y = new ObjetoArco();
     y.cambiarOrigen(7);
     y.cambiarDestino(6);
     y.cambiarCosto(5);
     g.insertarArco(y);
     
     y = new ObjetoArco();
     y.cambiarOrigen(3);
     y.cambiarDestino(6);
     y.cambiarCosto(20);
     g.insertarArco(y);
     
     //DIJSTRA
     System.out.println ("Costos desde el vertice 1 al resto de grafo"); 
     int[] vectorCostos = g.dijkstra (1);
     imprimirVector(vectorCostos);
    
     System.out.println ();  
     System.out.println ("Costos desde el vertice 3 al resto de grafo"); 
     vectorCostos = g.dijkstra (2);
     imprimirVector(vectorCostos);
    
     System.out.println ();  
     System.out.println ("Costos desde el vertice 3 al resto de grafo"); 
     vectorCostos = g.dijkstra (3);
     imprimirVector(vectorCostos);


     
  }
   
  
  static void imprimirVector(int[] vectorCostos){
      for(int i =0; i<vectorCostos.length; i++)
        System.out.println ("Costo"+(i+1)+"= "+vectorCostos[i]); 
        
  }
    
    
  
}

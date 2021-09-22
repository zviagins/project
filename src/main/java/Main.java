import Graphs.Graph;
import Graphs.Vertex;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello .. ");
        Graph g1 = Graph.getGraph();
        Vertex v1 = g1.addVertex("a");
        Vertex v2 = g1.addVertex("b");
        Vertex v3 = g1.addVertex("c");
        Vertex v4 = g1.addVertex("d");
        g1.addEdge(v1, v2);
        g1.addEdge(v2, v3);
        g1.addEdge(v2, v4);
        Vertex v5 = g1.addVertex("e");
        g1.addEdge(v5, v1);
        g1.addEdge(v5, v3);
        g1.addEdge(v5, v4);
        System.out.println(g1.toString());
    }
}

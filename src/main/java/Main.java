import Graphs.GraphMap;
import Graphs.Vertex;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello .. ");
        GraphMap g1 = GraphMap.getGraph();
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
        Vertex v6 = g1.addVertex("f");
        g1.addEdge(v3, v6);

        g1.addEdge(v6, v2); // adding cycle

        System.out.println(g1.toString());
        //System.out.println(g1.BFS(v5));
        //System.out.println(g1.DFS(v5));
        //System.out.println(g1.DFSrec(v5));
        Vertex root = g1.findRoot();
        System.out.println(root);
        try {
            System.out.println(g1.topologicalSort());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}

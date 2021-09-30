import Graphs.GraphMap;
import Graphs.Vertex;
import Graphs.WeightedGraph;

public class Main {

    public static void main(String[] args) {
        System.out.println("Example from:");
        System.out.println("https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/");

        WeightedGraph g1 = WeightedGraph.getGraph();
        Vertex v0 = g1.addVertex("0");
        Vertex v1 = g1.addVertex("1");
        Vertex v7 = g1.addVertex("7");
        g1.addWeightedEdge(v0, v1, 4);
        g1.addWeightedEdge(v0, v7, 8);
        Vertex v2 = g1.addVertex("2");
        g1.addWeightedEdge(v1, v2, 8);
        g1.addWeightedEdge(v1, v7, 11);
        Vertex v6 = g1.addVertex("6");
        Vertex v8 = g1.addVertex("8");
        g1.addWeightedEdge(v2, v8, 2);
        g1.addWeightedEdge(v7, v8, 7);
        g1.addWeightedEdge(v7, v6, 1);
        g1.addWeightedEdge(v8, v6, 6);
        Vertex v3 = g1.addVertex("3");
        Vertex v5 = g1.addVertex("5");
        g1.addWeightedEdge(v6, v5, 2);
        g1.addWeightedEdge(v2, v5, 4);
        g1.addWeightedEdge(v2, v3, 7);
        g1.addWeightedEdge(v3, v5, 14);
        Vertex v4 = g1.addVertex("4");
        g1.addWeightedEdge(v3, v4, 9);
        g1.addWeightedEdge(v5, v4, 10);
        System.out.println(g1.Dijkstra(v0));


        /*
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
        System.out.println(g1.BFS(v5));
        System.out.println(g1.BFSrec(v5));
        System.out.println(g1.DFS(v5));
        System.out.println(g1.DFSrec(v5));

        try {
            System.out.println(g1.topologicalSort());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
         */
    }

}

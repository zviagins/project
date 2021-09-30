package Graphs;

import java.util.Set;

public interface Graph {

    public Vertex addVertex(String data);

    public void addEdge(Vertex source, Vertex destination);

    public void addWeightedEdge(Vertex source, Vertex destination, int weight);

    public void removeVertex(Vertex v);

    public void removeEdge(Vertex source, Vertex destination);

    public Set<Vertex> BFS(Vertex root);

    public Set<Vertex> DFS(Vertex root);

}

package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private static Graph instance = null;

    private Map<Vertex, List<Vertex>> graph;

    private Graph(){
        this.graph = new HashMap<>();
    }

    public static Graph getGraph(){
        if (instance == null){
            instance = new Graph();
        }
        return instance;
    }

    public Vertex addVertex(String data){
        Vertex v = new Vertex(data);
        graph.putIfAbsent(v, new ArrayList<Vertex>());
        return v;
    }

    public void addEdge(Vertex v1, Vertex v2){
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public void removeVertex(Vertex v){
        // remove from all vertexes edge to v
        for (Vertex adj : graph.get(v)){
            graph.get(adj).remove(v);
        }
        // remove v
        graph.remove(v);
    }

    public void removeEdge(Vertex v1, Vertex v2){
        graph.get(v1).remove(v2);
        graph.get(v2).remove(v1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Vertex, List<Vertex>> entry : graph.entrySet()) {
            sb.append(entry.getKey() + " : ");
            for (Vertex vertex : entry.getValue()){
                sb.append(vertex + "  ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}

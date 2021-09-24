package Graphs;

import java.util.*;

public class GraphMap {

    private static GraphMap instance = null;

    private Map<Vertex, List<Vertex>> graph;

    private GraphMap(){
        this.graph = new HashMap<>();
    }

    public static GraphMap getGraph(){
        if (instance == null){
            instance = new GraphMap();
        }
        return instance;
    }

    public Vertex addVertex(String data){
        Vertex v = new Vertex(data);
        graph.putIfAbsent(v, new ArrayList<>());
        return v;
    }

    public void addEdge(Vertex source, Vertex destination){
        graph.get(source).add(destination);
        //graph.get(v2).add(v1); for non directed graph
    }

    public void removeVertex(Vertex v){
        for (Vertex vertex : graph.keySet()){
            graph.get(vertex).remove(v);
        }
        graph.remove(v);
    }

    public void removeEdge(Vertex source, Vertex destination){
        graph.get(source).remove(destination);
        //graph.get(v2).remove(v1); for non directed graph
    }

    public Set<Vertex> BFS(Vertex root){
        if (root == null) throw new IllegalArgumentException();
        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()){
            Vertex current = queue.poll();
            for (Vertex adj : graph.get(current)){
                if (!visited.contains(adj)) {
                    queue.add(adj);
                    visited.add(adj);
                }
            }
        }
        return visited;
    }

    public Set<Vertex> DFS(Vertex root){
        if (root == null) throw new IllegalArgumentException();
        Set<Vertex> visited = new LinkedHashSet<>(); // LinkedHashSet remembers the order in which the elements were inserted into the set
        Stack<Vertex> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Vertex current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                for (Vertex adj : graph.get(current)) {
                    stack.push(adj);
                }
            }
        }
        return visited;
    }

    public Set<Vertex> DFSrec(Vertex root){
        Set<Vertex> visited = new LinkedHashSet<>(); // LinkedHashSet remembers the order in which the elements were inserted into the set
        DFSrec(root, visited);
        return visited;
    }

    public void DFSrec(Vertex root, Set<Vertex> visited){
        visited.add(root);
        for (Vertex v : graph.get(root)){
            if (!visited.contains(v))
                DFSrec(v, visited);
        }
    }


    /**
     * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
     * vertices such that for every directed edge u v, vertex u comes before v in the ordering.
     * Topological Sorting for a graph is not possible if the graph is not a DAG.
     *
     *         L ← Empty list that will contain the sorted nodes
     *         while exists nodes without a permanent mark do
     *             select an unmarked node n
     *             visit(n)
     *
     *         function visit(node n)
     *             if n has a permanent mark then
     *                 return
     *             if n has a temporary mark then
     *                 stop   (not a DAG)
     *
     *             mark n with a temporary mark
     *
     *             for each node m with an edge from n to m do
     *                 visit(m)
     *
     *             remove temporary mark from n
     *             mark n with a permanent mark
     *             add n to head of L
     *
     * @param
     * @return
     */
    public Set<Vertex> topologicalSort() throws Exception {
        Set<Vertex> result = new LinkedHashSet<>();
        Set<Vertex> allNodes = new HashSet<>(graph.keySet());
        for (Vertex v : allNodes){
            visit(v, new LinkedHashSet(), result);
        }
        return result;
    }

    private void visit(Vertex v, Set temporary, Set permanent) throws Exception {
        if (permanent.contains(v))
            return;
        if (temporary.contains(v))
            throw new Exception("graph contains cycle");
        temporary.add(v);
        for (Vertex adj : graph.get(v)){
            visit(adj, temporary, permanent);
        }
        temporary.remove(v);
        permanent.add(v);
    }

    public Set<Vertex> Dijkstra(){
        return null;
    }

    public Vertex findRoot(){
        Set<Vertex> allVertexes = new HashSet<>(graph.keySet());
        for (Vertex v : graph.keySet()){
            allVertexes.removeAll(graph.get(v));
        }
        for (Vertex v : allVertexes) {
            return v;
        }
        System.out.println("No root in graph");
        return null;
    }


    //TODO Dijkstra, Floyd


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

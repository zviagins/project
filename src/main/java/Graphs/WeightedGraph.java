package Graphs;

import java.util.*;

public class WeightedGraph implements Graph {

    private static WeightedGraph instance = null;

    private Map<Vertex, Map<Vertex, Integer>> graph;

    private WeightedGraph() {
        graph = new HashMap<>();
    }

    public static WeightedGraph getGraph(){
        if (instance == null){
            instance = new WeightedGraph();
        }
        return instance;
    }

    @Override
    public Vertex addVertex(String data) {
        Vertex v = new Vertex(data);
        graph.put(v, new HashMap<>());
        return v;
    }

    @Override
    public void addEdge(Vertex source, Vertex destination) {

    }

    @Override
    public void addWeightedEdge(Vertex source, Vertex destination, int weight) {
        graph.get(source).put(destination, weight);
    }

    @Override
    public void removeVertex(Vertex v) {

    }

    @Override
    public void removeEdge(Vertex source, Vertex destination) {

    }

    @Override
    public Set<Vertex> BFS(Vertex root) {
        return null;
    }

    @Override
    public Set<Vertex> DFS(Vertex root) {
        return null;
    }

    /**
     * For a given source node in the graph, the algorithm finds the shortest path between that node and every other.
     *
     * Algorithm
     *
     * 1. Mark all nodes unvisited. Create a set of all the unvisited nodes called the unvisited set.
     *
     * 2. Assign to every node a tentative distance value: set it to zero for our initial node and to
     * 	infinity for all other nodes. Set the initial node as current.
     *
     * 3. For the current node, consider all of its unvisited neighbours and calculate their tentative
     * 	distances[Note 1] through the current node. Compare the newly calculated tentative distance
     * 	to the current assigned value and assign the smaller one. For example, if the current
     * 	node A is marked with a distance of 6, and the edge connecting it with a neighbour B has length 2,
     * 	then the distance to B through A will be 6 + 2 = 8. If B was previously marked with a distance
     * 	greater than 8 then change it to 8. Otherwise, the current value will be kept.
     *
     * 4. When we are done considering all of the unvisited neighbours of the current node,
     * 	mark the current node as visited and remove it from the unvisited set.
     * 	A visited node will never be checked again.
     *
     * 5. If the destination node has been marked visited (when planning a route between two specific nodes)
     * 	or if the smallest tentative distance among the nodes in the unvisited set is infinity
     * 	(when planning a complete traversal; occurs when there is no connection between the initial node and remaining unvisited nodes),
     * 	then stop. The algorithm has finished.
     *
     * 6. Otherwise, select the unvisited node that is marked with the smallest tentative distance,
     * 	set it as the new "current node", and go back to step 3
     * @param root
     * @return
     */
    public Set<VertexAndDistance> Dijkstra(Vertex root){
        Set<VertexAndDistance> result = new HashSet<>();
        Map<Vertex, Integer> unvisited = new HashMap<>();
        PriorityQueue<VertexAndDistance> distancesQueue = new PriorityQueue<>(graph.size(), (v1, v2) -> v1.distance.compareTo(v2.distance));
        for (Vertex v : graph.keySet()){
            if (v.equals(root)) {
                distancesQueue.add(new VertexAndDistance(v, 0));
                unvisited.put(root, 0);
            }
            else {
                distancesQueue.add(new VertexAndDistance(v, Integer.MAX_VALUE));
                unvisited.put(v, Integer.MAX_VALUE);
            }

        }
        while (!distancesQueue.isEmpty()){
            VertexAndDistance curr = distancesQueue.poll();
            unvisited.remove(curr.v);
            result.add(curr);
            for (Vertex v : graph.get(curr.v).keySet()){
                if (unvisited.containsKey(v)){
                    int altDistance = curr.distance + graph.get(curr.v).get(v);
                    if (altDistance < unvisited.get(v)){
                        unvisited.put(v, altDistance);
                        distancesQueue.remove(new VertexAndDistance(v, 1));
                        distancesQueue.add(new VertexAndDistance(v, altDistance));
                    }
                }
            }
        }
        return result;
    }

    private class VertexAndDistance {
        Vertex v;
        Integer distance;

        public VertexAndDistance(Vertex v, Integer distance) {
            this.v = v;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "VertexAndDistance{" +
                    "v=" + v.data +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VertexAndDistance that = (VertexAndDistance) o;
            return Objects.equals(v, that.v);
        }

        @Override
        public int hashCode() {
            return Objects.hash(v);
        }
    }
}

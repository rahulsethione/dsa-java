package graphs;

import java.util.*;

public class WeightedGraph<T> {

    Map<Vertex<T>, List<Edge<T>>> map = new HashMap<>();

    // Dijkastra's Algorithm
    public Map<Vertex<T>, Double> getShortestPathFrom(T source) {
        Map<Vertex<T>, Double> distanceMap = new LinkedHashMap<>();

        for(Map.Entry<Vertex<T>, List<Edge<T>>> entry: map.entrySet()) {
            distanceMap.put(entry.getKey(), Double.POSITIVE_INFINITY);
        }

        Set<Vertex> visitedVertices = new LinkedHashSet<>();
        Vertex<T> sourceVertex = new Vertex<>(source);
        Queue<Vertex<T>> queue = new LinkedList<>();

        distanceMap.put(sourceVertex, 0d);
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.remove();

            visitedVertices.add(vertex);
            for(Edge<T> edge: map.get(vertex)) {
                Vertex<T> otherVertex = edge.connectedVertex(vertex);

                if(!visitedVertices.contains(otherVertex))
                    queue.add(otherVertex);

                if(distanceMap.get(vertex) + edge.weight < distanceMap.get(otherVertex)) {
                   distanceMap.put(otherVertex, distanceMap.get(vertex) + edge.weight);
                }
            }
        }

        return distanceMap;
    }
}

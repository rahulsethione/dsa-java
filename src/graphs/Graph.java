package graphs;

import java.util.*;
import java.util.function.Consumer;

public class Graph<T> {
    Map<Vertex<T>, List<Vertex<T>>> adjacencyMap = new HashMap<>();

    public Graph() { }

    public static class GraphException extends Exception {
        public GraphException(String message) {
            super(message);
        }
    }

    public void addVertex(T data) {
        adjacencyMap.putIfAbsent(new Vertex<>(data), new LinkedList<>());
    }

    public List<Vertex<T>> removeVertex(T data) {
        Vertex vertex = new Vertex(data);
        adjacencyMap.values().stream().forEach(edge -> edge.remove(vertex));
        return adjacencyMap.remove(vertex);
    }

    public void addEdge(T data1, T data2) throws GraphException {
        Vertex v1 = new Vertex(data1),
            v2 = new Vertex(data2);

        if(!adjacencyMap.containsKey(v1) || !adjacencyMap.containsKey(v2)) {
            throw new GraphException("Cannot add edge between non-existing vertices");
        }

        adjacencyMap.get(v1).add(v2);
        adjacencyMap.get(v2).add(v1);
    }

    public void removeEdge(T data1, T data2) {
        Vertex v1 = new Vertex(data1), v2 = new Vertex(data2);

        if(!adjacencyMap.containsKey(v1) || !adjacencyMap.containsKey(v2)) {
            return;
        }

        adjacencyMap.get(v1).remove(v2);
        adjacencyMap.get(v2).remove(v1);
    }

    public void breadthFirstSearch(Consumer<T> consumerFunction) {
        final Set<Vertex<T>> visitedVertices = new LinkedHashSet<>();
        final Queue<Vertex<T>> queue = new LinkedList<>();

        for(Map.Entry<Vertex<T>, List<Vertex<T>>> entry: adjacencyMap.entrySet()) {
            if(visitedVertices.contains(entry.getKey()))
                continue;

            queue.add(entry.getKey()); // Enqueue

            while(!queue.isEmpty()) {
                Vertex<T> front = queue.remove();

                consumerFunction.accept(front.data);
                for(Vertex<T> vertex : adjacencyMap.get(front)) {
                    if(!visitedVertices.contains(vertex)) {
                        queue.add(vertex); // Enqueue
                    }
                }
            }
        }
    }

    public void depthFirstSearch(Consumer<T> consumerFunction) {
        final Set<Vertex<T>> visitedVertices = new LinkedHashSet<>();
        final Stack<Vertex<T>> stack = new Stack<>();

        for(Map.Entry<Vertex<T>, List<Vertex<T>>> entry: adjacencyMap.entrySet()) {
            if(visitedVertices.contains(entry.getKey()))
                continue;

            stack.push(entry.getKey());

            while (!stack.isEmpty()) {
                Vertex<T> top = stack.pop();

                consumerFunction.accept(top.data);
                visitedVertices.add(top);
                adjacencyMap.get(top).forEach(v -> {
                    if(!visitedVertices.contains(v))
                        stack.push(v);
                });
            }
        }
    }
}

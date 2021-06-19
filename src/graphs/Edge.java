package graphs;

import java.util.Arrays;
import java.util.Objects;

public class Edge<T> {
    int weight = 0;
    Vertex<T>[] vertices = new Vertex[2];

    public Edge(int weight, T data1, T data2) {
        this.weight = weight;
        this.vertices[0] = new Vertex<>(data1);
        this.vertices[1] = new Vertex<>(data2);
    }

    public boolean connectsVertex(T data) {
        Vertex vertex = new Vertex(data);

        return vertices[0].equals(vertex) || vertices[1].equals(vertex);
    }

    public Vertex<T> connectedVertex(Vertex<T> vertex) {
        return vertices[0].equals(vertex) ? vertices[1] : vertices[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return weight == edge.weight && Arrays.equals(vertices, edge.vertices);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(weight);
        result = 31 * result + Arrays.hashCode(vertices);
        return result;
    }
}

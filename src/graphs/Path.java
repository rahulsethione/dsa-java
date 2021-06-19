package graphs;

import java.util.LinkedList;
import java.util.List;

public class Path<T> {
    Double distance = Double.POSITIVE_INFINITY;
    List<Vertex<T>> list = new LinkedList<>();
}

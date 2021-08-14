package graphs;

public class GraphTest {
    public static void main(String[] args) throws Exception {
        Graph graph = testcase();

        System.out.println("BFS:");
        graph.breadthFirstSearch(obj -> {
            System.out.println(obj);
        });

        System.out.println("DFS:");
        graph.depthFirstSearch(obj -> {
            System.out.println(obj);
        });
    }

    static Graph testcase() throws Exception {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");

        return graph;
    }
}

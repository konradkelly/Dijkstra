import java.util.ArrayList;
import java.util.List;

/**
 * A tiny helper for building maps (graphs) made of towns and roads.
 *
 * Towns are identified by integer indices 0..n-1.
 * You do NOT need to modify this file.
 */
public final class Graph {

    /** Create an empty map with {@code n} towns and no roads yet. */
    public static List<List<Edge>> create(int n) {
        List<List<Edge>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    /** Add a one-way road from {@code from} to {@code to} of length {@code weight}. */
    public static void addDirected(List<List<Edge>> g, int from, int to, int weight) {
        g.get(from).add(new Edge(to, weight));
    }

    /** Add a two-way road between {@code a} and {@code b} of length {@code weight}. */
    public static void addRoad(List<List<Edge>> g, int a, int b, int weight) {
        g.get(a).add(new Edge(b, weight));
        g.get(b).add(new Edge(a, weight));
    }

    /**
     * Builds the exact map used in the lesson slides.
     *
     * Town indices:  A=0, B=1, C=2, D=3, E=4
     * Roads (two-way):
     *   A-D = 1, A-B = 6, D-B = 2, D-E = 1, B-E = 2, B-C = 5, E-C = 5
     *
     * Shortest distances from A should be: [0, 3, 7, 1, 2]
     */
    public static List<List<Edge>> lessonMap() {
        List<List<Edge>> g = create(5);
        addRoad(g, 0, 3, 1); // A-D
        addRoad(g, 0, 1, 6); // A-B
        addRoad(g, 3, 1, 2); // D-B
        addRoad(g, 3, 4, 1); // D-E
        addRoad(g, 1, 4, 2); // B-E
        addRoad(g, 1, 2, 5); // B-C
        addRoad(g, 4, 2, 5); // E-C
        return g;
    }

    private Graph() {}
}

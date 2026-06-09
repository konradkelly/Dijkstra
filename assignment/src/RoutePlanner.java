import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * YOUR ASSIGNMENT lives here.
 *
 * Implement Dijkstra's algorithm to find the shortest distance from a source
 * town to every other town in the graph.
 *
 * Run the tests with:
 *     javac src/*.java -d out
 *     java  -cp out RoutePlannerTest
 *
 * All tests should print PASS when you are done.
 */
public final class RoutePlanner {

    /** Use this to mean "unreachable / infinitely far". */
    public static final int UNREACHABLE = Integer.MAX_VALUE;

    /**
     * Compute the shortest distance from {@code src} to EVERY town.
     *
     * @param graph adjacency list: graph.get(u) is the list of roads leaving town u
     * @param src   the starting town index
     * @return an int array {@code dist} where dist[v] is the fewest miles from
     *         src to v, or {@link #UNREACHABLE} if v cannot be reached.
     *         dist[src] must be 0.
     *
     * Requirements:
     *   - Assume all road weights are >= 0.
     *   - Use a java.util.PriorityQueue so you always expand the nearest
     *     unvisited town next (see the lesson slides).
     *
     * TODO: implement this method.
     */
    public static int[] shortestDistances(List<List<Edge>> graph, int src) {
        // TODO: Replace this stub with a real Dijkstra implementation.
        //
        // Suggested steps:
        //   1. int n = graph.size();
        //   2. int[] dist = new int[n]; Arrays.fill(dist, UNREACHABLE); dist[src] = 0;
        //   3. PriorityQueue<int[]> pq ordered by element [1] (the distance).
        //      pq.add(new int[]{src, 0});
        //   4. while pq not empty:
        //        pop {u, d}; if (d > dist[u]) continue;   // skip stale entries
        //        for each Edge e in graph.get(u):
        //            if (dist[u] + e.weight() < dist[e.to()]) {
        //                update dist[e.to()] and push {e.to(), dist[e.to()]}
        //            }
        //   5. return dist;
        throw new UnsupportedOperationException("TODO: implement shortestDistances");
    }

    private RoutePlanner() {}
}

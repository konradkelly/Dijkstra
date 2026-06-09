import java.util.Arrays;
import java.util.List;

/**
 * A tiny self-contained test runner (no JUnit needed).
 *
 * Run with:
 *     javac src/*.java -d out
 *     java  -cp out RoutePlannerTest
 *
 * To save your results for submission:
 *     java -cp out RoutePlannerTest > OUTPUT.txt
 *
 * You do NOT need to modify this file.
 */
public final class RoutePlannerTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        System.out.println("=== RoutePlanner Tests ===\n");

        testLessonMapDistances();
        testStartIsZero();
        testUnreachable();
        testLineGraph();
        testDirectedGraph();
        testTwoEqualPaths();

        System.out.println("\n==========================");
        System.out.printf("Passed: %d   Failed: %d%n", passed, failed);
        if (failed == 0) {
            System.out.println("ALL TESTS PASSED -- You may submit.");
        } else {
            System.out.println("Some tests failed — keep going!");
        }
        System.exit(failed == 0 ? 0 : 1);
    }

    // ---- Test cases ---------------------------------------------------------

    private static void testLessonMapDistances() {
        int[] dist = RoutePlanner.shortestDistances(Graph.lessonMap(), 0);
        check("Lesson map: distances from A == [0,3,7,1,2]",
              Arrays.equals(dist, new int[]{0, 3, 7, 1, 2}),
              "got " + Arrays.toString(dist));
    }

    private static void testStartIsZero() {
        int[] dist = RoutePlanner.shortestDistances(Graph.lessonMap(), 2);
        check("Distance from a town to itself is 0",
              dist[2] == 0, "got dist[2] = " + dist[2]);
    }

    private static void testUnreachable() {
        // 3 towns; town 2 is an island with no roads.
        List<List<Edge>> g = Graph.create(3);
        Graph.addRoad(g, 0, 1, 4);
        int[] dist = RoutePlanner.shortestDistances(g, 0);
        boolean ok = dist[0] == 0 && dist[1] == 4
                && dist[2] == RoutePlanner.UNREACHABLE;
        check("Unreachable town has distance UNREACHABLE", ok,
              "got " + Arrays.toString(dist));
    }

    private static void testLineGraph() {
        // 0 -1- 1 -1- 2 -1- 3 -1- 4   (a straight line of towns)
        List<List<Edge>> g = Graph.create(5);
        for (int i = 0; i < 4; i++) Graph.addRoad(g, i, i + 1, 1);
        int[] dist = RoutePlanner.shortestDistances(g, 0);
        check("Line graph: distances == [0,1,2,3,4]",
              Arrays.equals(dist, new int[]{0, 1, 2, 3, 4}),
              "got " + Arrays.toString(dist));
    }

    private static void testDirectedGraph() {
        // One-way roads: 0->1 (2), 1->2 (3), 0->2 (10)
        // Cheapest 0->2 is via 1: 2 + 3 = 5  (not the direct 10).
        List<List<Edge>> g = Graph.create(3);
        Graph.addDirected(g, 0, 1, 2);
        Graph.addDirected(g, 1, 2, 3);
        Graph.addDirected(g, 0, 2, 10);
        int[] dist = RoutePlanner.shortestDistances(g, 0);
        check("Directed graph: dist[2] == 5 (via town 1)",
              dist[2] == 5, "got " + Arrays.toString(dist));
    }

    private static void testTwoEqualPaths() {
        // Diamond: 0->1->3 and 0->2->3, both cost 2. Distance must be 2.
        List<List<Edge>> g = Graph.create(4);
        Graph.addRoad(g, 0, 1, 1);
        Graph.addRoad(g, 0, 2, 1);
        Graph.addRoad(g, 1, 3, 1);
        Graph.addRoad(g, 2, 3, 1);
        int[] dist = RoutePlanner.shortestDistances(g, 0);
        check("Diamond graph: dist[3] == 2",
              dist[3] == 2, "got " + Arrays.toString(dist));
    }

    // ---- helper -------------------------------------------------------------

    private static void check(String name, boolean condition, String detail) {
        if (condition) {
            passed++;
            System.out.println("  [PASS] " + name);
        } else {
            failed++;
            System.out.println("  [FAIL] " + name + "   (" + detail + ")");
        }
    }

    private RoutePlannerTest() {}
}

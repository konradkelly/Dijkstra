/**
 * A single road leaving a town.
 *
 * @param to     the index of the town this road leads to
 * @param weight the length (miles / cost) of the road; must be >= 0 for Dijkstra
 */
public record Edge(int to, int weight) {}

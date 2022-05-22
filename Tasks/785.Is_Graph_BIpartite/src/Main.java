import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;

        ArrayList<Integer> excess = new ArrayList<>(Collections.nCopies(V,-1));

        excess.set(0,1);

        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);

        while (q.size() != 0) {
            int u = q.poll();

            for (int v = 0; v < V; ++v) {
                if (graph[u][v] == 1 && excess.get(v) == -1) {
                    excess.set(v, 1 - excess.get(u));
                    q.add(v);
                } else if (graph[u][v] == 1 && Objects.equals(excess.get(v), excess.get(u))) {
                    return false;
                }
            }
        }
        return true;
    }
}

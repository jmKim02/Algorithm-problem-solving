import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(graph, K, V);

        br.close();
    }

    public static void dijkstra(List<List<Node>> graph, int s, int N) {
        StringBuilder sb = new StringBuilder();
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int w = neighbor.weight;

                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                sb.append(dist[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }

        System.out.print(sb);
    }
}

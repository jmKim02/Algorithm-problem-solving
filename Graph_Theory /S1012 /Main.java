import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static Graph[][] graph;
    private static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            graph = new Graph[N][M];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    graph[j][k] = new Graph();
                }
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x].setValue(true);
            }

            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (search(j, k)) {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    public static boolean search(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || graph[x][y].isVisited() || !graph[x][y].isValue()) {
            return false;
        }

        graph[x][y].setVisited(true);

        // 상하좌우 네 방향 탐색
        search(x + 1, y);
        search(x - 1, y);
        search(x, y + 1);
        search(x, y - 1);

        return true;
    }

    public static class Graph {
        private boolean value;
        private boolean visited;

        public Graph() {
            this.value = false;
            this.visited = false;
        }

        public boolean isValue() {
            return value;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setValue(boolean value) {
            this.value = value;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }
}

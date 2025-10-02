
import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n ; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (dist[from][to] > cost) dist[from][to] = cost;
        }

        for (int k = 1; k <= n ; k++) {    // 경유점
            for (int i = 1; i <= n; i++) { // 츨발점
                if (dist[i][k] == INF) continue;
                for (int j = 1; j <= n; j++) { // 도착점
                    if (dist[k][j] == INF) continue;

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }



/*    static int[] dijkstra(int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Edge next : graph[cur.num]) {
                int newDist = cur.dist + next.cost;
                if (dist[next.to] > newDist) {
                    dist[next.to] = newDist;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }

        return dist;
    }*/

}

/*
* 도시 100개      / 정점
* 버스 100_000개  / 단방향 간선
* 비용 1~100_000  / 가중치
*
* dijkstra ?
*
* */
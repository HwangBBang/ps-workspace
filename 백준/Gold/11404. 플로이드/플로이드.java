import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    static class Node implements Comparable<Node>{
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Edge>[] graph;
    static int n;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
        }
        StringBuilder sb;
        for (int i = 1; i <= n; i++) {
            int[] dist = dijkstra(i);
            sb = new StringBuilder();
            for (int j = 1; j < dist.length; j++) {
                int d = dist[j] == INF ? 0 : dist[j];
                sb = sb.append(d).append(" ");
            }
            System.out.println(sb);
        }
    }

    static int[] dijkstra(int start) {
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
    }

}

/*
* 도시 100개      / 정점
* 버스 100_000개  / 단방향 간선
* 비용 1~100_000  / 가중치
*
* dijkstra ?
*
* */
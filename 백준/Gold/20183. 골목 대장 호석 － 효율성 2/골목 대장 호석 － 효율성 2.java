
import java.io.*;
import java.util.*;

public class Main {

    static int n, m, start, end;
    static long has;
    
    static List<Edge>[] graph;
    static final long INF = Long.MAX_VALUE / 4;

    static class Node implements Comparable<Node> {
        int num;
        long dist;

        public Node(int num, long dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    static class Edge {
        int to;
        long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        has = Long.parseLong(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        long highCap = -1;
        long lowCap = INF;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, c));
            graph[v].add(new Edge(u, c));
            highCap = Math.max(c, highCap);
            lowCap = Math.min(c, lowCap);
        }
        long answer = -1;
        while (lowCap <= highCap) {
            long mid = (lowCap + highCap) / 2;

            long total = dijkstra(mid);

            if (total <= has) {
                highCap = mid - 1;
                answer = mid;
            } else {
                lowCap = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static long dijkstra(long limit) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.num] != cur.dist) continue;
            if (cur.dist > has) continue;

            for (Edge next : graph[cur.num]) {
                if (next.cost > limit) continue;
                if (dist[next.to] > dist[cur.num] + next.cost) {
                    dist[next.to] = dist[cur.num] + next.cost;
                    pq.add(new Node(next.to, dist[cur.num] + next.cost));
                }
            }
        }
        return dist[end];

    }
}


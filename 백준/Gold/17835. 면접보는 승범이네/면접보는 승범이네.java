
import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static List<Edge>[] graph;
    static final long INF = Long.MAX_VALUE / 2;

    static class Node implements Comparable<Node> {
        int num; long d;
        public Node(int num, long d) {
            this.num = num; this.d = d;
        }

        @Override
        public int compareTo(Node other) {
            if (this.d != other.d)
                return Long.compare(this.d, other.d);
            else
                return Integer.compare(this.num, other.num);
        }
    }
    static class Edge{
        int to , w;
        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        int[] destination = new int[k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[v].add(new Edge(u, c));
        }

        long[] result = new long[n + 1];
        Arrays.fill(result, INF);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            destination[i] = Integer.parseInt(st.nextToken());
        }

        long[] candidate = dijkstra(destination);

        for (int j = 1; j <= n ; j++) {
            result[j] = Math.min(candidate[j], result[j]);
        }

        long[] answer = getAnswer(result);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static long[] getAnswer(long[] result) {
        long maxValue = -1;
        int maxIdx = -1;
        for (int i = result.length-1; i > 0; i--) {
            if (maxValue <= result[i]) {
                maxValue = result[i];
                maxIdx = i;
            }
        }

        return new long[]{maxIdx, maxValue};
    }

    static long[] dijkstra(int[] start) {
        long[] dist = new long[n + 1]; Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int each :start) {
            dist[each] = 0;
            pq.add(new Node(each, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.d != dist[cur.num]) continue;

            for (Edge edge : graph[cur.num]) {
                if (dist[edge.to] > dist[cur.num] + edge.w){
                    dist[edge.to] = dist[cur.num] + edge.w;
                    pq.add(new Node (edge.to, dist[edge.to]));
                }
            }
        }
        return dist;
    }
}

// '면접장까지의 거리'란 그 도시에서 도달 가능한 가장 가까운 면접장까지의 최단 거리를 뜻한다.
// N ^ 2 * Log(M) 이 시간 초과.
// 다익스트라르 여러번 돌리면 안된다.
// 출발점이 여러개라 여러번 돌렸다.
// 출발점으로 하나로 묶어 한번만 돌릴 수 있나?

// 두 번째 실패이유 cost 범위가 크고 간선 개수가 충분히 많기에 오버플로우가 난듯하다.
// => long으로 교체


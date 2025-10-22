
import java.io.*;
import java.util.*;

public class Main {

    static int n, has, start, end;
    static List<Edge>[] graph;
    static int[] parent;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node>{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
                return Integer.compare(this.cost, other.cost);
        }
    }
    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        has = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        int limit = -1;
        int low = INF;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, c));
            graph[v].add(new Edge(u, c));
            limit = Math.max(c, limit);
            low = Math.min(c, low);

        }

        int ansewr = getAnswer(low, limit);
        System.out.println(ansewr);
    }

    public static int getAnswer(int left, int right) {
        int[] result = dijkstra(start, end, right);
        if (result[end] == INF) return -1; // 도달 불가

        int answer = result[end];

        while (left <= right) {
            int mid = (left + right) / 2;
            result = dijkstra(start, end, mid);
            if (result[end] == INF) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, getResult(result));
            }
        }
        return answer;
    }
    public static int getResult(int[] dist) {
        int answer = INF;
        int idx = end;
        while (idx != start) {
            answer = Math.min(answer, dist[idx]);
            idx = parent[idx];
        }
        return answer;
    }
    public static int[] dijkstra(int start, int end, int limit) {
        int[] dist = new int[n + 1]; Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost != dist[cur.num]) continue;

            for (Edge next : graph[cur.num]) {
                if (next.cost > limit) continue;
                if (dist[next.to] > cur.cost + next.cost) {
                    dist[next.to] = cur.cost + next.cost;
                    parent[next.to] = cur.num;
                    pq.add(new Node(next.to, cur.cost + next.cost));
                }
            }

        }
        return dist;
    }
}

// 리미트를 조절해가며, 찾기
// 조절 이분탐색 log 10_000 *

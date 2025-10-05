import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            return Integer.compare(this.dist,other.dist);
        }
    }
    static class Edge{
        int to;
        int w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static List<Edge>[] graph;
    static int n;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];

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
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Result result = dijkstra(start, end);


        System.out.println(result);
    }

    public static Result dijkstra(int start, int end) {
        int[] dist = new int [n+1];
        int[] prev = new int [n+1];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if (dist[cur.num] != cur.dist) continue;

            if (cur.num == end) break;

            for (Edge edge: graph[cur.num]){
                int newDist = cur.dist + edge.w;
                if (dist[edge.to] > newDist){
                    dist[edge.to] = newDist;
                    prev[edge.to] = cur.num;
                    pq.add(new Node(edge.to, newDist));
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int p = end; p != -1; p = prev[p]) {
            path.add(p);
        }
        Collections.reverse(path);

        return new Result(dist[end], path.size(), path);
    }

    static class Result {
        int minCost;
        int logSize;
        List<Integer> log;

        public Result(int minCost, int logSize, List<Integer> log) {
            this.minCost = minCost;
            this.logSize = logSize;
            this.log = log;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb = sb.append(minCost).append("\n");
            sb = sb.append(logSize).append("\n");
            for (Integer i : log) {
                sb = sb.append(i).append(" ");
            }
            return sb.toString();
        }
    }

}



/*


트리의 정점 은 V개

트리 지금 임의 점 중 가장 먼 녀석
1 (3 2) -1
2 (4 4) -1
3 (1 2) (4 3) -1




*/
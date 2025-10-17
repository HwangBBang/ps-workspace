import java.util.*;

public class Main {

    static class Edge {
        int to, w;
        Edge(int to, int w){ this.to = to; this.w = w; }
    }

    static class Node implements Comparable<Node>{
        int v; long d;
        Node(int v, long d){ this.v = v; this.d = d; }
        @Override public int compareTo(Node o){
            int c = Long.compare(this.d, o.d);
            return (c != 0) ? c : Integer.compare(this.v, o.v); // 동점 시 번호 작은 정점 우선
        }
    }

    static final long INF = Long.MAX_VALUE / 4;
    static List<Edge>[] graph;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++){
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            graph[x].add(new Edge(y, z));
            graph[y].add(new Edge(x, z)); // 양방향
        }

        int A = sc.nextInt(), B = sc.nextInt();

        long[] distA = dijkstra(A);
        long[] distB = dijkstra(B);
        long D = distA[B];

        // 1) 최단거리
        System.out.println(D);

        // 2) 사전순 최단 경로 복원
        List<Integer> path = new ArrayList<>();
        int u = A;
        path.add(u);
        while (u != B) {
            int next = Integer.MAX_VALUE;

            for (Edge e : graph[u]) {
                int v = e.to;
                long w = e.w;
                // u->v가 최단경로의 한 간선인지 AND 거기서부터 B까지도 최단거리 유지되는지
                if (distA[u] != INF &&
                    distA[v] == distA[u] + w &&
                    distA[u] + w + distB[v] == D) {
                    if (v < next) next = v; // 번호가 가장 작은 v 선택
                }
            }

            u = next;               // 문제 조건상 항상 존재
            path.add(u);
        }

        // 출력 (공백 구분)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(path.get(i));
        }
        System.out.println(sb.toString());
    }

    static long[] dijkstra(int start){
        long[] dist = new long[n+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if (cur.d != dist[cur.v]) continue; // 스테일 노드 스킵

            for (Edge e : graph[cur.v]){
                long nd = cur.d + e.w;
                if (nd < dist[e.to]){
                    dist[e.to] = nd;
                    pq.add(new Node(e.to, nd));
                }
            }
        }
        return dist;
    }
}
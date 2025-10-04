
import java.io.*;
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
        public int compareTo(Node other){
            return Integer.compare(this.dist, other.dist);
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

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 시작 노드
            int b = Integer.parseInt(st.nextToken()); // 종료 노드
            int c = Integer.parseInt(st.nextToken()); // 거리
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int k1 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());

        int case1 = INF;
        int pathA1 = dijkstra(1, k1);
        int pathA2 = dijkstra(k1, k2);
        int pathA3 = dijkstra(k2, n);
        if (pathA1 != INF && pathA2 != INF && pathA3 != INF){
            case1 = pathA1 + pathA2 + pathA3;
        }

        int case2 = INF;
        int pathB1 = dijkstra(1, k2) ;
        int pathB2 = dijkstra(k2, k1) ;
        int pathB3 = dijkstra(k1, n);
        if (pathB1 != INF && pathB2 != INF && pathB3 != INF){
            case2 = pathB1 + pathB2 + pathB3;
        }

        int answer = (case1 == INF && case2 == INF) ? -1 : Math.min(case1, case2);
        
        System.out.print(answer);

    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.num == end) break;

            if (dist[cur.num] != cur.dist) continue;

            for (Edge next : graph[cur.num]) {
                int newDist = next.w + cur.dist;

                if (dist[next.to] > newDist) {
                    dist[next.to] = newDist;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }
        return dist[end];
    }
}

/*
    첫째 줄에 정점의 개수 N과 간선의 개수 E 주어짐
    둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데,
    a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c
    다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다.

    (2 ≤ N ≤ 800) 정점 수
    (0 ≤ E ≤ 200,000) 간선 수
    (1 ≤ c ≤ 1,000) 거리
    (v1 ≠ v2, v1 ≠ N, v2 ≠ 1)
    임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.

    800 * 1_000 = 800_000

    1번에서 N 번까지 이동
    (K1, K2)정점 두 개를 통과한 후 도착해야함
    1 -> K1 -> K2 -> N
    1 -> K2 -> K1 -> N

*/
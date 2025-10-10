
import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
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

    static class Edge {
        int from;
        int to;
        int cost;
        boolean isActive;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.isActive = true;
        }
    }

    static int n, m;
    static final int INF = Integer.MAX_VALUE / 2;
    static List<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/platinum/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            graph = new ArrayList[n];
            List<Edge>[] prev = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                prev[i] = new ArrayList<>();

            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[from].add(new Edge(from, to, cost));
            }

            int[] dist1 = dijkstra(start, end,prev);
            removeEdge(end, prev);
            int[] dist2 = dijkstra(start, end, null);

            int answer = dist2[end] == INF ? -1 : dist2[end];
            sb.append(answer).append("\n");


        }
        System.out.println(sb);

    }

    static int[] dijkstra(int start, int end, List<Edge>[] prev) {
        
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist != dist[cur.num]) continue;

            for (Edge edge : graph[cur.num]) {
                if (!edge.isActive) continue;

                int newDist = edge.cost + cur.dist;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    if (prev != null) {
                        prev[edge.to].clear();
                        prev[edge.to].add(edge);
                    }
                    pq.add(new Node(edge.to, newDist));
                } else if (newDist == dist[edge.to]) {
                    if (prev != null) {
                        prev[edge.to].add(edge);
                    }
                }
            }
        }
        return dist;
    }

    static void removeEdge(int end, List<Edge>[] prev) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(end);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Edge edge : prev[cur]) {
                edge.isActive = false;
                int prevNum = edge.from;

                if (visited[prevNum]) continue;

                visited[prevNum] = true;
                queue.add(prevNum);
            }
        }
    }
 }



/*

입력은 여러 개의 테스트 케이스

장소 : 노드
도로 : 엣지

방향 가중치 그래프

각 테스트 케이스의 첫째 줄에는 장소의 수 N (2 ≤ N ≤ 500)과 도로의 수 M (1 ≤ M ≤ 104)가 주어진다.
장소는 0부터 N-1번까지 번호가 매겨져 있다.

둘째 줄에는 시작점 S와 도착점 D가 주어진다. (S ≠ D; 0 ≤ S, D < N)

다음 M개 줄에는 도로의 정보 U, V, P가 주어진다. (U ≠ V ; 0 ≤ U, V < N; 1 ≤ P ≤ 103)

이 뜻은 U에서 V로 가는 도로의 길이가 P라는 뜻이다.

U에서 V로 가는 도로는 최대 한 개이다.

또, U에서 V로 가는 도로와 V에서 U로 가는 도로는 다른 도로이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

* */
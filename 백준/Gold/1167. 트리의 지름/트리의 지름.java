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
    static int v;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb;

        v = Integer.parseInt(br.readLine());
        graph = new ArrayList[v+1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
//            st = new StringTokenizer();
            String[] chars = br.readLine().split(" ");
            int from = Integer.parseInt(chars[0]);
            for (int j = 1; j < chars.length - 1; j += 2) {
                int to = Integer.parseInt(chars[j]);//
                int weight = Integer.parseInt(chars[j + 1]);//
                graph[from].add(new Edge(to, weight));
            }

        }
        int[] firstDist = dijkstra(1);

        int result = -1;
        int resultIdx = 0;
        for (int i = 1; i <= v; i++) {
            if (result < firstDist[i]) {
                result = firstDist[i];
                resultIdx = i;
            }
        }

        int[] secondDist = dijkstra(resultIdx);
        result = -1;
        for (int i = 1; i <= v; i++) {
            if (result < secondDist[i]) {
                result = secondDist[i];
            }
        }

        System.out.println(result);
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int [v+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if (dist[cur.num] != cur.dist) continue;

            for (Edge edge: graph[cur.num]){
                int newDist = cur.dist + edge.w;
                if (dist[edge.to] > newDist){
                    dist[edge.to] = newDist;
                    pq.add(new Node(edge.to, newDist));
                }
            }

        }

        return dist;
    }

}



/*


트리의 정점 은 V개

트리 지금 임의 점 중 가장 먼 녀석
1 (3 2) -1
2 (4 4) -1
3 (1 2) (4 3) -1




*/
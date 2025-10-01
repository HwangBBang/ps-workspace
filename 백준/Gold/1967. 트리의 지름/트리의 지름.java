
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
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[p].add(new Edge(c,w));
            graph[c].add(new Edge(p,w));
        }
        int[] rootDist = dijkstra(1);
        Node farNode1 = getFarNode(rootDist);

        int[] farDist = dijkstra(farNode1.num);
        Node farNode2 = getFarNode(farDist);


        System.out.println(farNode2.dist);

    }
    public static Node getFarNode(int[] dist){
        int maxValue = Integer.MIN_VALUE;
        int maxIdx = 0;

        for (int i = 1; i < dist.length; i++) {
            if (maxValue < dist[i]){
                maxValue = dist[i];
                maxIdx = i;
            }
        }

        return new Node(maxIdx, maxValue);
    }

    public static int[] dijkstra(int start){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int [] dist = new int [n+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new Node(start,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (dist[cur.num] != cur.dist) continue;

            for (Edge edge: graph[cur.num]){
                int newDist = edge.w + cur.dist;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.add(new Node(edge.to, newDist));
                }
            }
        }
        return dist;
    }

}
/*
노드의 갯수는 10_000
무방향 가중치 그래프 , 사이클 없음
트리의 지름이란 엣지 중에서 2개를 골랐을 때, 노드간 가장 먼 거리
왜 엣지인가? 가중치가 음수가 아니기에, 엣지가 아니라면 더 멀어질 수 있다.
따라서 엣지간에 선택을 해야한다.
엣지 중에서 선택하여 -> 다익스트라 -> 최대값 구하기?

10_000 개의 노드일 때, 엣지는 몇 개가나오는가?

루트(혹은 아무곳에서나 가장 먼놈 찾아) 
찾은 놈이 시작점으로 가장 먼놈 찾아 

*/
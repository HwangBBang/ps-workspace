import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    protected static class Node {
        int edge;
        int cost;

        public Node(int edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }
    }
    protected static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    protected static boolean[] visited;
    protected static int distList[];
    protected static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//      첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
//      모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
        st = new StringTokenizer(br.readLine()," ");

        int vertexCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

//  둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
        int startVertex = Integer.parseInt(br.readLine());

        visited = new boolean[vertexCnt+1];
        distList = new int[vertexCnt+1];

        Arrays.fill(distList, INF);

//  셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
//  이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
//  서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
        for (int i = 0; i <= vertexCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to,cost));
        }
//  방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
//  단, 모든 간선의 가중치는 10 이하의 자연수이다.
        solution(startVertex);
        for (int i = 1; i < distList.length; i++) {
            int value = distList[i];
            System.out.println(value == INF ? "INF" : value);
        }
    }

    protected static void solution(int startPoint) {
        PriorityQueue<Node> pQueue = new PriorityQueue<>((node1, node2) -> node1.cost - node2.cost); // 최소 힙
//        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> node2.cost - node1.cost); // 최대 힙
        pQueue.add(new Node(startPoint, 0));
        distList[startPoint] = 0;

        while (!pQueue.isEmpty()) {
            Node current = pQueue.poll();

            if (visited[current.edge]) continue;

            visited[current.edge] = true;
            for (Node neighbor : graph.get(current.edge)) {
                if (distList[neighbor.edge] > distList[current.edge] + neighbor.cost) {
                    distList[neighbor.edge] = distList[current.edge] + neighbor.cost;
                    pQueue.add(new Node(neighbor.edge, distList[neighbor.edge]));
                }
            }
        }


    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int point;
        int cost;
        public Node(int point,int cost){
            this.point = point;
            this.cost = cost;
        }
    }
    protected static ArrayList<ArrayList<Node>> busGraph = new ArrayList<>();
    protected static int distList[];
    protected static boolean visited[];
    protected static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

//        첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            busGraph.add(new ArrayList<>());
        }
//        둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다.
        int M = Integer.parseInt(br.readLine());

//        초기화
        distList = new int[N+1];
        visited = new boolean[N+1];

//        셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다.
        for (int i = 0; i < M; i++) {

            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            busGraph.get(start).add(new Node(end, cost));
        }
//        먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
//        그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다.
//        버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

//        그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다.
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int startPoint = Integer.parseInt(stringTokenizer.nextToken());
        int endPoint = Integer.parseInt(stringTokenizer.nextToken());
//        출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

        solution(startPoint);
        System.out.println(distList[endPoint]);
    }
    private static void solution(int startPoint) {
        Arrays.fill(distList, INF);
        PriorityQueue<Node> pQueue = new PriorityQueue<>((node1,node2) -> node1.cost - node2.cost);
        pQueue.add(new Node(startPoint, 0));distList[startPoint] = 0;

        while (!pQueue.isEmpty()) {

            Node current = pQueue.poll();
            if (visited[current.point]) continue;

            visited[current.point] = true;
            for (Node next : busGraph.get(current.point)) {
                if (distList[next.point] > distList[current.point] + next.cost) {
                    distList[next.point] = distList[current.point] + next.cost;
                }
                pQueue.add(new Node(next.point, distList[next.point]));

            }
        }
    }
    
}

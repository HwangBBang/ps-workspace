
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
문제
N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있다.

어느 날 이 N명의 학생이 X (1 ≤ X ≤ N)번 마을에 모여서 파티를 벌이기로 했다. 이 마을 사이에는 총 M개의 단방향 도로들이 있고 i번째 길을 지나는데 Ti(1 ≤ Ti ≤ 100)의 시간을 소비한다.

각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다. 하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다.

이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다.

N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 10,000), X가 공백으로 구분되어 입력된다.
두 번째 줄부터 M+1번째 줄까지 i번째 도로의 시작점, 끝점,
그리고 이 도로를 지나는데 필요한 소요시간 Ti가 들어온다.
시작점과 끝점이 같은 도로는 없으며, 시작점과 한 도시 A에서 다른 도시 B로 가는 도로의 개수는 최대 1개이다.

모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는 데이터만 입력으로 주어진다.
*/
public class Main {
    static List<Edge>[] graph;
    public static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static class Node{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1) N, M, X
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()); // 목적지이자 출발지

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i ++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            int cost    = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost)); // 단방향
        }

        int answer = Integer.MIN_VALUE;

        for (int start = 1; start <= n; start ++){
            int [] minDistFirst = dijkstra(n,start);
            int [] minDistSecond = dijkstra(n,x);
            int total = minDistFirst[x] + minDistSecond[start];
            answer = answer < total ? total : answer;
        }

        System.out.println(answer);
    }

    public static int[] dijkstra(int n, int start) {
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<Node> frontier = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost)
        );

        minDist[start] = 0;
        frontier.add(new Node(start, 0));

        while (!frontier.isEmpty()){
            Node polled = frontier.poll();
            int curNum = polled.num;
            int curCost = polled.cost;

            for (Edge e : graph[curNum]){
                int nextNum = e.to;
                int nextCost = curCost + e.cost;

                if (minDist[nextNum] > nextCost){
                    minDist[nextNum] = nextCost;
                    frontier.add(new Node(nextNum, nextCost));
                }
            }
        }
        return minDist;
    }
}


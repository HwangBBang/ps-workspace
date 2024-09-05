
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    private static boolean[] visited;
    private static final int MAX = 100000;
    private static int minTime = Integer.MAX_VALUE;
    private static int start;
    private static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        수빈이는 동생과 숨바꼭질을 하고 있다.
        String s = br.readLine();
        st = new StringTokenizer(s, " ");

//        수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX+1];

        solution();
//        수빈이는 걷거나 순간이동을 할 수 있다.
//        만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
//        순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
//        수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
        System.out.println(minTime);

    }
    private static void solution() {
        PriorityQueue<Node> pQueue = new PriorityQueue<>((node1,node2)-> node1.cost - node2.cost);
        pQueue.add(new Node(start, 0));

        while(!pQueue.isEmpty()) {
            Node current = pQueue.poll();

            visited[current.vertex] = true;
            if (current.vertex == end ) minTime = Math.min(current.cost, minTime);

            // 가능한 다음 위치들에 대해 인덱스 범위 확인 후 처리
            if (current.vertex * 2 <= MAX && !visited[current.vertex * 2]) {
                pQueue.add(new Node(current.vertex * 2, current.cost));
            }
            if (current.vertex + 1 <= MAX && !visited[current.vertex + 1]) {
                pQueue.add(new Node(current.vertex + 1, current.cost + 1));
            }
            if (current.vertex - 1 >= 0 && !visited[current.vertex - 1]) {
                pQueue.add(new Node(current.vertex - 1, current.cost + 1));
            }
        }
    }
    
}

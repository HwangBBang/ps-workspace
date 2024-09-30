import java.io.*;
import java.util.*;

//문제
//루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
//
//출력
//첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
public class Main {
    private static final int ROOT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] parents = new int[n + 1];
//        우리는 두 정점들의 연결 정보 -> 트리를 그리기
//        방향성 없는 두 버텍스
//        그래프 이론에서는 그래프를 표현할 때 인접(연결) 리스트를 이용

//        연결 리스트 초기 세팅
        ArrayList<Integer>[] adjacent= new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacent[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int nodeNum1 = Integer.parseInt(st.nextToken());
            int nodeNum2 = Integer.parseInt(st.nextToken());
            adjacent[nodeNum1].add(nodeNum2);
            adjacent[nodeNum2].add(nodeNum1);
        }

        bfs(visited, adjacent, parents);

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void bfs(boolean[] visited, ArrayList<Integer>[] adjacent, int[] parents) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(ROOT);
        visited[ROOT] = true;

        while (!queue.isEmpty()) {
            int curVertex = queue.poll();

            for (int nearVertex : adjacent[curVertex]) {
                if (visited[nearVertex]) {continue;}
                visited[nearVertex] = true;

                queue.add(nearVertex);
                parents[nearVertex] = curVertex;
            }
        }
    }
}
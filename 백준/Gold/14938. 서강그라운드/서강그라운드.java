import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n + 1];

        int[][] graph = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], 100);
            graph[i][0] = 0;
            graph[i][i] = 0;
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from][to] = weight;
            graph[to][from] = weight;
        }
        int[][]dist = solution(graph);

        int answer = -1;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) sum += items[j];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    static int[][] solution(int[][] graph){ // 플로이드 워셜

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (graph[i][k] == -1) continue;
                for (int j = 1; j <= n; j++) {
                    if (graph[k][j] == -1) continue;
                    int path = graph[i][k] + graph[k][j];
                    if (graph[i][j] > path) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        return graph;
    }

}

/*
n 지역 (1 ≤ n ≤ 100) : 정점
m 수색 범위 (1 ≤ m ≤ 15) :
r 길의 개수 (1 ≤ r ≤ 100) : 간선 개수



예은이의 수색범위 m = 4라고 하자.
( 원 밖의 숫자는 지역 번호, 안의 숫자는 아이템 수, 선 위의 숫자는 거리를 의미한다)

예은이가 2번 지역에 떨어지게 되면 1번,2번(자기 지역),3번, 5번 지역에 도달할 수 있다.

(4번 지역의 경우 가는 거리가 3 + 5 = 8 > 4(수색범위) 이므로 4번 지역의 아이템을 얻을 수 없다.)

이렇게 되면 예은이는 23개의 아이템을 얻을 수 있고, 이는 위의 필드에서 예은이가 얻을 수 있는 아이템의 최대 개수이다.

예은이는 낙하한 지역을 중심으로 거리가 수색 범위 m 이내의 모든 지역의 아이템을 습득 가능하다고 할 때,
예은이가 얻을 수 있는 아이템의 최대 개수는?

* */


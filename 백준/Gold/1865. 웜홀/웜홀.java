
import java.io.*;
import java.util.*;


public class Main {
    static final int INF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int [][]time = new int[n+1][n+1];
            for (int i = 1; i <= n ; i++) {
                Arrays.fill(time[i], INF);
                time[i][i] = 0;
                time[i][0] = 0;
            }
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                time[from][to] = Math.min(time[from][to], cost);
                time[to][from] = Math.min(time[to][from], cost);
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                time[from][to] = Math.min(time[from][to], -cost);
            }

            for (int k = 1; k <= n; k++) { // 경유 지점
                for (int s = 1; s <= n; s++) { // 출발 지점
                    if (time[s][k] == INF) continue;
                    for (int e = 1; e <= n; e++) { // 도착 지점
                        if (time[k][e] == INF) continue;

                        if(time[s][e] > time[s][k] + time[k][e]) {
                            time[s][e] = time[s][k] + time[k][e];
                        }
                    }
                }
            }
            String answer = "NO";
            for (int i = 1; i <= n ; i++) {
                if (time[i][i] < 0) {
                    answer = "YES";
                    break;
                }
            }
            System.out.println(answer);

        }

        StringBuilder sb = new StringBuilder();
        System.out.print(sb);

    }

}

/*
* 지점의 수 N(1 ≤ N ≤ 500),
* 도로의 개수 M(1 ≤ M ≤ 2500),
* 웜홀의 개수 W(1 ≤ W ≤ 200)

N개의 지점 사이
* M개의 도로 양방향
* W개의 웜홀이 있다. 단 방향


웜홀은 시작 위치에서 도착 위치로 가는 하나의 경로인데,
특이하게도 도착을 하게 되면 시작을 하였을 때보다 시간이 뒤로 가게 된다. 시간 감소
=> "즉 가중치가 음수" 다익스트라 X => 플로이드 워셜
웜홀 내에서는 시계가 거꾸로 간다고 생각하여도 좋다.

시간 여행을 매우 좋아하는 백준이는 한 가지 궁금증에 빠졌다.
한 지점에서 출발을 하여서 시간여행을 하기 시작하여
다시 출발을 하였던 위치로 돌아왔을 때, 출발을 하였을 때보다 시간이 되돌아가 있는 경우가 있는지 없는지 궁금해졌다.
여러분은 백준이를 도와 이런 일이 가능한지 불가능한지 구하는 프로그램을 작성하여라.

2
*
3 3 1
* m 개
1 2 2
1 3 4
2 3 1
* w 개
3 1 3

*
3 2 1
* m 개
1 2 3
2 3 4
* w 개
3 1 8

*/
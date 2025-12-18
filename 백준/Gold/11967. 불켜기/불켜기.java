// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};


    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Pos>[][] grid = new ArrayList[n + 1][n + 1];


        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                grid[i][j] = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Pos next = new Pos(a, b);

            grid[x][y].add(next);
        }


        int answer = 0;
        boolean[][] isOn = bfs(grid);
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (isOn[i][j]) answer++;

        System.out.println(answer);

    }

    static boolean[][] bfs(List<Pos>[][] grid) {
        boolean[][] isOn = new boolean[n + 1][n + 1];
        boolean[][] visited = new boolean[n + 1][n + 1];
        boolean[][] delay = new boolean[n + 1][n + 1]; // 근처에 불이 못켜져서 못들어간 방이있는지 ?

        Queue<Pos> que = new ArrayDeque<>();

        isOn[1][1] = true;
        visited[1][1] = true;
        que.add(new Pos(1, 1));

        while (!que.isEmpty()) {
            Pos cur = que.poll();
            List<Pos> availableTurnOn = grid[cur.x][cur.y];
            for (Pos each : availableTurnOn) {
                if (isOn[each.x][each.y]) continue;
                isOn[each.x][each.y] = true;

                if (delay[each.x][each.y] && !visited[each.x][each.y]) {
                    visited[each.x][each.y] = true;
                    que.add(new Pos(each.x, each.y));
                }
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx,ny)) continue;
                delay[nx][ny] = true;
                
                if (!isOn[nx][ny]) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                que.add(new Pos(nx, ny));

            }
        }
        return isOn;
    }

    static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }
}


/*

베시는 유일하게 불이 켜져있는 방인 (1, 1)방에서 출발한다.

어떤 방에는 다른 방의 불을 끄고 켤 수 있는 스위치가 달려있다.
예를 들어, (1, 1)방에 있는 스위치로 (1, 2)방의 불을 끄고 켤 수 있다.

    한 방에 여러개의 스위치가 있을 수 있고 --> Pos 별로 킬 수 있는 Pos 적재
    n 의 수 100 이하이기에 100 00 00

"베시는 불이 켜져있는 방으로만" 들어갈 수 있고,
각 방에서는 상하좌우에 인접한 방으로 움직일 수 있다.

베시가 불을 켤 수 있는 방의 최대 개수를 구하시오.

자 이제 문제는 상하좌우 탐색인 경우

1. 현재 킬 수 있는 것을 켜.
2. 킬 수있는 것들이 킬 수 있는 것의 사이즈를 맥스힙에 넣어
3. 뽑아서 탐색해 .
방문 했다고 끝이면 안돼

최적의 정답을 보장할 수 있는가 ?

인접한놈이있는지 기억하자

*/
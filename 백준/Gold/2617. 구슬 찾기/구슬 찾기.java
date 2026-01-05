// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer>[] heavy = new ArrayList[n + 1];
        List<Integer>[] light = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            heavy[i] = new ArrayList<>();
            light[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            heavy[small].add(big);
            light[big].add(small);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int hCnt = bfs(i, heavy);
            if (hCnt > n / 2) {
                answer++;
                continue;
            }
            int lCnt = bfs(i, light);
            if (lCnt > n / 2) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    static int bfs(int start, List<Integer>[] graph) {

        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        visited[start] = true;
        que.add(start);
        
        int cnt = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int nxt : graph[cur]) {
                if (visited[nxt]) continue;
                visited[nxt] = true;
                que.add(nxt);
                cnt++;
            }
        }

        return cnt;

    }

}
/*

*/
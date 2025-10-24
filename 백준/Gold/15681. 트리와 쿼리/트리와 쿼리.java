// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static List<Integer> log;
    static int[] size, p;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        size = new int[n + 1];
        p = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(size, 1); // 부모 구한 후 DFS 돌면서 카운트

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] questions = new int[q];
        for (int i = 0; i < q; i++) {
            questions[i] = Integer.parseInt(br.readLine());
        }

        bfs(r);
        calculate();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(size[questions[i]]);
            if (i != q-1)sb.append("\n");
        }
        System.out.println(sb);
    }

    static void calculate() {
        for (int i = log.size() - 1; i >= 0; i--) {
            int child = log.get(i);
            int parent = p[child] ;
            size[parent] += size[child];
        }
    }

    static void bfs(int parent) {
        Queue<Integer> que = new ArrayDeque<>();
        log = new ArrayList<>();

        visited[parent] = true;
        que.add(parent);
        log.add(parent);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int child : graph[cur]) {
                if(visited[child]) continue;
                p[child] = cur;
                visited[child] = true;
                que.add(child);
                log.add(child);
            }
        }
    }
}


/*

 기존 UF 는 num 이 작은 순이였으나..
 이번에는 root 가 정해져있음
 어떻게해야할까?

    BFS 돌고,, DFS 돌렸는데 시간 초과 .
    BFS :  nlog(n)
    DFS : n * nlog(n) <- 이것 때매시간 초과

    DFS를 한번만 돌아서 찾을 수 있을까?
    leaf 인지 검사해서 리프에서만 dfs 출발하도록,,
    -> 여전히 시간 초과

    DFS

 */

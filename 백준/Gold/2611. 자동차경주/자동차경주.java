// package baekjoon.gold;

import java.io.*;
import java.util.*;


public class Main {

    static int n;
    static List<Edge>[] nexts, prevs;
    static int[] indegree;
    static boolean[] validNode;
    static StringBuilder sb;

    static class Edge{
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nexts = new ArrayList[n + 1];
        prevs = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nexts[i] = new ArrayList<>();
            prevs[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nexts[start].add(new Edge(end, cost));
            prevs[end].add(new Edge(start, cost));
        }

        validNode = new boolean[n + 1];

        boolean[] forward = getReachableNode(nexts);
        boolean[] reversed = getReachableNode(prevs);
        for (int i = 1; i <= n; i++) {
            validNode[i] = forward[i] && reversed[i];
        }

        indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!validNode[i]) continue;
            for (Edge next : nexts[i]) {
                if (!validNode[next.to]) continue;
                if (next.to == 1) continue;
                indegree[next.to]++;
            }
        }
        sb = new StringBuilder();
        topoLogicalSort();

        System.out.println(sb);

    }

    static boolean[] getReachableNode(List<Edge>[] graph) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> que = new ArrayDeque<>();

        visited[1] = true;
        que.add(1);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (Edge next : graph[cur]) {
                int node = next.to;
                if (visited[node]) continue;

                visited[node] = true;
                que.add(node);
            }
        }

        return visited;
    }

    static void topoLogicalSort() {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        int[] parent = new int[n + 1];

        dist[1] = 0;
        parent[1] = 0;

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (!validNode[i]) continue;
            if (indegree[i] != 0) continue;
            que.add(i);
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (dist[cur] == -1) {
                for (Edge next : nexts[cur]) {
                    if (!validNode[next.to]) continue;

                    indegree[next.to]--;
                    if (indegree[next.to] == 0) que.add(next.to);
                }
                continue;
            }

            for (Edge next : nexts[cur]) {
                if (!validNode[next.to]) continue;
                if (next.to == 1) continue;
                
                int nextDist = dist[cur] + next.cost;
                if (nextDist > dist[next.to]) {
                    dist[next.to] = nextDist;
                    parent[next.to] = cur;
                }

                indegree[next.to]--;
                if (indegree[next.to] == 0) {
                    que.add(next.to);
                }
            }
        }

        int longDist = -1;
        int lastPath = -1;
        // 1로 가는 거 붙이기
        for (int i = 1; i <= n; i++) {
            if (!validNode[i]) continue;
            if (dist[i] == -1) continue;

            for (Edge next : nexts[i]) {
                if (next.to != 1){ continue;}

                if (longDist < dist[i] + next.cost) {
                    longDist = dist[i] + next.cost;
                    lastPath = i;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int curPath = lastPath;
        while (curPath != 0) {
            path.add(curPath);
            curPath = parent[curPath];
        }
        Collections.reverse(path);

        sb.append(longDist).append("\n");
        for (int each : path) {
            sb.append(each).append(" ");
        }
        sb.append(1);

    }

}

/*

*/

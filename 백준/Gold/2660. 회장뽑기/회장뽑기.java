// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (true) {
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            if (person1 == -1 && person2 == -1) break;
            graph[person1].add(person2);
            graph[person2].add(person1);
        }

        int bestPoint = Integer.MAX_VALUE;
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int point = getPoint(i);

            if (point < bestPoint) {
                bestPoint = point;
                candidates.clear();
                candidates.add(i);
            } else if (point == bestPoint) {
                candidates.add(i);
            }
        }
        Collections.sort(candidates);
        
        StringBuilder sb = new StringBuilder();
        sb.append(bestPoint).append(" ").append(candidates.size()).append("\n");
        for (int candidate : candidates) {
            sb.append(candidate).append(" ");
        }
        System.out.println(sb);
    }

    static int getPoint(int candidate) {
        Queue<Integer> que = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[candidate] = 0;
        que.add(candidate);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                que.add(next);
            }
        }
        int result = -1;
        for (int i : dist) {
            result = Math.max(result, i);
        }
        return result;
    }

}

// package baekjoon.gold;

import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int[] parent, indegree;
    static List<Integer>[] conditions;



    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            parent = new int[n + 1];
            indegree = new int[n + 1];
            conditions = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) conditions[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                parent[i] = Integer.parseInt(st.nextToken());
                indegree[parent[i]]++;
                conditions[i].add(parent[i]);
            }

            int answer = topologic();
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

    static int topologic() {
        Queue<Integer> pq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) pq.add(i);
        }

        int result = n;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (int nxt : conditions[cur]) {
                indegree[nxt] --;
                if (indegree[nxt] == 0) {
                    pq.add(nxt);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 1) result --;
        }

        return result;
    }
}


    /*
      사이클이 존재해야지만 한 팀이다.
      정답 = 전체 학생 - 각 사이클의 크기


      in degree 가 0 인 녀석들을 계속 제거해 나가면 사이클만 남게 된다.

    */

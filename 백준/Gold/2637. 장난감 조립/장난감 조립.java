// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] indegree = new int[n + 1];

        List<Node>[] receipt = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            receipt[i] = new ArrayList<>();

        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int next = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // x (next) 를 만드는데 , y (prev)가 k 개 필요함

            indegree[prev] ++;
            receipt[next].add(new Node(prev, cost));
        }
        Queue<Integer> que = new ArrayDeque<>();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0){
                que.add(i);
                dp[i] = 1;
            }
        }


        while (!que.isEmpty()) {
            Integer cur = que.poll();
            for (Node next : receipt[cur]) {
                dp[next.num] += next.cnt * dp[cur];
                indegree[next.num] --;
                if (indegree[next.num] == 0){
                    que.add(next.num);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            if (receipt[i].isEmpty()) {
                sb.append(i).append(" ").append(dp[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}

/*
    기본 부품, 중간 부품 -> 중간 부품 : 노드


    기본 부품으로서 1, 2, 3, 4가 있다.
    중간 부품 5는 2개의 기본 부품 1과 2개의 기본 부품 2로 만들어진다.
    1 (1개) + 2 (2개) -> 5 (1개)
    3 (3개) + 4 (4개) + 5 (2개) + 6(3개)-> 7 (1개)

    두 중간 부품이 서로를 필요로 하는 경우가 없다. => 사이클 X
*/

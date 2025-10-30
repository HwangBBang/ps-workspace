// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n + 1];
        int[] indegree = new int[n + 1];
        List<Integer>[] condition = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            condition[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            indegree[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < indegree[i]; j++) {
                condition[Integer.parseInt(st.nextToken())].add(i);
            }
        }


        int[] dp = new int[n + 1];

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0){
                dp[i] = cost[i];
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : condition[cur]) {
                dp[next] = Math.max(dp[next], dp[cur] + cost[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    que.add(next);
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}

/*
    작업마다 선행 관계가 있다.

    선행 작업이 없는 작업도 존재한다.

    1번작업 소요시간, 선행작업의 갯수
    2번작업 소요시간, 선행작업의 갯수
    3번작업 소요시간, 선행작업의 갯수

* */
// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] indegree;
    static List<Integer>[] preCondition;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
        preCondition = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) preCondition[i] = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] pd = new int[size];
            for (int j = 0; j < size; j++) {
                pd[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < size; j++) {
                int next = pd[j];
                int prev = pd[j-1];
                indegree[next]++;
                preCondition[prev].add(next);
            }
        }

        List<Integer> starts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) starts.add(i);
        }


        List<Integer> answer = topoLogicalSort(starts);

        if (answer.size() != n) {
            sb.append(0);
        } else {
            for (Integer each : answer) sb.append(each).append("\n");
        }
        System.out.println(sb);
    }

    static List<Integer> topoLogicalSort(List<Integer> starts) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();
        for (Integer start : starts) {
            order.add(start);
            que.add(start);
        }

        while (!que.isEmpty()) {
            Integer cur = que.poll();
            for (int next : preCondition[cur]) {
                indegree[next]--;
                if (indegree[next] == 0){
                    order.add(next);
                    que.add(next);
                }
            }
        }

        return order;

    }
}


/*
    사전 조건을 모두 만족하면, OK (스페셜 저지 문제) -> 위상 정렬
    사전 조건을 모두 만족하는 경우가 불가능할 수 있음
    불가능 ..?
    1 4 3
    6 2 5 4
    3 2

* */
// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] condition;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        condition = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) condition[i] = new ArrayList<>();
        inDegree = new int[n + 1];
        Arrays.fill(inDegree, 0);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            condition[prev].add(next);
            inDegree[next]++; // 다음 과목의 제약조건 수
        }

        List<Integer> starts = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            // 제약 조건이 없다면 출발점
            if (inDegree[i] == 0)  starts.add(i);
        }

        int[] answer = topologicalSort(starts);
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);

    }

    static int[] topologicalSort(List<Integer> starts) {
        int[] answer = new int[n + 1];
        Arrays.fill(answer, 1);

        Queue<Integer> que = new ArrayDeque<>();
        for (Integer start : starts) que.add(start);

        while (!que.isEmpty()) {
            Integer cur = que.poll();
            for (Integer next : condition[cur]) {
                answer[next] = Math.max(answer[next], answer[cur] + 1);
                inDegree[next] --;
                if (inDegree[next] == 0) {
                    que.add(next);
                }
            }
        }
        return answer;

    }
}

/*
    위상 정렬 (DAG)

*/

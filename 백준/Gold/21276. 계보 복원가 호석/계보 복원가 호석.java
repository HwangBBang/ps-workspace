// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n + 1];
        Map<String, Integer> indegree = new HashMap<>();
        TreeMap<String, List<String>> condition = new TreeMap<>();
        TreeMap<String, TreeSet<String>> order = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            names[i] = st.nextToken();
            indegree.put(names[i], 0);
            condition.put(names[i], new ArrayList<>());
            order.put(names[i], new TreeSet<>());

        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String next = st.nextToken();
            String prev = st.nextToken();
            indegree.put(next, indegree.get(next) + 1);
            condition.get(prev).add(next);
        }

        int answer = 0;
        StringBuilder sb = new StringBuilder();

        Queue<String> que = new ArrayDeque<>();
        for (String each : indegree.keySet()) {
            if (indegree.get(each) == 0){
                answer++;
                que.add(each);
            }
        }
        sb.append(answer).append("\n");
        for (String each : indegree.keySet()) {
            if (indegree.get(each) == 0) sb.append(each).append(" ");
        }sb.append("\n");
        while (!que.isEmpty()) {
            String cur = que.poll();

            for (String next : condition.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    que.add(next);
                    order.get(cur).add(next);
                }
            }
        }

        for (String each : order.keySet()) {
            sb.append(each).append(" ");
            sb.append(order.get(each).size()).append(" ");
            for (String s : order.get(each)) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}

// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String rootName = br.readLine();

        Map<String,List<String>> nextGen = new HashMap<>();
        Set<String> family = new HashSet<>();
        Map<String,Integer> indegree = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();
            family.add(child);
            family.add(parent1);
            family.add(parent2);

            nextGen.putIfAbsent(child, new ArrayList<>());
            nextGen.putIfAbsent(parent1, new ArrayList<>());
            nextGen.putIfAbsent(parent2, new ArrayList<>());
            nextGen.get(parent1).add(child);
            nextGen.get(parent2).add(child);

            int curDegree = indegree.getOrDefault(child, 0);
            indegree.put(child, curDegree + 2);

        }

        String[] candidates = new String[m];
        for (int i = 0; i < m; i++) {
            candidates[i] = br.readLine();
        }

        Map<String, Double> answerMap = topologicalSort(rootName, family, nextGen, indegree);
        Set<String> answerSet = answerMap.keySet();

        Double answerGen = 0.0;
        String answer = rootName;
        for (String candi : candidates) {
            if (!answerSet.contains(candi)) continue;
            double candiGen = answerMap.get(candi);
            if (answerGen < candiGen) {
                answerGen = candiGen;
                answer = candi;
            }
        }
        System.out.println(answer);
    }

    private static Map<String, Double> topologicalSort(String rootName,
                                                        Set<String> family,
                                                        Map<String, List<String>>nextGen,
                                                        Map<String, Integer> indegree) {

        Queue<String> que = new ArrayDeque<>();

        Map<String, Double> result = new HashMap<>();
        for (String each : family)
            if (each.equals(rootName)) result.put(each, 1.0);
            else result.put(each, 0.0);

        // root 는 어차피 indegree 가 0
        for (String each : family) {
            if (indegree.getOrDefault(each, 0) == 0) {
                que.add(each);
            }
        }

        while (!que.isEmpty()) {
            String cur = que.poll();

            if (nextGen.get(cur) == null) continue; // 자식이 없으면 스킵
            for (String child : nextGen.get(cur)) {
                result.put(child, result.get(child) + result.get(cur) / 2);

                indegree.put(child, indegree.get(child) - 1);
                if (indegree.get(child) == 0) {
                    que.add(child);
                }
            }
        }
        return result;
    }
}

/*

*/
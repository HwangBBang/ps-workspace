// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, p;


    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/platinum/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int[] indegree = new int[m + 1];

            List<Integer>[] nextNode = new ArrayList[m + 1];
            for (int i = 1; i <= m; i++) {
                nextNode[i] = new ArrayList<>();
            }

            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                nextNode[prev].add(next);
                indegree[next]++;
            }

            int answer = topologicalSort(indegree, nextNode);
            sb.append(k).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }


    static int topologicalSort(int[] indegree, List<Integer>[] nextNode) {
        int result = 0;
        Queue<Integer> que = new ArrayDeque<>();

        int[] strahlerOrder = new int[m + 1];
        TreeMap<Integer, Integer>[] orderMap = new TreeMap[m + 1];

        for (int i = 1; i <= m; i++) {
            orderMap[i] = new TreeMap<>();

            if (indegree[i] == 0){
                strahlerOrder[i] = 1;
                que.add(i);
            }
        }
//        map[다음 노드] : 이전 오더값들 , 갯수

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : nextNode[cur]) {
                int curMaxOrder = strahlerOrder[cur];
                int orderCnt = orderMap[next].getOrDefault(strahlerOrder[cur], 0);
                orderMap[next].put(curMaxOrder, orderCnt + 1);
                indegree[next]--;
                if (indegree[next] == 0) {
                    // 이전거 다보았으니 최대오더 픽스
                    int maxOrder = orderMap[next].lastKey();
                    if (orderMap[next].get(maxOrder) == 1) {
                        strahlerOrder[next] = maxOrder;
                    } else if (orderMap[next].get(maxOrder) > 1) {
                        strahlerOrder[next] = maxOrder + 1;
                    }
                    que.add(next);
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            result = Math.max(strahlerOrder[i], result);
        }
        return result;
    }

}

/*
Strahler 순서란?

indegree가 0인 시작 노드들은 순서가 1이다.

진입되는 녀석들중 노드의 Strahler 값이 가장큰값

Tree MAP?
TreeMap<Integer, Integer>[] strahlerMap = new TreeMap[m + 1];
 해당 노드로 들어가는 직전  (strahlerOrder , 갯수) => 너무 복잡해, 다른 방법 없을까?

 역행으로 풀어야할까?

 노드 객체를 만들까?

 다시 정리
 이전 노드들의 최대 오더를 계승한다.
 최대 오더 갯수가 2개 이상이면 최대 오더 + 1 로 갱신한다 .

*/

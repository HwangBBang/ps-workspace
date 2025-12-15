//package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] exRank, inDegree;
    static Set<Integer>[] nextNode;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            exRank = new int[n + 1];
            inDegree = new int[n + 1];
            nextNode = new HashSet[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                exRank[i] = Integer.parseInt(st.nextToken());
                nextNode[i] = new HashSet<>();
            }

            /*
                exRank[1] : x
                exRank[2] : exRank[1]
                exRank[3] : exRank[2], exRank[1]
                exRank[4] : exRank[3], exRank[2], exRank[1]
            */
            for (int i = n; i > 1 ; i--) {
                int curNode = exRank[i];
                for (int j = 1; j < i; j++) {
                    int prevNode = exRank[j];

                    nextNode[prevNode].add(curNode);
                    inDegree[curNode]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                if (nextNode[node1].contains(node2)) { // node1 -> node2 였다면
                    nextNode[node1].remove(node2);
                    inDegree[node2]--;

                    nextNode[node2].add(node1);
                    inDegree[node1]++;

                } else if(nextNode[node2].contains(node1)){ // node2 -> node1 였다면
                    nextNode[node2].remove(node1);
                    inDegree[node1]--;

                    nextNode[node1].add(node2);
                    inDegree[node2]++;
                }

            }

            topologicalSort();
        }
        System.out.println(sb);

    }

    static void topologicalSort() {
        List<Integer> start = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) start.add(i);
        }

        if (start.size() >= 2) {
            sb.append("?").append("\n");
            return;
        } else if (start.size() == 0) {
            sb.append("IMPOSSIBLE").append("\n");
            return;
        }


        List<Integer> result = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();

        result.add(start.get(0));
        que.add(start.get(0));

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : nextNode[cur]) {

                inDegree[next]--;
                if (inDegree[next] == 0) {
                    que.add(next);
                    result.add(next);
                }
            }
        }
        // indegree가 모두 0이 아니라면 IMPOSSIBLE
        for (int i = 1; i <= n; i++) {
            if(inDegree[i] != 0){
                sb.append("IMPOSSIBLE").append("\n");
                return;
            }
        }

        for (int elem: result)
            sb.append(elem).append(" ");
        sb.append("\n");
    }
}

/*

  1등팀부터 순서대로 출력한다.
  만약, 확실한 순위를 찾을 수 없다면 "?"를 출력한다.
  데이터에 일관성이 없어서 순위를 정할 수 없는 경우에는 "IMPOSSIBLE"을 출력한다.
*/

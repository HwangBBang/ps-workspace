// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, root, answer;
    static List<Integer>[] nexts;
    static boolean[] isRemoved;

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        nexts = new ArrayList[n];
        for (int i = 0; i < n; i++) nexts[i] = new ArrayList<>();

        int[] parent = new int[n];
        isRemoved = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int child = 0; child < n; child++) {
            parent[child] = Integer.parseInt(st.nextToken());
            if (parent[child] == -1) {
                root = child;
            } else {
                nexts[parent[child]].add(child);
            }

        }
        int target = Integer.parseInt(br.readLine());

        answer = 0;

        removeNode(target);
        if (isRemoved[root]) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(answer);
        }
    }

    static void dfs(int start) {
        int childCnt = 0;
        for (int next : nexts[start]) {
            if (isRemoved[next]) continue;
            childCnt++;
            dfs(next);
        }
        if (childCnt == 0) {
            answer++;
        }
    }

    static void removeNode(int node) {
        Queue<Integer> que = new ArrayDeque<>();
        isRemoved[node] = true;
        que.add(node);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : nexts[cur]) {
                if(isRemoved[next]) continue;
                isRemoved[next] = true;
                que.add(next);
            }
        }
    }



}

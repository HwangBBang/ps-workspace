// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static Node[] nodes;
    static int n,answer;

    static class Node {
        int cur;
        int left, right;

        public Node(int cur, int left, int right) {
            this.cur = cur;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a] = new Node(a, b, c);
        }
        int lastNode = getLastNode();
        answer = 0;

        dfs(1, lastNode);

    }

    static int getLastNode() {
        int cur = 1;
        while (true) {
            int next = nodes[cur].right;
            if (next == -1) {
                break;
            }
            cur = next;
        }
        return cur;
    }

    static void dfs(int cur, int lastNode) {
        visited[cur] = true;
        int left = nodes[cur].left;
        int right = nodes[cur].right;
        if (left != -1 && !visited[left]) {
            answer++;
//            System.out.println(String.format("%d -> %d", cur, left));
            dfs(left, lastNode);
        }
        if (right != -1 && !visited[right]) {
            answer++;
//            System.out.println(String.format("%d -> %d", cur, right));
            dfs(right, lastNode);
        }
        if (cur == lastNode) {
//            System.out.println(String.format("%d to parent", cur));
            System.out.println(answer);
            System.exit(0);
        }
        answer++;
        return;
    }


}

/*
    DFS / 노드간 이동 수 체크
    방문 여부 확인을 위한 bool[]
*/
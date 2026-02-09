// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int k;
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        k = Integer.parseInt(st.nextToken());

        int answer = bfs(n);
        System.out.println(answer);

    }

    static int bfs(String n) {
        int depth = 0;
        int m = n.length();

        Queue<String> que = new ArrayDeque<>();
        HashSet<String>[] visited = new HashSet[k + 1];

        for (int i = 0; i <= k; i++) visited[i] = new HashSet<>();

        que.add(n);
        visited[0].add(n);

        while (!que.isEmpty()) {
            if (depth >= k) break;
            int size = que.size(); // 레벨의 노드 수

            while (size-- > 0) {
                String cur = que.poll();
                char[] line = cur.toCharArray();

                for (int i = 0; i < m; i++) {
                    for (int j = i + 1; j < m; j++) {
                        swap(line, i, j);
                        if (line[0] != '0') {
                            String next = new String(line);
                            if (!visited[depth + 1].contains(next)) {
                                visited[depth + 1].add(next);
                                que.add(next);
                            }
                        }
                        swap(line, i, j);
                    }
                }
            }
            depth++;
        }
        int result = -1;
        for (String s : visited[k]) {
            result = Math.max(result, Integer.parseInt(s));
        }
        return result;
    }
    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

/*
    단계 별 확장,
    특정 단계서 여러 개 중 최대값
*/
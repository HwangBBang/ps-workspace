// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Long, Integer> map;

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            map = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                long n = Long.parseLong(st.nextToken());
                if (cmd.equals("I")) {
                    Integer cnt = map.putIfAbsent(n, 1);
                    if (cnt != null) {
                        map.put(n, cnt + 1);
                    }
                } else if (cmd.equals("D") && !map.isEmpty()) {
                    Long find;
                    if (n == 1) {
                        find = map.lastKey();
                        if (find == null)continue;
                        map.put(find, map.get(find) - 1);
                        if (map.get(find) == 0){ map.remove(find);}
                    } else if (n == -1) {
                        find = map.firstKey();
                        if (find == null)continue;
                        map.put(find, map.get(find) - 1);
                        if (map.get(find) == 0){ map.remove(find);}
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }


}

/*
    이중 우선순위 큐는 전형적인 우선순위 큐처럼 데이터를 삽입, 삭제할 수 있는 자료 구조

    전형적인 큐와의 차이점은
    데이터를 삭제할 때 연산 명령에 따라 우선순위가 가장 높은 데이터 또는 가장 낮은 데이터 중 하나를 삭제하는 점이다

    이중 우선순위 큐를 위해선 두 가지 연산이 사용되는데

    정수만 저장하는 이중 우선순위 큐 Q

    I 는 삽입
    D 는 삭제
    큐 내부에 중복 허용
    ‘D 1’는 Q에서 최댓값을 삭제
    ‘D -1’는 Q 에서 최솟값을 삭제

    삭제시에는 하나만 삭제

*/
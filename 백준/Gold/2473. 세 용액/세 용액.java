// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        long[] liqs = new long[n];
        TreeSet<Long> tree = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liqs[i] = Long.parseLong(st.nextToken());
            tree.add(liqs[i]);
        }

        long minValue = Long.MAX_VALUE / 2;
        long[] answer = new long[3];
        long delta;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long comp = liqs[i] + liqs[j];
                long target = comp * -1;

                Long findCeiling = tree.ceiling(target);
                if (findCeiling != null && findCeiling != liqs[i] && findCeiling != liqs[j]) {
                    delta = Math.abs(findCeiling + comp);
                    if (minValue > delta) {
                        minValue = delta;
                        answer[0] = liqs[i];
                        answer[1] = liqs[j];
                        answer[2] = findCeiling;
                    }
                }

                Long findFloor = tree.floor(target);
                if (findFloor != null && findFloor != liqs[i] && findFloor != liqs[j]) {
                    delta = Math.abs(findFloor + comp);
                    if (minValue > delta) {
                        minValue = delta;
                        answer[0] = liqs[i];
                        answer[1] = liqs[j];
                        answer[2] = findFloor;
                    }
                }
            }
        }

        Arrays.sort(answer);
        for (long l : answer) {
            sb.append(l).append(" ");
        }
        System.out.println(sb);
    }
}


/*
오름차순, 3개 선택

2개씩 묶은 조합의 배열 -> 이진 탐색 or treeset
하나 기준 잡고(2개 선택 ) 이러면 n^2 * log(n)
근데 n 이 5000 이라 25_000_000 최적화 잘하면 될 수 도?

*/

//


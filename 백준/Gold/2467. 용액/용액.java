//package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE / 2;
    static long minValue;
    static long[] answer;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] candidate = new long [n];
        TreeSet<Long> tree = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            candidate[i] = Long.parseLong(st.nextToken());
            tree.add(candidate[i]);
        }

        minValue = INF;
        answer = new long[2];

        for (int i = 0; i < n; i++) {
            long target = candidate[i] * -1;
            Long floor = tree.floor(target);
            getAnswer(target, floor);
            Long ceiling = tree.ceiling(target);
            getAnswer(target, ceiling);
        }
        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1]);
    }
    static void getAnswer(Long target ,Long comp) {
        if (comp == null) return;
        if (comp == -1*target) return;
        long delta = Math.abs(target - comp);
        if (minValue > delta){
            minValue = delta;
            answer[0] = -1 * target;
            answer[1] = comp;
        }
    }
}

/*

each : -1_000_000_000 ~ 1_000_000_000
- 서로 다름
- 오름차순으로 제공

- 양수라면 : 산성
- 음수라면 : 알칼리
음수만 혹은 양수만 제공 되는 경우 있음
=> 결국 다봐야해
    N 개 돌면서 (최적화시 N/2)
    Log N

 모두 다르고 floor ,ceil 을 쓸 수 있는 트리 세트 활용

 1. 이분 탐색
 2. 투포인터?
 3. 스택?


 */

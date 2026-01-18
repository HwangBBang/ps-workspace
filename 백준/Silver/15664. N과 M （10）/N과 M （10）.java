// package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] nums;
    static List<Integer> result;
    static LinkedHashSet<String> answer = new LinkedHashSet<>();

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        result = new ArrayList<>();

        backtracking(0,0);
        sb = new StringBuilder();
        for (String each : answer) {
            sb.append(each).append("\n");
        }
        System.out.println(sb);
    }

    static void backtracking(int step , int start) {
        if (step == m) {
            sb = new StringBuilder();

            for (int each : result) {
                sb.append(each).append(" ");
            }
            answer.add(sb.toString());
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            result.add(nums[i]);
            backtracking(step + 1, i);
            result.remove(result.size() - 1);
        }
    }

}

/*
    대 전제 : l는 뒤로가지 않는다.

    result < m 라면 r 업
    result == m 라면 카운트 업 , r 업
    result > m 라면 l 업
*/
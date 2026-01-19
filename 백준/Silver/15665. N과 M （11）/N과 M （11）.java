// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        result = new ArrayList<>();

        backtracking(0);
        sb = new StringBuilder();
        for (String each : answer) {
            sb.append(each).append("\n");
        }
        System.out.println(sb);
    }

    static void backtracking(int step ) {
        if (step == m) {
            sb = new StringBuilder();

            for (int each : result) {
                sb.append(each).append(" ");
            }
            answer.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(nums[i]);
            backtracking(step + 1);
            result.remove(result.size() - 1);
        }
    }

}

/*

*/
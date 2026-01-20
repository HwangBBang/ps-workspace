// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] nums;
    static List<Integer> result = new ArrayList<>();
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            backtracking(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void backtracking(int step, int start) {
        if (step == 6) {
            for (int each : result) {
                sb.append(each).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = start; i < k; i++) {
            result.add(nums[i]);
            backtracking(step + 1, i + 1);
            result.remove(result.size() - 1);
        }

    }

}


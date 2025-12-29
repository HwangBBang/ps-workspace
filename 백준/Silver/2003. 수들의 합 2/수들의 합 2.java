// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int answer = 0;

        int l = 1;
        int r = l;
        while (l <= r && l <= n) {
            if (result < m) {
                if (r == n + 1) break;
                result += nums[r++];

            } else {
                if (result == m) answer++;
                result -= nums[l++];
            }
        }

        System.out.println(answer);
    }

}

/*
    대 전제 : l는 뒤로가지 않는다.

    result < m 라면 r 업
    result == m 라면 카운트 업 , r 업
    result > m 라면 l 업
*/
// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int k = Integer.parseInt(br.readLine());

        for (int each : arr) {
            if (each == k) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;
        int right = 0;

        for (int each : arr) {
            if (each < k) left = each;
            else if (each > k) {
                right = each; break;
            }
        }

        int aCount = k - left;
        int bCount = right - k;

        int answer = aCount * bCount - 1;
        System.out.println(answer);
    }

    /*
     */
}


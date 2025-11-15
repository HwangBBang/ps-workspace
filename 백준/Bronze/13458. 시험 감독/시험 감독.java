// package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/bronze/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int main = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        long answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] -= main;
            answer ++;
            if (arr[i] < 0) arr[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            answer += (int)Math.ceil((double) arr[i] / sub);
        }
        System.out.println(answer);

    }
}

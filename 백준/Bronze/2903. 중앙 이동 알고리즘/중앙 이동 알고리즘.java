// package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/bronze/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int len = 2;
        for (int i = 0; i < n; i++) {
            len = len * 2 - 1;
        }
        System.out.println(len * len);

    }
}

/*

 */




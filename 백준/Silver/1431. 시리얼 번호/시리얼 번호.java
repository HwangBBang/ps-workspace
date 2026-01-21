// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        Arrays.sort(strings, (a,b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else if (getDigit(a) != getDigit(b)) {
                return getDigit(a) - getDigit(b);
            } else {
                return a.compareTo(b);
            }
        }
        );
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string).append("\n");
        }
        System.out.println(sb);
    }

    static int getDigit(String string) {
        char[] chars = string.toCharArray();
        int result = 0;
        for (char each : chars) {
            if ('0' <= each && each <= '9') {
                result += each - '0';
            }
        }
        return result;
    }

}

/*
*/
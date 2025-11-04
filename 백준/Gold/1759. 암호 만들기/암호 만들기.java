// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    static int l, c;
    static char[] candidate;
    static HashMap<Character, Integer> cnt;
    static StringBuilder sb;
    static final char M = 'M';
    static final char J = 'J';

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        candidate = new char[c];
        cnt = new HashMap<>();
        cnt.put(M, 0);
        cnt.put(J, 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            candidate[i] = st.nextToken().trim().charAt(0);
        }
        Arrays.sort(candidate);

        sb = new StringBuilder();
        choice(0, new StringBuilder());
        System.out.println(sb);
    }

    static void choice(int step, StringBuilder temp) {
        if (temp.length() == l) {
            cnt.put(M, 0);cnt.put(J, 0);

            for (int i = 0; i < temp.length(); i++) {
                if (isM(temp.charAt(i))) cnt.put(M, cnt.get(M) + 1);
                else cnt.put(J, cnt.get(J) + 1);
            }


            if (cnt.get(M) >= 1 && cnt.get(J) >= 2) {
                sb.append(temp).append("\n");
                return;
            }
        }
        for (int i = step; i < c; i++) {
            temp.append(candidate[i]);
            choice(i + 1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

    static boolean isM(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ;
    }

}

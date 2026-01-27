// package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String pivot = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (int i = 0; i < pivot.length(); i++) {
            left.addLast(pivot.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("L")) {
                if (!left.isEmpty()) right.addLast(left.removeLast());
            } else if (cmd.equals("D")) {
                if (!right.isEmpty()) left.addLast(right.removeLast());
            } else if (cmd.equals("B")) {
                if (!left.isEmpty()) left.removeLast();
            } else if (cmd.equals("P")) {
                String add = st.nextToken();
                left.addLast(add.charAt(0));
            }
        }

        StringBuilder out = new StringBuilder();
        while (!left.isEmpty()) out.append(left.removeFirst());
        while (!right.isEmpty()) out.append(right.removeLast());

        System.out.println(out);
    }
}
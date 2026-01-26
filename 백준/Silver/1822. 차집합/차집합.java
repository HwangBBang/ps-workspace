// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        TreeSet<Integer> A = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        TreeSet<Integer> B = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        A.removeAll(B);
        int n = A.size();
        
        StringBuilder sb = new StringBuilder();
        sb.append(n).append("\n");
        for (int each : A) {
            sb.append(each).append(" ");
        }
        System.out.println(sb);
    }

}

/*
       s >= n(n+1)/2
*/
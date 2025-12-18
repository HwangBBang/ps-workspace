// package baekjoon.silver;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> typeMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                typeMap.put(type, typeMap.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int eachCnt : typeMap.values()) {
                result *= (eachCnt + 1);
            }
            result--;
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}

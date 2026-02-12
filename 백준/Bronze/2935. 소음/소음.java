import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine().trim();
        String op = br.readLine().trim();
        String B = br.readLine().trim();

        int a = A.length() - 1; 
        int b = B.length() - 1;

        StringBuilder sb = new StringBuilder();

        if (op.equals("*")) {
            sb.append(1);
            for (int i = 0; i < a + b; i++) sb.append(0);
        } else { // "+"
            if (a == b) {
                sb.append(2);
                for (int i = 0; i < a; i++) sb.append(0);
            } else {
                int hi = Math.max(a, b);
                int lo = Math.min(a, b);
                int diff = hi - lo;

                sb.append(1);
                for (int i = 0; i < diff - 1; i++) sb.append(0);
                sb.append(1);
                for (int i = 0; i < lo; i++) sb.append(0);
            }
        }

        System.out.println(sb);
    }
}
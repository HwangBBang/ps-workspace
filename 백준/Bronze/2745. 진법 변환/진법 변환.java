import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();      // B진법 수 (문자열)
        int base = Integer.parseInt(st.nextToken()); // 진법 B

        long result = 0;

        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            int value;

            if ('0' <= ch && ch <= '9') {
                value = ch - '0';
            } else { // 'A' ~ 'Z'
                value = ch - 'A' + 10;
            }

            result = result * base + value;
        }

        System.out.println(result);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/baekjoon/bronze/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bin = br.readLine().trim();

        int r = bin.length() % 3;
        if (r != 0) {
            bin = "0".repeat(3 - r) + bin;
        }

        StringBuilder sb = new StringBuilder(bin.length() / 3);
        for (int i = 0; i < bin.length(); i += 3) {
            int val = (bin.charAt(i) - '0') * 4
                    + (bin.charAt(i + 1) - '0') * 2
                    + (bin.charAt(i + 2) - '0');
            sb.append(val);
        }

        String answer = sb.toString().replaceFirst("^0+(?!$)", "");
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        int a,b,c;
        while (true) {
            String[] split = br.readLine().split(" ");

            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);
            c = Integer.parseInt(split[2]);

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (!isValid(a, b, c)) {
                sb.append("Invalid\n");
                continue;
            }

            set.add(a);
            set.add(b);
            set.add(c);

            if (set.size() == 1) {
                sb.append("Equilateral\n");
            } else if (set.size() == 2) {
                sb.append("Isosceles\n");
            } else if (set.size() == 3) {
                sb.append("Scalene\n");
            }
            set.clear();
        }
        System.out.println(sb);

    }

    public static boolean isValid(int a, int b, int c) {
        int sum = a + b + c;
        int max = Math.max(Math.max(a, b), c);

        return max < (sum - max);
    }
}

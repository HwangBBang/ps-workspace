
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer,String> dic1 = new HashMap<>();
        Map<String,Integer> dic2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            dic1.put(i, name);
            dic2.put(name, i);

        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (isContainDig(s)) {
                sb.append(dic1.get(Integer.parseInt(s)) + "\n");
            } else {
                sb.append(dic2.get(s) + "\n");
            }
        }

        System.out.print(sb);

    }

    static boolean isContainDig(String s) {
        for (char i : s.toCharArray()) {
            if (Character.isDigit(i)) {
                return true;
            }
        }
        return false;
    }
}

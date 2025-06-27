import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            if (cmd.equals("add")) {
                int x = Integer.parseInt(input[1]);
                set.add(x);
            } else if (cmd.equals("remove")) {
                int x = Integer.parseInt(input[1]);
                set.remove(x);
            } else if (cmd.equals("check")) {
                int x = Integer.parseInt(input[1]);
                if (set.contains(x)) sb.append("1\n");
                else sb.append("0\n");

            } else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(input[1]);
                if (set.contains(x)) set.remove(x);
                else set.add(x);

            } else if (cmd.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) set.add(j);
            } else if (cmd.equals("empty")) {
                set.clear();
            }
        }

        System.out.print(sb);  
    }
}
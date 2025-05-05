import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<Integer> grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        grid = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            grid.add(Integer.parseInt(br.readLine()));
        }

        st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken()), e1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken()), e2 = Integer.parseInt(st.nextToken());
    //     --- 입력 끝 ---
        popByRange(s1,e1);
        popByRange(s2,e2);

        System.out.println(grid.size());
        for (Integer i : grid) {
            System.out.println(i);
        }
    }

    static void popByRange(int start, int end) {
        --start; --end;
        for (int i = end; i >= start; i--) {
            grid.remove(i);
        }
    }
}

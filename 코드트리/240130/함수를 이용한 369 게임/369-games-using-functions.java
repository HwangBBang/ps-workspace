import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int res = sol(a,b);
        System.out.println(res);
    }

    static int sol(int a,int b) {
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (isExist(i) || i % 3 == 0)cnt++;
        }
        return cnt;
    }

    static boolean isExist(int a) {
        int nextA = a;
        while (nextA != 0) {
            if (nextA % 10 == 3 || nextA % 10 == 6 || nextA % 10 == 9)
                return true;
            nextA /= 10;
        }
        return false;
    }
}
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
        int cnt = 0;
        for (int i = a; i <= b ; i++) if(sol(i)) cnt ++;
        System.out.println(cnt);
        
    }

    static boolean sol(int n) {
        if (n % 2 == 0) {
            return false;
        }
        if (n % 10 == 5) {
            return false;
        }
        if (n % 3 == 0 && n % 9 != 0) {
            return false;
        }
        return true;
    }
}
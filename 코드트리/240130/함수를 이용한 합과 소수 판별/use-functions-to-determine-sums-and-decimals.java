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
        for (int i = a; i <= b ; i++) if(isPrime(i) && eachSum(i)%2==0) cnt ++;
        System.out.println(cnt);

    }

    static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) if(n%i==0) return false;
        return true;
    }

    static int eachSum(int n) {
        int res = 0;
        int next = n;
        while (next != 0) {
            int cur = next % 10;
            res += cur;
            next /= 10;
        }
        return res;
    }
}
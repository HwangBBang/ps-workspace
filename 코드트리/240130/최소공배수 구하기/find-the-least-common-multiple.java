import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = sol(n,m);
        System.out.println(result);

    }

    static int sol(int n,int m) {
        int temp = n * m;
        int gcdResult = (n > m) ? gcd(n, m) : gcd(m, n);

        return temp/gcdResult;
    }

    static int gcd(int n, int m) {

        while (m != 0) {

            int k = n % m;
            n = m;
            m = k;
        }
        return n;
    }
}
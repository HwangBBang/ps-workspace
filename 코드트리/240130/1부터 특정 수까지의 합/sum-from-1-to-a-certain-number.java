import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = sol(n);
        System.out.println(result);
    }

    static int sol(int n) {
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            res += i;
        }
        return res/10;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sol(n);
    }

    static void sol(int n) {
        if (isMultiple5(n) && n % 2 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean isMultiple5(int n) {
        int a = n % 10;
        int b = (n / 10) % 10;
        return (a + b) % 5 == 0;
    }
}
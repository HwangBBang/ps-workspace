import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = br.readLine().charAt(0);
        a = (a == 97) ? 122 : a - 1;
        char c = (char) a;

        System.out.print(c);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] s = new String[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < s.length; i++) {
            s[i] = br.readLine();
        }
        for (int i = s.length-1; i >= 0; i--) {
            System.out.println(s[i]);
        }

    }
}
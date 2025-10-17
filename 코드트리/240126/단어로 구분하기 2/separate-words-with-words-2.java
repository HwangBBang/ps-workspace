import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = br.readLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            String string = s[i];
            if (i%2==0) {
                System.out.println(string);
            }
        }

    }
}
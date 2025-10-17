import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = br.readLine().split(" ");

        for (int i = s.length-1; i >= 0; i--) {
            String string = s[i];
            System.out.println(string);
        }

    }
}
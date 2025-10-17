import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String first = s.substring(0, 1);
        String second = s.substring(1, 2);
        s = s.replace(second, first);

        System.out.println(s);
    }
}
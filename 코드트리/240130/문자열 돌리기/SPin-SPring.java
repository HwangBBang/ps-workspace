import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneLine = br.readLine().trim();

        StringBuilder result = new StringBuilder(oneLine);

        System.out.println(result);
        int len = oneLine.length();
        for (int i = 0; i < len; i++) {
            result = new StringBuilder(result.substring(len - 1, len) + result.substring(0, len - 1));
            System.out.println(result);
        }


    }
}
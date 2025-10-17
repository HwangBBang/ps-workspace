import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();
        int n = Integer.parseInt(br.readLine().trim());
        int sl = s.length();

        if (sl < n) {
            for (int i = sl-1; i >=0; i--)
                System.out.print(s.substring(i, i + 1));
        } else  {
            for (int i = sl-1; i > sl - n -1; i--) {
                System.out.print(s.substring(i, i+1));
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder res = new StringBuilder();
        int cnt = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                res.append(s.charAt(i - 1));
                res.append(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }

        // Append the last character and its count
        res.append(s.charAt(s.length() - 1));
        res.append(cnt);

        System.out.println(res.length());
        System.out.println(res.toString());
    }
}
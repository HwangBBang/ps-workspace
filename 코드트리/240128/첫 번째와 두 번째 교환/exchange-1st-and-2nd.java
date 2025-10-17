import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String first = s.substring(0, 1);
        String second = s.substring(1, 2);
        StringBuilder sb = new StringBuilder(s);

        for (int i = 1; i <= s.length(); i++) {
            if (s.substring(i-1,i).equals(first)) {
//                s[i-1] 째를 second으로 변경
                sb.replace(i - 1, i, second);
            }
            else if (s.substring(i-1,i).equals(second)) {
//                s[i-1] 째를 first으로 변경
                sb.replace(i - 1, i, first);
            }
        }
        System.out.println(sb);
    }
}
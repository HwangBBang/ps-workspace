import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Integer.parseInt(br.readLine());
        }
        String s = String.valueOf(res) ;
        System.out.println(s.substring(1, s.length()) + s.substring(0, 1));
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(count(s,"ee")+" "+count(s,"eb"));
    }

    public static int count(String s, String str) {
        int cnt = 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.substring(i-2,i).equals(str)) {
                cnt++;
            }
        }
        return cnt;

    }
}
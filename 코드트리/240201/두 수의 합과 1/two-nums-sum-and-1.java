import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(s.nextToken());
        int b = Integer.parseInt(s.nextToken());
        String res = String.valueOf(a + b) ;
        int cnt = 0;
        for (int i = 0; i <res.length() ; i++) {
            if (res.charAt(i) == '1') cnt++;
        }
        
        System.out.println(cnt);
    }
}
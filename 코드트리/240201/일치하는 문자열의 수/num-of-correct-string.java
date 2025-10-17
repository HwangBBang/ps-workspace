import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        String A = st.nextToken();
        int cnt = 0;
        
        for (int i = 0; i <n ; i++) {
            if (A.equals(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
       
    }
}
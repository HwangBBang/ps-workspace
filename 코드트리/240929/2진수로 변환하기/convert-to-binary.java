import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String res = "";
        while(true){
            if (n <= 1){
                res = res + n;
                break;}

             res = res + (n % 2);
             n = n / 2;
        }
        StringBuffer sb = new StringBuffer(res);
        sb.reverse();
        System.out.println(sb);

    }
}
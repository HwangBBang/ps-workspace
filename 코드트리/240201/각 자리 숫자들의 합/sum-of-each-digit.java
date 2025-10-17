import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String s = String.valueOf(a) ;
        int res = 0;
        for (int i = 0; i <s.length() ; i++) {
            res += Integer.parseInt(s.substring(i,i+1));
        }

        System.out.println(res);
    }
}
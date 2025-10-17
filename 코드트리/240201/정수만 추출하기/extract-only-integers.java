import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        String s1 = s.nextToken();
        String s2 = s.nextToken();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i <s1.length() ; i++) {
            
            if (!(s1.charAt(i) >= '0' && s1.charAt(i) <= '9')) break;
            sb1.append(s1.charAt(i));
        }
        for (int i = 0; i <s2.length() ; i++) {
            
            if (!(s2.charAt(i) >= '0' && s2.charAt(i) <= '9')) break;
            sb2.append(s2.charAt(i));
        }

        int a = Integer.parseInt(sb1.toString());
        int b = Integer.parseInt(sb2.toString());
        System.out.println(a + b);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        s1 = s1.replaceAll("[^0-9]", "");
        s2 = s2.replaceAll("[^0-9]", "");
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        
        System.out.println(a+b);
    }
}
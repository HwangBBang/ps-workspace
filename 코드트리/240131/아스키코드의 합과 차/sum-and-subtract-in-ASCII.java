import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = s.charAt(0);
        int b = s.charAt(2);
        int sum =  a +  b;
        int sub = (a >= b) ? a - b : b - a;
        System.out.println(sum + " " + sub);


    }

}
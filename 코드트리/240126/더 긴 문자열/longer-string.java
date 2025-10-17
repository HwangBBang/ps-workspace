import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
//        StringTokenizer st = new StringTokenizer(line," "); 레거시

        String[] s = line.split(" ");
        if (s[0].length() == s[1].length()) {
            System.out.println("same");
        } else if (s[0].length() > s[1].length()) {
            System.out.println(s[0] +" "+ s[0].length());
        } else {
            System.out.println(s[1] +" "+ s[1].length());
        }


    }
}
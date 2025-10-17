import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();

        String res1 = s1.contains("ee") ? "Yes" : "No";
        String res2 = s1.contains("ab") ? "Yes" : "No";
        System.out.println(res1 + " " + res2);
        

    }
}
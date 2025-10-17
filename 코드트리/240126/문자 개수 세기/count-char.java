import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.substring(i,i+1).equals(s2)) res++;
        }
        System.out.println(res);

    }
}
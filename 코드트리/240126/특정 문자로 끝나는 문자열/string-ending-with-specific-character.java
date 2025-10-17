import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = new String[10];
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            s[i] = br.readLine();
        }
        String c = br.readLine();

        for (int i = 0; i < s.length; i++) {
            if (c.equals(s[i].substring(s[i].length()-1,s[i].length()))) {
                System.out.println(s[i]);
                res.add(s[i]);
            }
        }
        if (res.isEmpty()) {
            System.out.println("None");
        }

    }
}
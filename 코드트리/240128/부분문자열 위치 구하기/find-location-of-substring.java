import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String subS = br.readLine();
        System.out.println(count(s,subS));
    }

    public static int count(String s, String str) {
        int index = 0;
        int sl = str.length();
        for (int i = sl; i <= s.length(); i++) {
            if (s.substring(i-sl,i).equals(str)) {
                break;
            }
            index++;
        }
        if (index > s.length() - sl) {
            return -1;
        }
        return index;

    }
}
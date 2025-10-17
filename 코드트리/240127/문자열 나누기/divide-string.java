import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String newS = s.replace(" ", "");
        int l = newS.length();

        for (int i = 0; i <l; i+=5) {

            int endIndex = Math.min(i + 5, l);
            System.out.println(newS.substring(i,endIndex));
        }
    }
}
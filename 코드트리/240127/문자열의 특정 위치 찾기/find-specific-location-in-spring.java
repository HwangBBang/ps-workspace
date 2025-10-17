import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String[] sArr = s1.split(" ");

        String res1 = sArr[0].indexOf(sArr[1]) == -1 ? "No" : sArr[0].indexOf(sArr[1])+"" ;

        System.out.println(res1);


    }
}
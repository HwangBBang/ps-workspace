import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneLine = br.readLine().trim();

        StringBuilder result = new StringBuilder(oneLine);
//        Queue <String> result

        result.append(result.substring(0, 1));
        result.delete(0, 1);
        System.out.println(result);


    }
}
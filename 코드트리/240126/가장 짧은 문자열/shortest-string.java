import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        int[] arr = {s1.length(), s2.length(), s3.length()};
        int result = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
        System.out.println(result);
    }
}
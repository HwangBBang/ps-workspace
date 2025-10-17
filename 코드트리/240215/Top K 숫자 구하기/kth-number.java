import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();


        Arrays.sort(arr);
        System.out.println(arr[k-1]);

    }


}
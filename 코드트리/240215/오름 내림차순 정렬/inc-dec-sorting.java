import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = Arrays.stream(br.readLine().split(" "))
                        .map(a -> Integer.parseInt(a))
                        .toArray(Integer[]::new);

        Arrays.sort(arr);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        Arrays.sort(arr,Collections.reverseOrder());

        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


    }


}
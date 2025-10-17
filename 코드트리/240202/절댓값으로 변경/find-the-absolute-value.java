import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays
                // 공백으로 구분하여 입력받은 값을 분리하고, 스트림으로 변환
                .stream(br.readLine().split(" "))
                // 문자열들을 정수로 변환후 절대값
                .mapToInt(elem -> Math.abs(Integer.parseInt(elem)))
                // 변환한 값들을 배열로 수집
                .toArray();
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
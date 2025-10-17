import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        int[] ns = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s)).toArray();

        System.out.println(recFindMax(ns, n));
    }

    private static int recFindMax(int[] nums, int n) {
        if (n == 0) return nums[0];
        int curMax = recFindMax(nums, n - 1);
        return (nums[n-1] < curMax) ? curMax : nums[n - 1];

    }

}
// package baekjoon.gold;

import java.io.*;
import java.util.*;


public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        HashSet<Integer> comb = new HashSet<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                comb.add(nums[x] + nums[y]);
            }
        }

//      nums[k] - nums[z]
//      z 올리면 target 감소
//      k 올리면 target 증가
        int answer = solution(comb, nums);


        System.out.println(answer);
    }

    static int solution(HashSet<Integer> comb, int[] nums) {
        for (int k = n - 1; k >= 0; k--) {
            for (int z = 0; z <= k; z++) {
                if (comb.contains(nums[k] - nums[z])){
                    return nums[k];
                }
            }
        }
        return -1;
    }

}
/*
    합은 2억 이하
    nums[k] = nums[x] + nums[y] + nums[z]
    nums[k] - nums[z] = nums[x] + nums[y]

    x, y, z, k가 서로 같아도 된다.!!
    nums[1] = nums[1] + nums[1] + nums[1]
    자연수들로 이뤄져있음

*/
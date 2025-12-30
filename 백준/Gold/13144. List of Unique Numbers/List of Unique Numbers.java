// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        long answer = 0;
        int l = 1;
        int r = l;

        while (r <= n && l <= n && l <= r){

            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                l++;
            }

            set.add(nums[r]);

            answer += (r - l + 1);

            r++;
        }
        System.out.println(answer);
    }
}

/*
    1 2 3 4 5

    1
    12
    123
    1234
    12345
    2
    23
    234
    2345
    3
    34
    345
    4
    45
    5


    1 2 3 1 2

    1
    12
    123
    2
    23
    231
    3
    31
    312
    1
    12
    2
*/

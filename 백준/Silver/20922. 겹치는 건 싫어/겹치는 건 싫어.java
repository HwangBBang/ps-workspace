// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int l = 1; l <= n; l++) {
            int r = l;
            while (l <= r && r <= n) {
                if (map.getOrDefault(nums[r], 0) + 1 <= k) {
                    map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                    r++;
                } else {
                    map.put(nums[l], map.get(nums[l]) - 1);
                    l++;
                }
                answer = Math.max(answer , r-l);
            }
        }
        System.out.println(answer);

    }

}

/*
    l 은 앞으로 만 간다.
    r 을 기준으로 카운트한다 .

*/
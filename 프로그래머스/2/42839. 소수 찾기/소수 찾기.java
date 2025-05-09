import java.util.*;

class Solution {
    static int n;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> stack = new ArrayList<>();
    // 중복 없이 소수를 담을 Set
    static Set<Integer> foundPrimes = new HashSet<>();

    public int solution(String numbers) {
        char[] chars = numbers.toCharArray();
        n = chars.length;
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = chars[i] - '0';
        }

        foundPrimes.clear();

        // 길이 1부터 n까지 모든 조합 시도
        for (int len = 1; len <= n; len++) {
            visited = new boolean[n];
            dfs(0, len);
        }

        // Set 크기가 곧 정답
        return foundPrimes.size();
    }

    // idx: 현재 stack 크기, limit: 목표 길이
    static void dfs(int idx, int limit) {
        if (idx == limit) {
            // stack에 쌓인 숫자들로 정수 만들기
            int num = 0;
            for (int d : stack) {
                num = num * 10 + d;
            }
            if (isPrime(num)) {
                foundPrimes.add(num);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            // 선택
            visited[i] = true;
            stack.add(nums[i]);

            // 다음
            dfs(idx + 1, limit);

            // 백트래킹
            stack.remove(stack.size() - 1);
            visited[i] = false;
        }
    }

   static boolean isPrime(int num){
        if (num < 2) return false;
        int cnt = 0;
        for (int i = 2; i < num; i ++){
            if (cnt > 0) return false;
            if (num % i == 0) cnt ++;
        }
        return true;
    }
}
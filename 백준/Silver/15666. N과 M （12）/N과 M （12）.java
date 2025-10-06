import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static StringBuilder sb;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        TreeSet<Integer> sets = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sets.add(Integer.parseInt(st.nextToken()));
        }

        nums = new int[sets.size()];
        int idx = 0;
        for (Integer num : sets) {
            nums[idx++] = num;
        }

        choice(0,0, m);

        System.out.println(sb);
    }

    static void choice(int idx, int depth, int m) {

        if (depth >= m) {
            for (Integer num : answer) sb = sb.append(num).append(" ");
            sb = sb.append("\n");
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            answer.add(nums[i]);
            choice(i,depth + 1, m);
            answer.remove(answer.size() - 1);
        }


    }
}

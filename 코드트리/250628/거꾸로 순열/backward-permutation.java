import java.util.*;

public class Main {
    static List<Integer> stack = new ArrayList<>();
    static List<List<Integer>> stacks = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.

        choice(0);

        for (List<Integer> result : stacks){
            for (int elem : result){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    static void choice(int cnt){
        if (cnt >= n) {
            stacks.add(new ArrayList<>(stack));
            return;
        }

        for (int i = n; i >= 1; i --){
            if (stack.contains(i)) continue;
            stack.add(i);
            choice(cnt + 1);
            stack.remove(stack.size()-1);
        }
            
    }
}
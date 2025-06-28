import java.util.Scanner;
import java.util.*;

public class Main {

    static List<List<Integer>> stacks ;
    static List<Integer> stack ;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
                
        stack = new ArrayList<>();
        stacks = new ArrayList<>();
        choice(0);


        for (List<Integer> result : stacks){
            for (Integer elem : result){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    static void choice(int cnt){
        if (cnt >= n){
            stacks.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 1 ; i <= n; i ++){
            if (stack.contains(i)) continue;
            stack.add(i);
            choice(cnt + 1);
            stack.remove(stack.size()-1);
        }
    }
}
import java.util.Scanner;

public class Main {
    static long m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextLong();

        long a = sc.nextLong();
        long b = sc.nextLong();

        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (long i = a; i <= b; i ++){
            int result = binSearch(i);
            min = Math.min(min, result);
            max = Math.max(max, result);
        }

        System.out.println(min + " " + max);
    }

    public static int binSearch(long target){
        long left = 1;
        long right = m;

        int cnt = 0;
        while (left <= right){
            cnt ++;
            long mid = (right + left) / 2;
            if (mid == target){
                break;
            }else if (mid < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return cnt;
    }
}

// 4
//  1  ~  13 
//     7
//  1  ~   6
//     3
//  4  ~   6
//     5
//  4  ~  4 => FIND

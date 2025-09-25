import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Map<Integer,Integer> arrMap = new HashMap<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
            

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int result = binarySearch(arr,x);
            System.out.println(result);
        }

    }

    public static int binarySearch(int[] arr, inttarget){
        int len = arr.length;
        int left = 0, right = len - 1;
        
        int idx = -1; 

        while(left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                idx = mid;
                break;
            }

            if (arr[mid] < target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        
        return idx;
    }
}
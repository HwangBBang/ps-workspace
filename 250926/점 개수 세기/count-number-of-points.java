import java.util.*;
public class Main {
    static int zipSize;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> tree = new TreeSet<>();
        HashMap<Integer, Integer> mapper = new HashMap<>();
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
            tree.add(points[i]);
        }

    
        zipSize = 0;
        for (int each : tree){
            mapper.put(each, ++zipSize);
        }

        int[]prefixSum = new int[N+1];

        for (int i = 0; i < N; i++){            
            prefixSum[mapper.get(points[i])] ++;
        }
        for (int i = 1; i <= zipSize; i++){            
            prefixSum[i] += prefixSum[i-1];
        }


        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            int result;

            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            int decodeX = findLower(queries[i][0], tree, mapper);
            int decodeY = findUpper(queries[i][1], tree, mapper);

            if (decodeX > decodeY) result = 0;
            else result = getSum(decodeX, decodeY, prefixSum);
            
            System.out.println(result);
        }
        
    }

    static int getSum(int l, int r, int[]prefixSum){
        return prefixSum[r] - prefixSum[l-1];
    }

    static int findUpper(int x, TreeSet<Integer> tree, HashMap<Integer, Integer> mapper){
        Integer floor = tree.floor(x);
        if (floor != null)return mapper.get(floor);
        return 0;
    }

    static int findLower(int x, TreeSet<Integer> tree, HashMap<Integer, Integer> mapper){
        Integer ceil = tree.ceiling(x);
        if (ceil != null)return mapper.get(ceil);
        return zipSize+1 ;
    }
}
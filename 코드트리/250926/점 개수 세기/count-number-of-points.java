import java.util.*;
import java.io.*;


public class Main {
    static int zipSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        TreeSet<Integer> tree = new TreeSet<>();
        HashMap<Integer, Integer> mapper = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] points = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
            tree.add(points[i]);
        }
        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
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


        for (int i = 0; i < Q; i++) {
            int result;
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
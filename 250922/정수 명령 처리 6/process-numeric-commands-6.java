import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            
            String cmd = st.nextToken(); 
            if (cmd.equals("push")){
                int num = Integer.parseInt(st.nextToken());    
                pq.add(num);

            }else{
                if (cmd.equals("size")){
                    System.out.println(pq.size());
                }
                else if (cmd.equals("empty")){
                    System.out.println(pq.isEmpty() ? 1 : 0);
                }
                else if (cmd.equals("pop")){
                    System.out.println(pq.poll());
                }
                else if (cmd.equals("top")){
                    System.out.println(pq.peek());
                }
            }
                

        }
        

    }
}
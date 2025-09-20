import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // Please write your code here.
        Map<Integer,Integer> map = new HashMap<>();
        
        sc.nextLine();
        for (int i = 0; i < n; i ++){
            String oneLine = sc.nextLine();
            String[] splited = oneLine.split(" ");
            
            String cmd = splited[0];
            int key = Integer.parseInt(splited[1]);
            
            if (cmd.equals("add")){
                int value = Integer.parseInt(splited[2]);

                map.put(key, value);
            }
            else if (cmd.equals("remove")){
                map.remove(key);
            }
            else if (cmd.equals("find")){
                Integer result = map.get(key);
                if (result == null){
                    System.out.println("None");
                }
                else{
                    System.out.println(result);
                }
                  
                
            }
        }
    }
}

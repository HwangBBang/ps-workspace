import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        String data;
        Node prev;
        Node next; 
        public Node(String data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString(){
            String prevS = this.prev == null ? "(Null)" : this.prev.data;
            String nextS = this.next == null ? "(Null)" : this.next.data;
            
            return prevS + " " + this.data + " " + nextS;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
                 
        st = new StringTokenizer(br.readLine());
        String cur = st.nextToken();
        Node curNode = new Node (cur);

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            
            if (cmd == 1){
                String data = st.nextToken();
                Node newNode = new Node(data);
                
                // (새 노드) - (현재 노드)
                newNode.next = curNode;
                newNode.prev = curNode.prev;
                
                if (curNode.prev != null) {
                    curNode.prev.next = newNode;
                }
                curNode.prev = newNode;
            }
            else if (cmd == 2){
                String data = st.nextToken();
                Node newNode = new Node(data);

                // (현재 노드) - (새 노드)
                newNode.prev = curNode;
                newNode.next = curNode.next;
                
                if (curNode.next != null) {
                    curNode.next.prev = newNode;
                }
                curNode.next = newNode;

            }
            else if (cmd == 3){
                Node prevNode = curNode.prev;
                if (prevNode != null)curNode = prevNode;
            }
            else if (cmd == 4){
                Node nextNode = curNode.next;
                if (nextNode != null) curNode = nextNode;
            }
            System.out.println(curNode.toString());
        }
    }
}
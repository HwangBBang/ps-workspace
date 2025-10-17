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

        public void setPrev(String data){
            this.prev = new Node(data);
            this.prev.next = this;
        }
        public void setNext(String data){
            this.next = new Node(data);
            this.next.prev = this;
        }
        public void changeToPrev(){
            if (this.prev != null){
                this.next = this;
                this.data = this.prev.data;
            }
        }
        public void changeToNext(){
            if (this.next != null){
                this.prev = this;
                this.data = this.next.data;
            }
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
                curNode.setPrev(data);
                System.out.println(curNode.toString());
            }
            else if (cmd == 2){
                String data = st.nextToken();
                curNode.setNext(data);
                System.out.println(curNode.toString());
            }
            else if (cmd == 3){
                curNode.changeToPrev();
            }
            else if (cmd == 4){
                curNode.changeToNext();
            }
        }
    }
}
import java.util.*;
public class Main {

    static class Position{
        int x, y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Rectangle{
        int x1, y1, x2, y2;

        public Rectangle(int x1, int y1, int x2,int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    static int posSize = 0;

    public static void main(String[] args) {
        
        TreeSet<Integer> tree = new TreeSet<>();
        HashMap<Integer,Integer> map = new HashMap<>(); // real, zip
        
        int[][] prefixSum = new int[2500 + 2][2500 + 2];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        Position[] positions = new Position[n];
        Rectangle[] rectangles = new Rectangle[q];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            positions[i] = new Position(x,y);
            tree.add(x);tree.add(y);
        }

        

        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            rectangles[i] = new Rectangle(x1,y1,x2,y2);
        }
        
        posSize = 1;
        for (int pos : tree) map.put(pos, posSize++);
        
        for (int i = 0; i < n; i++){
            int x = positions[i].x;
            int y = positions[i].y;

            int zipX = map.get(x);
            int zipY = map.get(y);

            prefixSum[zipX][zipY] ++;
        }
         for(int i = 1; i <= posSize; i++){
            for(int j = 1; j <= posSize; j++){
                prefixSum[i][j] = 
                    prefixSum[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
         }
                

        for (Rectangle r : rectangles){
            int newX1 = getLowerDecode(r.x1,tree,map);
            int newY1 = getLowerDecode(r.y1,tree,map);
            int newX2 = getUpperDecode(r.x2,tree,map);
            int newY2 = getUpperDecode(r.y2,tree,map);

        if (newX1 > newX2 || newY1 > newY2) {  // 찾지 못한(겹치지 않는) 경우
            System.out.println(0);
            continue;
        }
            int result = getCnt(newX1,newY1,newX2,newY2,prefixSum);
            System.out.println(result);
        }

    }

    static int getCnt(int x1, int y1,
                      int x2,int y2, 
                      int[][] prefixSum){

        return prefixSum[x2][y2] 
        - prefixSum[x1-1 ][y2] 
        - prefixSum[x2][y1-1] 
        + prefixSum[x1 -1][y1 -1];
    }

    static int getLowerDecode(int x, TreeSet<Integer> tree, HashMap<Integer,Integer> map){
        Integer overX = tree.ceiling(x);
        if (overX != null){
            return map.get(overX);
        }
        return posSize;
    }

    static int getUpperDecode(int x, TreeSet<Integer> tree, HashMap<Integer,Integer> map){
        Integer underX = tree.floor(x);
        if (underX != null){
            return map.get(underX);
        }
        return 0;
    }
}

/*
1 000_ 000_000
*/
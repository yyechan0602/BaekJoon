

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {
    static class Pos {
        int r, c, dist;
        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static Queue<Pos> fire = new LinkedList<>();
    static Queue<Pos> user = new LinkedList<>();
    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    static String[][] board;
    static boolean[][] visFire;
    static boolean[][] visUser;
    static int n;
    static int m;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new String[n][m];
        visFire = new boolean[n][m];
        visUser = new boolean[n][m];

        for(int i = 0;i<n;i++){//입력받기
            String[] line = sc.next().split("");
            for(int j = 0;j<m;j++){
                board[i][j] = line[j];
                if(board[i][j].equals("J")){
                    user.add(new Pos(i,j,0));
                    visUser[i][j] = true;
                }else if(board[i][j].equals("F")){
                    fire.add(new Pos(i,j,0));
                    visFire[i][j] = true;
                }
            }
        }

        if (bfs())
            System.out.println(cnt);
        else
            System.out.println("IMPOSSIBLE");

    }
    public static boolean bfs(){
        while(!user.isEmpty()) {

            int size = fire.size();

            for (int i = 0; i < size; i++) {
                Pos pos = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nextR = pos.r + DR[d];
                    int nextC = pos.c + DC[d];


                    if(nextR<0 || nextR>= n||nextC <0|| nextC>=m){//BFS 조건
                        continue;
                    }
                    if(board[nextR][nextC].equals("#") || board[nextR][nextC].equals("F")) {
                        continue;
                    }
                    board[nextR][nextC] = "F";
                    fire.add(new Pos(nextR, nextC, pos.dist + 1));
                }
            }

            size = user.size();

            for (int i = 0; i < size; i++) {
                Pos pos = user.poll();

                for (int d = 0; d < 4; d++) {
                    int nextR = pos.r + DR[d];
                    int nextC = pos.c + DC[d];

                    if(nextR<0 || nextR>= n||nextC <0|| nextC>=m){//BFS 조건
                        cnt = pos.dist + 1;
                        return true;
                    }

                    if(board[nextR][nextC].equals("#") || board[nextR][nextC].equals("F")  ||board[nextR][nextC].equals("J")) continue;

                    board[nextR][nextC] = "J";
                    user.add(new Pos(nextR, nextC, pos.dist + 1));
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }

        return false;


    }
}
package BOJ.BFS;

import java.io.*;
import java.util.*;

public class N4179_F {
    static int R;
    static int C;
    static int[][] Maze;
    static Queue<Integer[]> jiPos;
    static Queue<Integer[]> firePos;
    static final int wall = -3;
    static final int fire = -2;
    static final int empty = -1;
    static final int jihoon = 0;
    static final int[] DC = {0, 1, 0, -1};
    static final int[] DR = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        jiPos = new LinkedList<>();
        firePos = new LinkedList<>();
        Maze = new int[R][C];

        String str;
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                switch (str.charAt(j)) {
                    case '#':
                        Maze[i][j] = wall;
                        break;
                    case '.':
                        Maze[i][j] = empty;
                        break;
                    case 'J':
                        Maze[i][j] = jihoon;
                        jiPos.add(new Integer[]{i, j});
                        break;
                    case 'F':
                        Maze[i][j] = fire;
                        firePos.add(new Integer[]{i, j});
                        break;
                }
            }
        }

        while (true) {
            if (!JihoonMove()) {
                return;
            }
            Fire();
            if(jiPos.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }

    static void Fire() {
        Integer[] cur;
        int nextRow;
        int nextCol;
        int size = firePos.size();
        for (int i = 0; i < size; i++) {
            cur = firePos.poll();
            for (int j = 0; j < DC.length; j++) {
                nextRow = cur[0] + DR[j];
                nextCol = cur[1] + DC[j];
                if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || Maze[nextRow][nextCol] == fire || Maze[nextRow][nextCol] == wall) {
                    continue;
                }
                firePos.add(new Integer[]{nextRow, nextCol});
                Maze[nextRow][nextCol] = fire;
            }
        }
    }

    static boolean JihoonMove() {
        Integer[] cur;
        int nextRow;
        int nextCol;
        int time;
        int size = jiPos.size();
        for (int i = 0; i < size; i++) {
            cur = jiPos.poll();
            time = Maze[cur[0]][cur[1]] + 1;
            for (int j = 0; j < DC.length; j++) {
                nextRow = cur[0] + DR[j];
                nextCol = cur[1] + DC[j];
                if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) {
                    System.out.println(Maze[cur[0]][cur[1]] + 1);
                    return false;
                } else if (Maze[nextRow][nextCol] == fire || Maze[nextRow][nextCol] == wall) {
                    continue;
                } else if(Maze[nextRow][nextCol] < time && Maze[nextRow][nextCol] >jihoon){
                    continue;
                }
                jiPos.add(new Integer[]{nextRow, nextCol});
                Maze[nextRow][nextCol] = Maze[cur[0]][cur[1]] + 1;
            }
        }
        return true;
    }
}

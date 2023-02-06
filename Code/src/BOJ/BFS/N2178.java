package BOJ.BFS;

import java.io.*;
import java.util.*;

public class N2178 {
    static final int start = 1;
    static final int end = -2;
    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];

        int num;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                num = Character.getNumericValue(str.charAt(j));
                if (num == 0) {
                    maze[i][j] = -1;
                } else {
                    maze[i][j] = 0;
                }
            }
        }
        maze[0][0] = start;
        maze[N - 1][M - 1] = end;

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0});
        Integer[] cur;
        int time;
        int nextRow;
        int nextCol;
        while (!q.isEmpty()) {
            cur = q.poll();
            time = maze[cur[0]][cur[1]] + 1;
            for (int i = 0; i < DC.length; i++) {
                nextRow = cur[0] + DR[i];
                nextCol = cur[1] + DC[i];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || maze[nextRow][nextCol] == -1) {
                    continue;
                }
                if (maze[nextRow][nextCol] == end) {
                    System.out.println(time);
                    return;
                }
                if (maze[nextRow][nextCol] == 0) {
                    q.add(new Integer[]{nextRow, nextCol});
                    maze[nextRow][nextCol] = time;
                }
            }
        }
    }
}

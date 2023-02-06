package BOJ;/*
package BFS;
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_sample {
    static class Pos {
        int r, c, dist;
        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    private static final char MAZE_START    = 'S';
    private static final char MAZE_BLOCK    = 'X';
    private static final char MAZE_END      = 'E';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int R = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        Queue<Pos> q = new LinkedList<>();  // BFS를 위한 큐
        boolean[][] visited = new boolean[R][C];  // 이미 방문한 곳을 다시 가지 않도록 방문체크

        // 미로 입력 받기
        char[][] maze = new char[R][C];      // 미로맵을 받아둘 배열
        for (int i = 0; i < R; i++) {
            String curRow = br.readLine();
            for (int j = 0; j < C; j++) {
                char curCol = curRow.charAt(j);
                if (curCol == MAZE_START) {
                    q.add(new Pos(i, j, 0));    // 시작위치를 발견하면 바로 큐에 넣음
                    visited[i][j] = true; // 시작위치를 큐에 넣었으므로 방문한 것으 로 체크
                }
                maze[i][j] = curRow.charAt(j);
            }
        }

        // BFS 진행
        while (!q.isEmpty()) {
            Pos cur = q.poll(); // 큐에서 하나를 뽑아냄
            for (int i = 0; i < DR.length; i++) {   // 인접한 칸으로 탐색 진행
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];
                int nextDist = cur.dist + 1;

                if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visited[nextR][nextC] || maze[nextR][nextC] == MAZE_BLOCK) {
                    continue; // 다음 탬색할 위치가 미로를 벗어난 위치이거나 이미 방문한 곳이거나 장애물인 경우 탐색에서 제외
                }

                if (maze[nextR][nextC] == MAZE_END) {   // 최종 목적지를 발견한 경우
                    System.out.println(nextDist);   // 거리를 출력하고,
                    return; // 그대로 종료하면 됨.
                }

                q.add(new Pos(nextR, nextC, nextDist)); // 큐에 다음 탐색할 곳을 넣음.
                visited[nextR][nextC] = true;   // 큐에 넣은 곳 방문체크
            }
        }

        System.out.println(-1); // 발견을 하지 못한 예외의 경우 -1을 출력.
    }
}

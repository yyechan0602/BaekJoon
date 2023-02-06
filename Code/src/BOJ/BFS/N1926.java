package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1926 {
    static boolean[][] drawPaper;

    static final int[] DR = {0, -1, 0, 1};
    static final int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        drawPaper = new boolean[n][m];

        Queue<Integer[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    drawPaper[i][j] = true;
                } else {
                    drawPaper[i][j] = false;
                }
            }
        }
        int maxArea = 0;
        int currentArea = 0;
        int paperCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (drawPaper[i][j]) {
                    drawPaper[i][j] = false;
                    q.add(new Integer[]{i, j});
                    currentArea = 1;
                    paperCount += 1;
                }
                while (!q.isEmpty()) {
                    Integer[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nextR = cur[0] + DR[k];
                        int nextC = cur[1] + DC[k];
                        if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m ||
                                !drawPaper[nextR][nextC]) {
                            continue;
                        }
                        drawPaper[nextR][nextC] = false;
                        q.add(new Integer[]{nextR, nextC});
                        currentArea += 1;
                    }
                }
                maxArea = Math.max(currentArea, maxArea);
            }
        }
        System.out.println(paperCount + " " + maxArea);
    }
}

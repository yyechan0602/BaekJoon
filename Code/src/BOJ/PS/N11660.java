package BOJ.PS;

import java.io.*;
import java.util.*;

public class N11660 {
    static int[][] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            numbers[i][0] = 0;
            numbers[0][i] = 0;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                MakePrefixSum(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            PrefixSum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static void MakePrefixSum(int x, int y, int value) {
        numbers[x][y] = numbers[x][y - 1] + numbers[x - 1][y] - numbers[x - 1][y - 1] + value;
    }

    static void PrefixSum(int x2, int y2, int x1, int y1) {
        int result = numbers[x1][y1] - numbers[x2 - 1][y1] - numbers[x1][y2 - 1] + numbers[x2 - 1][y2 - 1];
        System.out.println(result);
    }
}

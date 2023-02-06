package BOJ.Implements;

import java.io.*;
import java.util.StringJoiner;

public class N1913 {
    static int N;
    static int total;
    static int target;
    static int[][] snail;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        total = N * N;
        target = Integer.parseInt(br.readLine());

        snail = new int[N][N];
        TotalMake();
        FindSnail();
    }

    static void FindSnail() {
        int x = 0;
        int y = 0;
        StringJoiner sj;
        for (int i = 0; i < N; i++) {
            sj = new StringJoiner(" ");
            for (int j = 0; j < N; j++) {
                sj.add(Integer.toString(snail[i][j]));
                if (snail[i][j] == target) {
                    x = i + 1;
                    y = j + 1;
                }
            }
            System.out.println(sj);
        }
        System.out.println(x + " " + y);
    }

    static void TotalMake() {
        for (int i = 0; i < N / 2; i++) {
            MakeSnail(i, N - i - 1);
        }
        snail[N / 2][N / 2] = total;
    }

    static void MakeSnail(int min, int max) {
        for (int i = min; i <= max - 1; i++) {
            snail[i][min] = total--;
        }
        for (int i = min; i <= max - 1; i++) {
            snail[max][i] = total--;
        }
        for (int i = max; i >= min + 1; i--) {
            snail[i][max] = total--;
        }
        for (int i = max; i >= min + 1; i--) {
            snail[min][i] = total--;
        }
    }
}

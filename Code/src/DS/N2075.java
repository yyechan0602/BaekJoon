package DS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2075 {
    static int[][] table;
    static int[] tableIndex;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        table = new int[n + 1][n];
        tableIndex = new int[n];
        Arrays.fill(tableIndex, n);
        for (int i = 0; i < n; i++) {
            table[0][i] = -1200000000;
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = FindMax();
        }
        System.out.println(result);
    }

    public static int FindMax() {
        int flag = 0;
        int max = -1200000000;
        for (int i = 0; i < n; i++) {
            if (max < table[tableIndex[i]][i]) {
                flag = i;
                max = table[tableIndex[i]][i];
            }
        }
        tableIndex[flag] -= 1;
        return max;
    }
}

package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15486 {
    public static int[][] arr;
    public static int[] dp;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        arr = new int[target + 2][2];
        dp = new int[target + 2];

        Arrays.fill(dp, 0);

        StringTokenizer st;
        arr[0][0] = 0;
        arr[0][1] = 0;
        for (int i = 1; i < target + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < target + 2; i++) {
            MakeDP(i);
        }

        System.out.println(dp[target + 1]);
    }

    public static void MakeDP(int index) {
        dp[index] = Math.max(dp[index], dp[index - 1]);
        if (index + arr[index][0] <= target + 1) {
            dp[index + arr[index][0]] = Math.max(arr[index][1] + dp[index], dp[index + arr[index][0]]);
        }
    }
}
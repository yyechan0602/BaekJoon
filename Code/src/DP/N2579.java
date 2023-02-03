package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2579 {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());
        arr = new int[target];
        dp = new int[target];
        for (int i = 0; i < target; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        if (target > 1) {
            dp[1] = arr[1] + arr[0];
        }
        if (target > 2) {
            dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        }
        for (int i = 3; i < target; i++) {
            MakeMax(i);
        }

        System.out.println(dp[target - 1]);
    }

    public static void MakeMax(int index) {
        dp[index] = Math.max(dp[index - 3] + arr[index - 1], dp[index - 2]) + arr[index];
    }
}
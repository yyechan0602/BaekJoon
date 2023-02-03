package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2293_F {
    static int n;
    static int k;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 0; i < k; i++) {
            MakeDP(i);
        }
        System.out.println(dp[k]);
    }

    public static void MakeDP(int index) {
        for (int i : arr) {
            if (index + i <= k) {
                dp[index + i] += dp[index];
            }
        }
    }
}
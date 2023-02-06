package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11047 {
    public static int[] coins;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        coins = new int[count];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(MinCoins(target));
    }

    public static int MinCoins(int target) {
        int result = 0;
        for (int i = count - 1; i > -1; i--) {
            result += target / coins[i];
            target = target % coins[i];
        }
        return result;
    }
}
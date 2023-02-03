package Implements;

import java.io.*;
import java.util.StringTokenizer;

public class N2303 {
    public static int[] nums;
    private static int i;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        nums = new int[num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = NumberGame(st);
        }

        int max = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 >= max % 10) {
                max = nums[i];
                flag = i;
            }
        }
        System.out.println(flag + 1);
    }
    public static int NumberGame(StringTokenizer st) {
        int[] cards = new int[5];
        int index = 0;

        while (st.hasMoreTokens()) {
            cards[index++] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int current;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    current = cards[i] + cards[j] + cards[k];
                    if (current % 10 > max % 10) {
                        max = current;
                    } else if (current % 10 == max % 10 && current > max) {
                        max = current;
                    }
                }
            }
        }
        return max;
    }
}

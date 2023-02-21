package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1082 {
    static class money implements Comparable<money> {
        int money;
        int num;

        public money(int money, int num) {
            this.money = money;
            this.num = num;
        }

        @Override
        public int compareTo(money o) {
            if (this.money < o.money) {
                return -1;
            } else if (this.money == o.money) {
                if (this.num > o.num) {
                    return -1;
                }
            }
            return 1;
        }
    }

    static int N;
    static int M;
    static money[] Money;
    static int digit;
    static int min;
    static int minIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Money = new money[N];
        min = 60;
        minIndex = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Money[i] = new money(Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(Money);
        M = Integer.parseInt(br.readLine());
        FindMaxNum();
        System.out.println();
    }

    static void FindMaxNum() {
        StringBuilder sb = new StringBuilder();
        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (M - Money[0].money < 0) {
            System.out.println(0);
            return;
        }
        if (Money[0].num != 0) {
            if (M / Money[0].money > 0) {
                digit = M / Money[0].money;
            } else {
                digit = 1;
            }
        } else {
            if (M - Money[1].money >= 0 || (M - Money[1].money) / Money[0].money > 0) {
                digit = (M - Money[1].money) / Money[0].money + 1;
            }
        }
        int remain = M - digit * Money[0].money;
        for (int i = 0; i < digit; i++) {
            int max = -1;
            int maxIndex = -1;
            for (int j = 0; j < N; j++) {
                if (Money[j].num >= max && Money[j].money - Money[0].money <= remain) {
                    max = Money[j].num;
                    maxIndex = j;
                }
            }
            if (max != -1) {
                remain -= Money[maxIndex].money - Money[0].money;
                sb.append(Money[maxIndex].num);
            }
        }
        if (sb.length() != 0) {
            String str = sb.toString();
            if (str.charAt(0) == '0') {
                System.out.println(0);
            } else {
                System.out.println(sb);
            }
        } else {
            System.out.println(0);
        }
    }
}

package BOJ.Making;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2138 {
    static int[] bulb1;
    static int[] bulb2;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bulb1 = new int[N];
        bulb2 = new int[N];
        int result = 0;
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            bulb1[i] = Character.getNumericValue(str.charAt(i));
        }
        str = br.readLine();
        for (int i = 0; i < N; i++) {
            if (bulb1[i] == Character.getNumericValue(str.charAt(i))) {
                bulb1[i] = 0;
            } else {
                bulb1[i] = 1;
            }
        }
        bulb2 = bulb1.clone();

        System.out.println(result);
    }

    static void MakeFinal() {
        int result1;
        int result2;
        result1 = ChangeBulb(bulb1, true);
        result2 = ChangeBulb(bulb2, false);
        System.out.println(Math.min(result1, result2));
    }

    static int ChangeBulb(int[] bulb, boolean first) {
        for (int i = 0; i < N; i++) {

        }
        return 0;
    }

    static int change(int num) {
        if (num == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

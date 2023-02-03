package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N1463 {
    public static List<Integer> Mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        Mem = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1));
        int value;
        for (int i = 4; i < target + 1; i++) {
            Mem.add(TotalMakeToOne(i));
        }
        System.out.println(Mem.get(target));
        System.out.println(1);
    }

    static int TotalMakeToOne(int num) {
        return Math.min(Math.min(Mem.get(MakeToOne1(num)), Mem.get(MakeToOne2(num))), Mem.get(num - 1)) + 1;
    }

    static int MakeToOne1(int num) {
        if (num % 2 == 0) {
            return num / 2;
        }
        return num - 1;
    }

    static int MakeToOne2(int num) {
        if (num % 3 == 0) {
            return num / 3;
        }
        return num - 1;
    }
}

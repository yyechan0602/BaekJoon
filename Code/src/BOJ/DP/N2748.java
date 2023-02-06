package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2748 {
    public static long[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        fibo = new long[count+1];
        Arrays.fill(fibo, -1);

        fibo[0] = 0;
        if(count != 0) {
            fibo[1] = 1;
            for (int i = 2; i < count + 1; i++) {
                MakeFibo(i);
            }
        }
        System.out.println(fibo[count]);

    }
    public static void MakeFibo(int i){
        if(fibo[i]==-1) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }
}

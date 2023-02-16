package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] tc = new int[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                tc[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
            }
            int max = tc[0];
            int result = 1;
            for (int j = 0; j < N; j++) {

                if (tc[j] < max) {
                    max = tc[j];
                    result += 1;
                }
            }
            System.out.println(result);
        }
    }
}

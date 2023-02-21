package BOJ.DS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Long[]> stack = new Stack<>();

        long num = Long.parseLong(st.nextToken());
        while (num != 0) {
            long max = 0;
            stack.add(new Long[]{Long.parseLong(st.nextToken()), 0l});
            for (long i = 1; i < num; i++) {
                long value = Long.parseLong(st.nextToken());
                if (value > stack.peek()[0]) {
                    stack.add(new Long[]{value, i});
                } else if (value == stack.peek()[0]) {
                    //아무것도 안한다.
                } else {
                    Long[] arr = stack.pop();
                    max = Math.max(arr[0] * (i - arr[1]), max);
                    while (!stack.isEmpty() && value < stack.peek()[0]) {
                        arr = stack.pop();
                        max = Math.max(arr[0] * (i - arr[1]), max);
                    }
                    stack.add(new Long[]{value, arr[1]});
                }
            }
            while (!stack.isEmpty()) {
                Long[] arr = stack.pop();
                max = Math.max(arr[0] * (num - arr[1]), max);
            }
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            System.out.println(max);
        }
    }
}
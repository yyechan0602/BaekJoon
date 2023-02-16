package BOJ.Making;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class test {
    //오큰수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Stack<Integer> stack = new Stack<>();

        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < A; i++) {
            while (true) {
                if (stack.isEmpty())
                    break;

                if (arr[stack.peek()] >= arr[i])
                    break;

                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while (true) {
            if (stack.isEmpty())
                break;

            arr[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int s : arr)
            sb.append(s).append(" ");
        System.out.println(sb);
    }
}
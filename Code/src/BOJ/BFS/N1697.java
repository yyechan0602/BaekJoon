package BOJ.BFS;

import java.io.*;
import java.util.*;

public class N1697 {
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());

        int max = 100000;
        arr = new int[max + 1];
        Arrays.fill(arr, -1);
        Queue<Integer> q = new LinkedList<>();

        arr[subin] = 0;
        q.add(subin);

        if ( subin == sister){
            System.out.println(0);
            return;
        }
        int cur;
        int nextPos;
        int time = 0;
        while (!q.isEmpty()) {
            cur = q.poll();
            nextPos = cur - 1;
            time = arr[cur] + 1;
            if (nextPos >= 0 && arr[nextPos] == -1) {
                arr[nextPos] = time;
                q.add(nextPos);
                if (nextPos == sister) {
                    System.out.println(time);
                    break;
                }
            }
            nextPos = cur + 1;
            if (nextPos <= max && arr[nextPos] == -1) {
                arr[nextPos] = time;
                q.add(nextPos);
                if (nextPos == sister) {
                    System.out.println(time);
                    break;
                }
            }
            nextPos = 2 * cur;
            if (nextPos <= max && arr[nextPos] == -1) {
                arr[nextPos] = time;
                q.add(nextPos);
                if (nextPos == sister) {
                    System.out.println(time);
                    break;
                }
            }
        }
    }
}
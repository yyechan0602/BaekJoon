package BOJ.DS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1966 {
    public static Queue<Integer> box;
    public static Queue<Integer> targetBox;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int target;
        int count;
        box = new LinkedList<>();
        targetBox = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            PrinterQueue(count, target, st);
            box.clear();
            targetBox.clear();
        }
    }

    public static void PrinterQueue(int count, int target, StringTokenizer st) {
        int num;
        int targetNum;
        int max = 0;
        int result = 0;
        for (int i = 0; i < count; i++) {
            num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            box.add(num);
            if(i == target) {
                targetBox.add(1);
            }else{
                targetBox.add(0);
            }
        }
        int totalCount;
        int currentCount = count;
        boolean flag = false;
        for (int i = max; i > -1; i--) {
            totalCount = currentCount;
            for (int j = 0; j < totalCount; j++) {
                num = box.poll();
                targetNum = targetBox.poll();

                if (num == i) {
                    currentCount -= 1;
                    result += 1;
                    if (targetNum == 1) {
                        System.out.println(result);
                        return;
                    }
                    flag = true;
                    break;
                } else {
                    box.offer(num);
                    targetBox.offer(targetNum);
                }
            }
            if(flag){
                flag = false;
                i++;
            }
        }
    }
}
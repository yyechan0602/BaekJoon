package BOJ.DS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N12764_F {
    static class computer {
        int index;
        int count;

        public computer(int index) {
            this.index = index;
            this.count = 1;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        computer[] deskTop = new computer[N];
        PriorityQueue<Integer[]> startQ = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                }
                return 1;
            }
        });
        PriorityQueue<Integer[]> endQ = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                }
                return 1;
            }
        });
        Queue<Integer[]> temQ = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            startQ.add(new Integer[]{Integer.parseInt(st.nextToken()), i});
            endQ.add(new Integer[]{Integer.parseInt(st.nextToken()), i});
        }
        int length = 0;

        for (int i = 0; i < N; i++) {
            Integer[] curStart = startQ.poll();
            Integer[] curEnd = endQ.peek();

            if (curStart[0] < curEnd[0]) {
                deskTop[length++] = new computer(curStart[1]);
            } else {
                curEnd = endQ.poll();
                int min = 1000002;
                int[] minIndex = new int[]{};
                int flag;
                boolean flag2 = false;
                while (curStart[0] >= curEnd[0]) {
                    flag = 0;
                    while (flag < length && deskTop[flag++].index != curEnd[1]) {
                    }
                    if (flag - 1 < min) {
                        if (flag2) {
                            temQ.add(new Integer[]{curEnd[0], curEnd[1]});
                        }
                        min = flag - 1;
                        minIndex = new int[]{curEnd[0], curEnd[1], flag - 1};
                        flag2 = true;
                    } else {
                        temQ.add(curEnd);
                    }
                    curEnd = endQ.poll();
                }
                endQ.add(curEnd);

                while (!temQ.isEmpty()) {
                    endQ.add(temQ.poll());
                }

                deskTop[minIndex[2]].count += 1;
                deskTop[minIndex[2]].index = curStart[1];
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(deskTop[j].index + " " + deskTop[j].count + " | ");
            }
            System.out.println(sb);
        }
        System.out.println(length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(deskTop[i].count + " ");
        }
        System.out.println(sb);
    }
}

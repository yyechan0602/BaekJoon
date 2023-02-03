package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N1931 {
    public static int count;
    public static int[][] conference;
    public static int[][] conference2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());

        conference = new int[count][2];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            conference[i][0] = Integer.parseInt(st.nextToken());
            conference[i][1] = Integer.parseInt(st.nextToken());
        }

        SortConference();
        System.out.println(MaxConference());
    }

    public static void SortConference() {
        Arrays.sort(conference, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
    }

    public static int MaxConference() {
        int result = 1;
        int time = conference[0][1];
        for (int i = 1; i < count; i++) {
            if (conference[i][0] >= time) {
                time = conference[i][1];
                result += 1;
            }
        }
        return result;
    }
}
package Implements;

import java.io.*;
import java.util.StringTokenizer;

public class N2469_F {
    public static int[][] ladder;
    public static int num;
    public static int hidenladder;
    public static String[] inPutParticipants;
    public static String[] resultInPutParticipants;
    public static String[] resultOutPutParticipants;
    public static String[] outPutParticipants;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String participant = st.nextToken();

        ladder = new int[height][num];
        inPutParticipants = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, num).split("");
        resultInPutParticipants = new String[num];
        outPutParticipants = participant.split("");
        resultOutPutParticipants = new String[num];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine(), "");
            MakeLadder(i, "*" + st.nextToken() + "*");
        }

        for (int i = 0; i < num; i++) {
            MiddleParticipants(i, false, height);
            MiddleParticipants(i, true, height);
        }

        System.out.println(1);
    }

    public static void MakeLadder(int height, String ladders) {
        String[] arrayladder = ladders.split("");
        if (arrayladder[1].equals("?")) {
            hidenladder = height;
        }
        for (int i = 0; i < num; i++) {

            if (arrayladder[i].equals("-")) {
                ladder[height][i] = -1;
            } else if (arrayladder[i + 1].equals("-")) {
                ladder[height][i] = 1;
            } else {
                ladder[height][i] = 0;
            }
        }
    }

    public static void MiddleParticipants(int index, boolean isUp, int height) {
        if (!isUp) {
            String alpha = inPutParticipants[index];
            for (int i = 0; i < hidenladder; i++) {
                index += ladder[i][index];
            }
            resultInPutParticipants[index] = alpha;
        } else {
            String alpha = inPutParticipants[index];
            for (int i = height - 1; i > hidenladder; i--) {
                index += ladder[i][index];
            }
            resultOutPutParticipants[index] = alpha;
        }
    }
}

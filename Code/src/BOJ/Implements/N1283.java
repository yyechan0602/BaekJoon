package BOJ.Implements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1283 {
    public static List<String> hotkeys;
    public static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        hotkeys = new ArrayList<String>();

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            MakeHotkey(st);
        }

        System.out.println(result.subSequence(0, result.length() - 1));
    }

    public static void MakeHotkey(StringTokenizer st) {
        String option = "";
        while (st.hasMoreTokens()) {
            option += st.nextToken();
            if (st.hasMoreTokens()) {
                option += " ";
            }
        }
        boolean flag = true;
        boolean skip = false;
        int pos = -1;
        for (String word : option.split("")) {
            if (!skip) {
                pos += 1;
                if (flag) {
                    flag = false;
                    if (!hotkeys.contains(word.toUpperCase())) {
                        hotkeys.add(word.toUpperCase());
                        skip = true;
                    }
                }
                if (word.equals(" ")) {
                    flag = true;
                }
            }
        }
        if (!skip) {
            pos = -1;
        }

        for (String word : option.split("")) {
            if (!skip) {
                pos += 1;
                if (!word.equals(" ")) {
                    if (!hotkeys.contains(word.toUpperCase())) {
                        hotkeys.add(word.toUpperCase());
                        skip = true;
                    }
                }
            }
        }
        if (skip) {
            InsertOption(option, pos);
        } else {
            InsertOption(option, -10);
        }
    }

    public static void InsertOption(String option, int pos) {
        if (pos != -10) {
            StringBuffer sb = new StringBuffer();
            sb.append(option);
            sb.insert(pos + 1, "]");
            sb.insert(pos, "[");

            result += sb + "\n";
        } else {
            result += option + "\n";
        }
    }

    public static class N1913_F {
        public static void main(String[] args) {

        }
    }/*
        public static int[][] graph;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            InitalGraph(N);



        }

        public static void MakeGraph(int N, int num) {
            int center = N / 2 + 1;
            int[] current = {center, center};

            graph[center][center] = 1;
            graph[center][center + 1] = 2;
            Vector[graph]
            for (int i = 1; i < N * N + 1; i++) {
                Vector(i)
            }
        }

        public static int[] Vector(int[] a, int[] b) {
            int[] result = new int[2];
            result[0] = a[0] - b[0];
            result[1] = a[1] - b[1];
            return result;
        }

        public static int[] NextPos(int[] current, int[] vector) {
            if (vector[1] == 1) {

                graph[current[1]][current[1]] = -1;
            }
        }

        public static void InitalGraph(int N) {
            graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; i < N; i++) {
                    graph[i][j] = -1;
                }
            }
        }
        public static boolean IsExist(){
            boolean result = false;


            return result;
        }
    }
    */
}

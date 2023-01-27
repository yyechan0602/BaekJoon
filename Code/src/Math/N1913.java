/*
package Math;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class n1913 {
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
        result = false;


        return result;
    }
}*/

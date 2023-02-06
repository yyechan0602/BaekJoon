package BOJ.Implements;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14719 {
    public static boolean[][] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

/*        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        MakeBlocks(height, width);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < width; i++) {
            FillBlocks(i, Integer.parseInt(st.nextToken()));
        }
        Show();

        for (int i = 0; i < width; i++) {
            System.out.println(Flow(i, width));
        }*/

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        block = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(block[i], false);
        }

        st = new StringTokenizer(br.readLine());
        int result = 0;

        FillBlock(height, width, st);
        for (int i = 0; i < height; i++) {
            result += IsFlow(i, width);
        }
        System.out.println(result);
    }

    public static void FillBlock(int height, int width, StringTokenizer st) {
        int flag = 0;
        for (int w = 0; w < width; w++) {
            int num = Integer.parseInt(st.nextToken());
            for (int h = height - 1; h > height - num - 1; h--) {
                block[h][w] = true;
            }
        }
    }

    public static int IsFlow(int height, int width) {
        boolean isblock = false;
        int count = 0;
        int finalCount=0;
        for (int i = 0; i < width; i++) {
            if (block[height][i]) {
                isblock = true;
                finalCount += count;
                count = 0;
            } else{
                if (isblock) {
                    count += 1;
                }
            }
        }
        return finalCount;
    }



/*
    public static void MakeBlocks(int height, int weight) {
        block = new boolean[height][weight];
        for (int i = 0; i < block.length; i++) {
            Arrays.fill(block[i], false);
        }
    }

    public static void FillBlocks(int index, int height) {
        for (int i = 0; i < height; i++) {
            block[index][i] = true;
        }
    }

    public static void Show() {
        for (int i = block[0].length - 1; i > -1; i--) {
            for (int j = 0; j < block.length; j++) {
                System.out.print(block[j][i] + "\t");
            }
            System.out.println("");
        }
    }

    public static int Flow(int index, int width) {
        boolean isBlock = false;
        int FinalCount = 0;
        int Count = 0;
        for (int i = 0; i < width; i++) {
            if (block[i][index]) {
                isBlock = true;
                FinalCount += Count;
            } else {
                if (isBlock) {
                    Count += 1;
                }
            }
        }
        return FinalCount;
    }*/
}

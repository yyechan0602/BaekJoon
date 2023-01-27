package Math;
import java.io.*;
import java.util.StringTokenizer;

public class N2563 {
    public static boolean[][] paper = new boolean[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int flag = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                paper[i][j] = false;
            }
        }
        String[] str;
        for (int i = 0; i < flag; i++) {
            st = new StringTokenizer(br.readLine());
            Confetti(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(paper[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void Confetti(int x, int y){
        for (int i = x; i < x+10; i++) {
            for (int j = y; j < y+10; j++) {
                paper[i][j] = true;
            }
        }
    }
}

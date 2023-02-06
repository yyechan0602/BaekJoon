package BOJ.Implements;

import java.io.*;
import java.util.StringTokenizer;

public class N14891_F {
    public static String[] gear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        gear = new String[4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            gear[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            Rotate(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }
        System.out.println(1);
    }

    public static void Rotate(int num, int dir) {
        Counter(num, dir);

    }

    public static void RightCascade(int num, int dir) {
        if (gear[num].charAt(2) != gear[num + 1].charAt(6)) {
            
        }
    }

    public static void Counter(int num, int dir) {
        StringBuilder sb = new StringBuilder();
        sb.append(gear[num]);
        if (dir == 1) {
            gear[num] = sb.append(sb.substring(0, 7)).toString();
        } else if (dir == -1) {
            gear[num] = sb.append(sb.substring(0, 1)).toString();
        }
    }
}

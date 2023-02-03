package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1940 {
    static int[] material;
    static int count;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        material = new int[count];
        for (int i = 0; i < count; i++) {
            material[i] = Integer.parseInt(st.nextToken());
        }
        MakeArmor();
    }

    public static void MakeArmor() {
        int result = 0;
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (material[i] + material[j] == target) {
                    result += 1;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}

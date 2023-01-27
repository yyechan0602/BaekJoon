package Math;
import java.io.*;
import java.util.StringTokenizer;

public class N2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = getInt(Integer.parseInt(st.nextToken()));
        System.out.println(result);
        bw.write(1);
        bw.newLine();
        bw.flush();
        bw.close();
    }

    public static int getInt(int FirstNum) {
        int result, finalResult, finalNum, num1, num2, flag;
        finalResult = 0;
        finalNum = 0;
        for (int SecondNum = 1; SecondNum < FirstNum; SecondNum++) {
            result = 0;
            num1 = FirstNum - SecondNum;
            num2 = SecondNum - num1;

            while (num1 >= 0) {
                result += 1;
                flag = num1;
                num1 = num2;
                num2 = flag- num2;
            }
            if (finalResult < result) {
                finalResult = result;
                finalNum = SecondNum;
            }
        }
        System.out.println(finalNum);
        return finalResult;
    }
}

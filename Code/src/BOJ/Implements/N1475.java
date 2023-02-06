package BOJ.Implements;

import java.io.*;
import java.util.StringTokenizer;

public class N1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());


        House(st.nextToken());
    }
    public static void House(String num){
        int[] memory = new int[10];
        for ( int i=0; i<10; i++) {
            memory[i] = 0;
        }

        String[] nums = num.split("");
        for ( String i : nums) {
            memory[Integer.parseInt(i)] += 1;
        }
        memory[6] = ((memory[6] + memory[9]) +1 )/2;

        int result = 0;
        for ( int i=0; i<9; i++) {
            if(result < memory[i]){
                result = memory[i];
            }
        }
        System.out.println(result);
    }

/*    public static void House(int num) {
        int result = 0;
        String snum = Integer.toString(num);
        snum.replace("6","9");
        char[] chars = snum.toCharArray();

        char flag = chars[0];
        Arrays.sort(chars);

        int counts = 0;
        int finalNum =0;
        int finalCounts = 0;
        for (int i=0; i< chars.length; i++){
            if(flag==chars[i]){
                counts += 1;
                //System.out.println("counst: " + counts);
            }else {
                if(counts > finalCounts) {
                    finalCounts = counts;
                    finalNum = flag;
                }
                counts = 0;
                flag = chars[i];
            }
            if(i == chars.length-1){
                if(counts > finalCounts) {
                    finalCounts = counts;
                    finalNum = flag;
                }
            }
        }
        System.out.println(finalCounts);
        //System.out.println(finalNum);
    }*/
}

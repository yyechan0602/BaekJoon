package BOJ.DS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N9012 {
    static Stack<String> ps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ps = new Stack<String>();

        for (int i = 0; i < num; i++) {
            ShowPS(br);
            ps.clear();
        }
    }
    public static void ShowPS(BufferedReader br) throws IOException{
        for (String str : br.readLine().split("")) {
            if (str.equals("(")) {
                ps.push(str);
            } else {
                if (ps.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    ps.pop();
                }
            }
        }
        if (ps.isEmpty()) {
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
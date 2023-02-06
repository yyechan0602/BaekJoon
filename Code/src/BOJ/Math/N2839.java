package BOJ.Math;
import java.util.Scanner;

public class N2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int suger = sc.nextInt();

        System.out.println(bag(suger));
    }
    public static int bag(int suger){
        int result = 0;

        while (suger >2) {
            if(suger%5 == 0) {
                result += suger/5;
                suger = 0;
                break;
            }
            suger = suger - 3;
            result += 1;
        }
        if (suger != 0) {return -1;}
        return result;
    }
}

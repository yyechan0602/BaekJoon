package Programmers.Making;

public class test {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        int answer = 0;

        String[] arr1 = new String[]{"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i=0;i<10;i++){
            s = s.replaceAll(arr1[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}

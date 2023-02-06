package BOJ.Implements;

import java.io.*;
import java.util.StringTokenizer;
public class N8979_Par {
    static class country {
        int name;
        int gold;
        int silver;
        int bronze;
    }
    public static country[] countries;
    public static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        countries = new country[num];
        int target = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            MakeRank(i, st);
        }
        ShowRank(GetIndex(target));

    }

    public static void MakeRank(int index, StringTokenizer st) {
        countries[index] = new country();
        countries[index].name = Integer.parseInt(st.nextToken());
        countries[index].gold = Integer.parseInt(st.nextToken());
        countries[index].silver = Integer.parseInt(st.nextToken());
        countries[index].bronze = Integer.parseInt(st.nextToken());
    }
    public static int GetIndex(int name){
        for (int i = 0; i < num; i++) {
            if(countries[i].name == name){
                return i;
            }
        }
        return -1;
    }

    public static void ShowRank(int index) {
        int result = num + 1;
        for (int i = 0; i < num; i++) {
            result += CompareRank(index, i);
        }
        System.out.println(result);
    }

    public static int CompareRank(int target, int index) {
        if (countries[target].gold > countries[index].gold) {
            return -1;
        } else if (countries[target].gold < countries[index].gold) {
            return 0;
        } else{
            if (countries[target].silver > countries[index].silver) {
                return -1;
            } else if (countries[target].silver < countries[index].silver) {
                return 0;
            } else{
                if (countries[target].bronze > countries[index].bronze) {
                    return -1;
                } else {
                    return -1;
                }
            }
        }
    }
}

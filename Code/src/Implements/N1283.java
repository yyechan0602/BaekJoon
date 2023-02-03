package Implements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1283 {
    public static List<String> hotkeys;
    public static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        hotkeys = new ArrayList<String>();

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            MakeHotkey(st);
        }

        System.out.println(result.subSequence(0, result.length() - 1));
    }

    public static void MakeHotkey(StringTokenizer st) {
        String option = "";
        while (st.hasMoreTokens()) {
            option += st.nextToken();
            if (st.hasMoreTokens()) {
                option += " ";
            }
        }
        boolean flag = true;
        boolean skip = false;
        int pos = -1;
        for (String word : option.split("")) {
            if (!skip) {
                pos += 1;
                if (flag) {
                    flag = false;
                    if (!hotkeys.contains(word.toUpperCase())) {
                        hotkeys.add(word.toUpperCase());
                        skip = true;
                    }
                }
                if (word.equals(" ")) {
                    flag = true;
                }
            }
        }
        if (!skip) {
            pos = -1;
        }

        for (String word : option.split("")) {
            if (!skip) {
                pos += 1;
                if (!word.equals(" ")) {
                    if (!hotkeys.contains(word.toUpperCase())) {
                        hotkeys.add(word.toUpperCase());
                        skip = true;
                    }
                }
            }
        }
        if (skip) {
            InsertOption(option, pos);
        } else {
            InsertOption(option, -10);
        }
    }

    public static void InsertOption(String option, int pos) {
        if (pos != -10) {
            StringBuffer sb = new StringBuffer();
            sb.append(option);
            sb.insert(pos + 1, "]");
            sb.insert(pos, "[");

            result += sb + "\n";
        } else {
            result += option + "\n";
        }
    }
}

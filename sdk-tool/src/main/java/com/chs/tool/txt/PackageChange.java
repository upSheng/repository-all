package com.chs.tool.txt;


import java.io.*;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/24 20:31
 */
public class PackageChange {

    private static final String PATH = "d:/package.txt";

    public static void change() {
        try {
            File file = new File(PATH);
            StringBuilder result = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {

                if (!s.isEmpty()) {
                    String trim = "'" + s.trim() + "',";
                    result.append(trim);
                }

            }
            br.close();
            String re = result.toString();

            if (re != null && re.trim().length() > 0) {
                re = "(" + re.substring(0, re.length() - 1) + ")";
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(re);
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        change();
    }
}

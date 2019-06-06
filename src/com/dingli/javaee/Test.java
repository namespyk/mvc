package com.dingli.javaee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("D:\\代码读取/ccc.txt");
        BufferedReader br = new BufferedReader(reader);
        String str = null;
        StringBuilder sbf = new StringBuilder();
        int num = 1;
        while((str = br.readLine()) != null){
            sbf.append("{").append("\n\tindex:").append(num).append(",");
            sbf.append("\n\tname:");
            sbf.append("\"").append(str.split("\\s")[0]).append("\"\n},");
            num++;
        }
        System.out.println(sbf);
    }
}

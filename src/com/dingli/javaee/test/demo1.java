package com.dingli.javaee.test;

public class demo1 {
    public static void main(String[] args) {
        int[] list = {15,200,3,47,63,78,94,10};
        double sum = 0;
        double ave;
        int max = 0;
        int min = 0;
        for(int i=0; i<8; i++){
            sum += list[i];
        }

        ave = sum/list.length;
        System.out.println(sum);
        System.out.println("平均值" + ave);

        for(int i=0; i<8; i++){
            if(list[i] > ave){
                max++;
            }
            if(list[i] < ave){
                min++;
            }
        }
        System.out.println("大于平均值个数：" + max);
        System.out.println("小于平均值个数：" + min);
    }
}

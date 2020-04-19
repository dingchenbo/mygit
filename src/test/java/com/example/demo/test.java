package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

//
public class test {
    //新建一个数组设置长度
    static int[] str=new int[10000];
    static Scanner input=new Scanner(System.in);
    //需要分解的数
    static int num;
    public static void main(String[] args) {
        System.out.println("请输入一个要分解的数:") ;
        num=input.nextInt();
        sumNumber(num,1,0);
    }
    private static void sumNumber(int n, int s, int x) {
        if(n>0) {
            //数组第一个数从1-n放在数组下标为0的地方，依次排列
            for(int i=s;i<=n;i++) {
                str[x]=i;
                System.out.println(Arrays.toString(str));
                //递归调用该方法
                sumNumber(n-i,i,x+1);
            }
            return;
        }
        //每一种可能结果完成后，根据x的长度遍历数组
        System.out.print(num+"="+str[0]);
        for(int i=1;i<x;i++) {
            System.out.print("+"+str[i]);
        }
        System.out.println();
    }
}

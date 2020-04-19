package com.example.demo;

public class FeiBo {

    public static void main(String[] args){
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.println(a);
        System.out.println(b);
        for (int i = 1;i<=1000;i++){
            c = a + b;
            a = b;
            b = c ;
            if (c>=1000){
                return;
            }
            System.out.println(c);
        }
    }
}

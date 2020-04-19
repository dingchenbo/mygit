package com.example.demo;

import java.util.Arrays;

public class MaoPao {
    public static void main(String[] args){
        int x[]={22,45,663,12,5,6,33,1};
        for(int i=1;i<x.length;i++){
            for (int j=0;j<x.length-1;j++){
                if (x[j]<x[j+1]){
                    int num = x[j];
                    x[j] = x[j+1];
                    x[j+1] = num;
                }
            }
        }
        System.out.println(Arrays.toString(x));
    }
}

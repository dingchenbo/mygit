package com.example.demo;

import java.util.*;

public class test2 {
        public static void main(String[] args){
           int[] x = {5,665,23,65,32};
           for (int i=1;i<x.length;i++){
               for (int j=0;j<x.length-i;j++){
                   if (x[j]>x[j+1]){
                       int num1 = x[j];
                       x[j] = x[j+1];
                       x[j+1]=num1;
                   }
               }
           }
           System.out.println(Arrays.toString(x));
        }
}

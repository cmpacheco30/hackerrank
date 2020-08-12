package com.hackerrank.practice;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

public class LeftRotation {

    public static void main(String[] args) {

        int[] case1 = {1, 2, 3, 4, 5};
        int[] exp1 = {5, 1, 2, 3, 4};
        Assert.check(Arrays.equals(exp1, rotLeft(case1, 4)));

        int[] case2 = {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
        int[] exp2 = {77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77};
        Assert.check(Arrays.equals(exp2, rotLeft(case2, 10)));

    }

    public static int[] rotLeft(int[] a, int d) {

        int size = a.length;
        int[] result = new int[size];

        int flag = d;
        for(int i = 0; i<size; i++){
            if(flag == size){
                flag = 0;
            }
            result[i] = a[flag];
            flag ++;
        }

        return result;

    }
}

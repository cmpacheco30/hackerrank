package com.hackerrank.practice;

import com.sun.tools.javac.util.Assert;

public class DS2DArray {

    public static void main(String[] args) {

        int[][] ex1 = {
                {1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0}
        };

        Assert.check(19 == hourglassSum(ex1));

        int[][] ex2 = {
                {-1, 1, -1, 0, 0, 0},
                {0 ,-1, 0, 0, 0, 0},
                {-1, -1, -1, 0, 0, 0},
                {0, -9, 2, -4, -4, 0},
                {-7, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        };

        Assert.check(0 == hourglassSum(ex2));

        int[][] ex3 = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 9, 2, -4, -4, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        };

        Assert.check(13 == hourglassSum(ex3));

    }

    // Complete the hourglassSum function below.
    private static int hourglassSum(int[][] arr) {

        int max = 0;
        boolean first = true;
        for(int k = 0 ; k < arr[0].length - 2; k++){
            for(int i = 0 ; i < arr.length - 2; i++){
                int sum = arr[k][i] + arr[k][i+1] + arr[k][i+2];
                sum += arr[k+1][i+1];
                sum += arr[k+2][i] + arr[k+2][i+1] + arr[k+2][i+2];

                if(first){
                    max = sum;
                    first = false;
                }else if (sum > max){
                    max = sum;
                }

            }

        }

        return max;

    }
}

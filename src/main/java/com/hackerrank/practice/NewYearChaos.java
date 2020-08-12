package com.hackerrank.practice;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

public class NewYearChaos {

    public static final String CHAOS = "Too chaotic";

    public static void main(String[] args) {

        int[] case1 = {2, 1, 5, 3, 4};
        Assert.check("3".equals(minimumBribes(case1)));

        int[] case2 = {2, 5, 1, 3, 4};
        Assert.check(CHAOS.equals(minimumBribes(case2)));

        int[] case3 = {5, 1, 2, 3, 7, 8, 6, 4};
        Assert.check(CHAOS.equals(minimumBribes(case3)));

        int[] case4 = {1, 2, 5, 3, 7, 8, 6, 4};
        Assert.check("7".equals(minimumBribes(case4)));
    }

    // Complete the minimumBribes function below.
    static String minimumBribes(int[] q) {
        int bribes = 0;

        int[] basic = new int[q.length];

        for(int j = 0; j< q.length; j++){
            basic[j] = j+1;
        }

        for(int i = 0; i< q.length; i++){
            if(q[i] > (i+3)){
                System.out.println(CHAOS);
                return CHAOS;
            } else if(q[i] != basic[i]){

                int where = -1;
                for(int j = i+1; j <= i+2; j++){
                    if(basic[j] == q[i]){
                        where = j ;
                        break;
                    }
                }

                bribes += moves(basic, q[i], i, where);
            }
        }


        System.out.println(bribes);

        return bribes + "";
    }

    private static int moves(int[] b, int value, int i, int where){
        int m = 1;

        int aux = b[where];
        b[where] = b[where-1];
        b[where-1] = aux;

        if(b[i] != value){
            m += moves(b, value, i, (where-1));
        }

        return m;
    }
}

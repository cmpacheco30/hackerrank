package com.hackerrank.practice;

import com.sun.tools.javac.util.Assert;

public class RepeatedString {

    public static void main(String[] args) {

        verify(7,repeatedString("aba", 10));
        verify(1000000000000l,repeatedString("a", 1000000000000l));

    }

    private static void verify(long expected, long result){
        Assert.check(expected == result);
    }


    // Complete the repeatedString function below.
    private static long repeatedString(String s, long n) {

        s = s.toLowerCase();
        long length = s.length();

        long repeat = n/length;
        long m = n%length;

        long as = getA(s);
        long result = as * repeat;

        for(int i = 0; i < m; i++){
            if(s.charAt(i) == 'a') result++;
        }
        return result ;

    }

    private static long getA(String v){
        long result = 0;
        for(int i = 0; i < v.length(); i++)
            if(v.charAt(i) == 'a') result++;

        return result;
    }


}

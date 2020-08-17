package com.hackerrank.practice;

import com.sun.tools.javac.util.Assert;

public class AlternatingCharacters {

    public static void main(String[] args) {
        Assert.check(3 == alternatingCharacters("AAAA"));
        Assert.check(4 == alternatingCharacters("BBBBB"));
        Assert.check(0 == alternatingCharacters("ABABABAB"));
        Assert.check(0 == alternatingCharacters("BABABA"));
        Assert.check(4 == alternatingCharacters("AAABBB"));
    }

    static int alternatingCharacters(String s) {

        Character g = null;
        int r = 0;
        for(Character v : s.toCharArray()){
            if(g == null){
                g = v;
            }else{
                if (g == v){
                    r++;
                }else{
                    g = v;
                }
            }

        }

        return r;
    }
}

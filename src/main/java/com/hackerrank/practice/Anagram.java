package com.hackerrank.practice;

import com.sun.tools.javac.util.Assert;

import java.util.Map;
import java.util.TreeMap;

public class Anagram {

    public static void main(String[] args) {

        Assert.check(4 == makeAnagram("cde", "abc"));
        Assert.check(30 == makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));

    }

    static int makeAnagram(String a, String b) {

        Map<Character, Integer> mapA = new TreeMap<>();
        Map<Character, Integer> mapB = new TreeMap<>();

        int i = 0;
        Character ac = a.charAt(i);
        Character bc = b.charAt(i);
        while(ac != null || bc != null){

            i++;
            if(ac!=null){
                Integer v = mapA.get(ac);
                if(v == null) mapA.put(ac, 1);
                else mapA.put(ac, v + 1);

                if(a.length() > i){
                    ac = a.charAt(i);
                }else{
                    ac = null;
                }
            }

            if(bc!=null){
                Integer v = mapB.get(bc);
                if(v == null) mapB.put(bc, 1);
                else mapB.put(bc, v + 1);
                if(b.length() > i){
                    bc = b.charAt(i);
                }else{
                    bc = null;
                }
            }
        }

        Map<Character, Integer> bigger;
        Map<Character, Integer> smaller;

        if(mapA.size() > mapB.size()){
            bigger = mapA;
            smaller = mapB;
        }else{
            bigger = mapB;
            smaller = mapA;
        }

        int r = 0;
        for(Map.Entry<Character, Integer> e : bigger.entrySet()){
            Integer v = smaller.get(e.getKey());
            if(v != null){
                if(v != e.getValue()){
                    r += Math.abs(v - e.getValue());
                }
                smaller.remove(e.getKey());
            }else{
                r += e.getValue();
            }
        }

        for(Map.Entry<Character, Integer> e : smaller.entrySet()){
            r += e.getValue();
        }

        return r;
    }
}

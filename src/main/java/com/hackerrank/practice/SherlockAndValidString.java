package com.hackerrank.practice;

import com.sun.tools.javac.util.Assert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 *
 * For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .
 */

public class SherlockAndValidString {

    public static void main(String[] args) {

        String testCase = getTestFile("test1.txt");
        Assert.check("YES".equals(isValid(testCase)));
        Assert.check("NO".equals(isValid("aabbcd")));
        Assert.check("NO".equals(isValid("aabbccddeefghi")));
        Assert.check("YES".equals(isValid("aabbc")));
        Assert.check("NO".equals(isValid("aaaaabc")));
        Assert.check("NO".equals(isValid("aba")));
        Assert.check("YES".equals(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd")));

    }

    static String getTestFile(String file){
        try {
            URL resource = SherlockAndValidString.class.getClassLoader().getResource(file);
            FileInputStream fis = new FileInputStream(resource.getPath());

            BufferedReader br=new BufferedReader(new InputStreamReader(fis));

            StringBuilder builder=new StringBuilder();
            String output;
            while((output=br.readLine())!=null){
                //System.out.println(output);
                builder.append(output);
            }

            return builder.toString();
            //String stringTooLong = IOUtils.toString(fis, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    static String isValid(String s) {

        Map<Character, Integer> mapS = new HashMap<>();
        for(Character c : s.toCharArray()){
            Integer v = mapS.get(c);
            if(v == null){
                mapS.put(c, 1);
            }else{
                mapS.put(c, v + 1);
            }
        }

        Integer[] v = new Integer[mapS.size()];
        mapS.values().toArray(v);

        System.out.println(Arrays.toString(v));

        boolean fixed = false;
        int prevValue = 0;
        for(int i = 0; i < v.length - 1; i++){
            System.out.println("Check : " + v[i] + " - " + v[i+1]);

            if(v[i] == 0){
                v[i] = prevValue;
            }

            if(Math.subtractExact(v[i], v[i + 1])  != 0 ){
                System.out.println("\t there are some diffs : " + v[i] + " - " + v[i+1]);

                if(fixed){
                    return "NO";
                }

                if( i == 0 ){

                    if(v.length > 3){
                        int toValidate = v[i + 2];

                        if(v[i] == toValidate){
                            v[i + 1] = v[i + 1] - 1;
                        }else {
                            v[i] = v[i] - 1;
                        }

                        if(v[i] == 0 || v[i+1] == 0){
                            prevValue = toValidate;
                        }

                    }else{
                        return "NO";
                    }


                }else{

                    //if(Math.abs(v[i] - v[i + 1]) == 1 ){
                    // System.out.println("\t diff less than 1");

                    if(v[i] < v[i + 1]){
                        v[i + 1] = v[i + 1] - 1;
                    }else if(v[i + 1] == 1){
                        v[i + 1] = 0;
                        prevValue = v[i];
                    }else{
                        return "NO";
                    }

                    //}else{
                    //  return "NO";
                    //}
                }

                System.out.println("\tFixed : " + v[i] + " - " + v[i+1]);
                fixed = true;
                if(v[i] != v[i + 1] && v[i + 1] != 0 && v[i] != 0){
                    return "NO";
                }

            }
        }


        return "YES";
    }
}

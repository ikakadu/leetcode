package com.it.leetcode.explore;


import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:初级算法  字符串
 * @Author: wangruitao
 * @DATE: 2020/3/23
 **/
public class PrimaryString {

    public static void main(String[] args) {
        /*char[] s =new char[]{'h','e','l','l','o'};
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }*/

//        System.out.println(reverse(-123));
//        System.out.println(firstUniqChar("loveleetcode"));


        System.out.println(myAtoi("qq-1232qqq"));
    }

    //反转字符串  使用异或
    /**
     * @description:
     * @author: wangruitao
     *  a=a^b;
     *  b=b^a;
     *  a=a^b;
     *
     * a1=a^b
     * b=b^a1=b^a^b=a
     * //此时a1=a^b  b=a
     * a=a1^b=a^b^a=b
     *
     * @date: 2020/3/23
    **/

    public static void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0 ;i < n/2 ;i++){
            int j = n - 1 - i;


//            s[j] = (char) (s[j] ^s[i]);
//            s[i] = (char) (s[i] ^s[j]);
//            s[j] = (char) (s[j] ^s[i]);

            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }

    //整数反转
    public static int reverse(int x) {
        int res = 0;
        while (x!=0){
            int temp = x%10 + res *10;
            if ((temp-x%10)/10!=res){
                return 0;
            }
            res =temp;
            x /=10;
        }

        return res;
    }

    //字符串中的第一个唯一字符
    public static int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map  = new LinkedHashMap();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==null){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        /*Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            if(next.getValue()==1){
               Character key = next.getKey();
               for (int i = 0; i < chars.length; i++) {
                   if (key.equals(chars[i])){
                       return i;
                   }
               }
           }
        }*/
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }

    //有效的字母异位词
    /*public boolean isAnagram(String s, String t) {
        int i, x[26] = { 0 }, y[26] = { 0 };
        for (i = 0; s[i] != '\0'; i++)	x[s[i] - 'a']++;	//建立 s 的字符表 x
        for (i = 0; t[i] != '\0'; i++)	y[t[i] - 'a']++;	//建立 t 的字符表 y
        for (i = 0; i < 26; i++)							//比较两字符表是否相同
            if (x[i] != y[i])	return false;
        return true;
    }*/

    public static int myAtoi(String str) {
        int len = str.length();
        int index = 0;
        while (index < len){
            //去除前面的空格
            if (str.charAt(index) != ' '){
                break;
            }
            index++;
        }
        if (index == len){
            return 0;
        }

        int sign = 1;
        char firstChar = str.charAt(index);
        if (firstChar == '+'){
            index++;
            sign =1;
        }else if (firstChar == '-'){
            index++;
            sign = -1;
        }

        int res = 0;
        while (index < len){
            char currChar = str.charAt(index);
            if (currChar > '9' || currChar < '0'){
                break;
            }
            if (res>Integer.MAX_VALUE/10 || (res ==Integer.MAX_VALUE/10 && (currChar - '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }
            if (res<Integer.MIN_VALUE/10 || (res ==Integer.MIN_VALUE/10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))){
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;

    }







}

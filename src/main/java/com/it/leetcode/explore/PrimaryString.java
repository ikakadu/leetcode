package com.it.leetcode.explore;

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
        System.out.println(firstUniqChar("loveleetcode"));

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
}

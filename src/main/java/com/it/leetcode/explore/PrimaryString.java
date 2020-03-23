package com.it.leetcode.explore;

/**
 * @Description:初级算法  字符串
 * @Author: wangruitao
 * @DATE: 2020/3/23
 **/
public class PrimaryString {

    public static void main(String[] args) {
        char[] s =new char[]{'h','e','l','l','o'};
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
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
}

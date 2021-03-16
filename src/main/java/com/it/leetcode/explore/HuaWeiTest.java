package com.it.leetcode.explore;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class HuaWeiTest {
    public static void main(String[] args){
        quJinSiZhi();

    }
    private static void quJinSiZhi() {
        Scanner sc = new Scanner(System.in);
        float num = sc.nextFloat();
        int res;
        if (num*10%10>=5){
            System.out.println((int)num%10+1);
        }else {
            System.out.println((int)num%10);
        }

    }
    private static void daoZhuanShuZi() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while (i>0&&i/10>=0){
            System.out.print(i%10);
            i/=10;
        }
    }
    private static void zhiShuYinZi() {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        for (int i = 2; i <= num; i++) {
            while (num%i==0){
                System.out.print(i+" ");
                num = num/i;
            }
        }

    }

    private static void mergeTableRecord() {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        TreeMap<Integer,Integer> map = new TreeMap();
        for(int i=0;i<count;i++){
            int key = sc.nextInt();
            int value = sc.nextInt();

            if (map.get(key)==null){
                map.put( key,value);
            }else {
                map.put(key,value+map.get(key));
            }
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            System.out.println(integerIntegerEntry.getKey()+" "+integerIntegerEntry.getValue());
        }
    }

    public static void chu(String str){
        if(str.length()<8){
            System.out.println(append(str));
        }else if(str.length()==8){
            System.out.println(str);
        }else{
            for(int k=0;k<=(str.length()-1)/8;k++){
                String s = str.substring(8 * k, 8 * k + 8 > str.length()  ? str.length(): 8 * k + 8);
                System.out.println(append(s));
            }
        }
    }

    public static String append(String str){
        StringBuffer sb = new StringBuffer(str);
        for(int i=0;i<8-str.length();i++){
            sb.append("0");
        }
        return sb.toString();
    }

}

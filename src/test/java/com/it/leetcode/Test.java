package com.it.leetcode;

import com.it.leetcode.explore.MchtCenEnum;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import static com.it.leetcode.explore.MchtCenEnum.MchtInfEntityType;

/**
 * @Description: TODO
 * @Author: wangruitao
 * @DATE: 2019/12/18
 **/
public class Test {

    @org.junit.Test
    public void Test() {
        int firstChar= 'a';
        System.out.println(firstChar);
    }
    @org.junit.Test
    public void stackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer pop = stack.pop();
        System.out.println(pop);
    }
    @org.junit.Test
    public void xorTest() {
        int a = 7;
        int b = 14;
        int c = 14;
        System.out.println(a^b^c);
    }

    @org.junit.Test
    public void f(){
        String infEnterprise = MchtCenEnum.findNameByValue(MchtInfEntityType, "InfEnterprise").getName();
        System.out.println(infEnterprise);
    }

    @org.junit.Test
    public void move(){
            if (964632435 *10 > Integer.MAX_VALUE){
                System.out.println("max");
            }
            System.out.println(1<<31-1);
            System.out.println(-1<<31);
            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);

        }
        @org.junit.Test
        public void forMap(){
            LinkedHashMap<Character,Integer> map  = new LinkedHashMap();
            map.put('b',2);
            map.put('a',1);
            map.put('c',3);
            map.put('d',4);
            map.put('e',5);
            Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().getValue());
            }
        }
    }



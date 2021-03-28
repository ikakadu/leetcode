package com.it.leetcode.explore;

import java.util.*;
public class MainTest {


    public static void main(String[] args) {
        hashMapTest();
    }
	
    public static void hashMapTest() {
        Map<String,String> map = new HashMap<>();
        for (int i = 0;i < 500;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j < 500;j++) {
                        map.put(Thread.currentThread().getName() + "-" + j, j+"");
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
//            map.forEach((x,y) -> System.out.println(x));
            System.out.println(map.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

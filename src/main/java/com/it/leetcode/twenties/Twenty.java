package com.it.leetcode.twenties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangruitao
 * @DATE: 2019/11/22
 **/
public class Twenty {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int[] nums = new int[]{3,2,2,3};
        int res = removeElement(nums, 2);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        list.add(3);
//        list.add(0);
//        list.add(4);
//        list.add(2);
//        List<Integer> integers = removeElement1(list, 2);
//        System.out.println(integers);

    }
    //第27题   双指针法
    public static int removeElement(int[] nums, int val) {

        int len = nums.length;
        int  j = 0;
        for (int i = 0; i < len ; i++) {
            if(val != nums[i]){
                nums[j] = nums[i];
                j++;
            }
        }


        return j;
    }
    public static List<Integer> removeElement(List<Integer> list, int val) {
        int size = list.size();
        for (int i = size-1; i >=0 ; i--) {
            if(val==list.get(i)){
                list.remove(i);
            }
        }
       return list;
    }
    //错误示范
    public static List<Integer> removeElement1(List<Integer> list, int val) {
        int size = list.size();
        for (int i = 0; i <size-1 ; i++) {
            if(val==list.get(i)){
                list.remove(i);
            }
        }
       return list;
    }

}

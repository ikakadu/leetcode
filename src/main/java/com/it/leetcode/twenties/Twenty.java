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
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
////        int[] nums = new int[]{3,2,2,3};
//        int res = removeElement(nums, 2);
//        System.out.println(res);
//        for (int i = 0; i < res; i++) {
//            System.out.print(nums[i] + " ");
//        }
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
        int[] nums = new int[]{1,2,3,4,5};
//        System.out.println(maxProfit(nums));
        System.out.println(maxProfit1(nums));
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

    //122 买卖股票的最佳时机 II
    public static int maxProfit(int[] prices){
        int flag = 0;//判断当前是否持有
        int profit = 0;
        int buyPrice = 0;
        int sellPrice = 0;
        if (prices.length<2) return 0;
        else if(prices.length==2){
            return prices[0]<prices[1]?prices[1]-prices[0]:0;
        }else {
            for (int i = 0; i < prices.length-1; i++) {
                if(prices[i]<prices[i+1]&&flag==0){
                    buyPrice = prices[i];
                    flag =1;
                }
                if(flag ==1&&i+3 <= prices.length&&prices[i]<prices[i+1]&&prices[i+1]>prices[i+2]){
                    sellPrice = prices[i+1];
                    profit = profit + (sellPrice - buyPrice);
                    flag =0;
                }
                if(flag ==1&&i+2 == prices.length&&prices[i]<prices[i+1]){
                    sellPrice = prices[i+1];
                    profit = profit + (sellPrice - buyPrice);
                    flag =0;
                }

            }
            return profit;
        }


    }
    //122 买卖股票的最佳时机 II   推荐算法 将所有的上升段加在一起，就是最大利润
    public static int maxProfit1(int[] prices){
        int profit =0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i]) {
                profit += (prices[i+1] - prices[i]);
            }
        }
        return profit;
    }

}

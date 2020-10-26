package com.it.leetcode.explore;



import java.util.*;

/**
 * @Description: 初级算法  数组
 * @Author: wangruitao
 * @DATE: 2019/11/22
 **/
public class PrimaryArray {

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
//        int[] nums = new int[]{1,2,3,4,5,6,7};
//        System.out.println(maxProfit(nums));
//        System.out.println(maxProfit1(nums));
//        rotate(nums,3);
//        boolean b = containsDuplicate1(nums);
//        System.out.println(b);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }

//        int[] nums1 = new int[]{1,2,2,1};
//        int[] nums2 = new int[]{2};
//        int[] intersect = intersect(nums1, nums2);
//        for (int i = 0; i < intersect.length; i++) {
//            System.out.print(intersect[i] +" ");
//        }

//        int i = singleNumber1(nums);
//        System.out.println(i);

//        int[] ints = plusOne1(new int[]{1,2,3,4});
//        int[] nums = new int[]{0,0,1,0,2};
//        moveZeroes1(nums);


//        int[] nums = new int[]{2, 7, 11, 15};
//        int[] ints = twoSum(nums, 9);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }

        rotate(null);

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
    //189.旋转数组  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length-1];
            for (int j = nums.length-1; j > 0 ; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = tmp;
        }
    }
    //217 存在重复元素
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;

       /* for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return !(nums.length == set.size());*/
    }

    //217 存在重复元素
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }

    //136 只出现一次的数字
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        if (nums.length==1) res = nums[0];
        for (int i = 0; i < nums.length; i+=2) {

            if (i<nums.length-1&&nums[i] != nums[i+1]){
                res = nums[i];
                break;
            }else {
                res = nums[nums.length-1];
            }
        }
        return res;
    }

    //136 只出现一次的数字 异或算法

    public static int singleNumber1(int[] nums) {
        int res = 0;
        for (int x:nums) {
            res ^= x;
        }
        return res;
    }

    //两个数组的交集 II
    public static int[] intersect(int[] nums1, int[] nums2) {
        int no = 1;
        int min = nums1.length>nums2.length?nums2.length:nums1.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]&&no<=min){
                    list.add(nums1[i]);
                    no++;
                    break;
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]){
                    set.add(nums1[i]);

                    break;
                }
            }
        }

        int[] res = new int[set.size()];
        int i=0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            res[i] = iterator.next();
            i++;
        }


        return res;

    }

    //66  加一
    public static int[] plusOne(int[] digits) {

        int carry = 0;
        for (int i = digits.length-1; i >=0; i--) {
            if(i==digits.length-1){
                carry = (digits[i]+1)/10;
                digits[i] = (digits[i]+1)%10;
            }else {
                int temp = digits[i];
                digits[i] = (temp+carry)%10;
                carry = (temp+carry)/10;
            }
        }
        if(carry==1) {
            int[] ints = new int[digits.length + 1];
            ints[0]=1;
            return ints;
        }
        return digits;
    }
    //66  加一   推荐
    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    //  移动零
    //思路：设置一个index，表示非0数的个数，循环遍历数组，
    // 如果不是0，将非0值移动到第index位置,然后index + 1
    //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
    public  static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(0 != nums[i]){
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] =0;
        }
    }

    public static void moveZeroes1(int[] nums){
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums[lastNonZeroFoundAt++], nums[cur]);
            }
        }

    }

    public static  void move(int[] nums,int beginIndex,int endIndex) {
        for (int i = beginIndex; i < endIndex-1; i++) {
            if(0==nums[i+1]);
            nums[i]  = nums[i]^nums[i+1];
            nums[i+1] = nums[i]^nums[i+1];
            nums[i] = nums[i]^nums[i+1];
        }
    }

    public static void swap(int x,int y){
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }

    //两数之和
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c = target - nums[i];
            if(map.containsKey(c)){
                return new int[]{i,map.get(c)};
            }
            map.put(nums[i],i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //旋转图像

    public static void rotate(int[][] matrix) {
        int[][] arr = {
                {1,2,3,10},
                {4,5,6,20},
                {7,8,9,30}
        };

        System.out.println(arr.length);
        System.out.println(arr[0].length);
        int[][] arr2 = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {

        }


    }



}

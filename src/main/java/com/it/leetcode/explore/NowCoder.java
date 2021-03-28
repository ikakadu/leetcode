package com.it.leetcode.explore;

import java.util.Scanner;
import java.util.Stack;

public class NowCoder {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode res = ReverseList3(l1);
        System.out.println(res);
    }

    //反转链表
    public static ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        ListNode root = new ListNode(0);
        ListNode cursor = root;


        while(!stack.isEmpty()){
            ListNode node  = stack.pop();
            cursor.next =node;
            cursor = node;//光标后移

            if (stack.isEmpty()){
                cursor.next =null;
                break;
            }
        }
        return root.next;
    }

    public static ListNode ReverseList2(ListNode head) {

        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }


    public static ListNode ReverseList3(ListNode head) {
        if (head == null)
            return null;

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        do {
            stack.push(temp);
            temp = temp.next;
        } while (temp != null);

        //关键在于这里，原来的头结点的next要置为空，否则导致遍历时无限循环
        head.next = null;

        ListNode root = stack.pop();
        ListNode node = root;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        return root;
    }

    //每k个翻转

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, temp;
        int len = 0;
        while (head != null) {
            len ++ ;
            head = head.next;
        }
        for (int i = 0; i < len / k; i ++ ) {
            for (int j = 1; j < k; j ++ ) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    //判断给定的链表中是否有环
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1==p2){
                return true;
            }
        }
        return false;
    }

    //气球游戏
    private static void extracted(int n,int m,int[] arr) {

        System.out.println("Hello World!");

        int N = 1000010, M = 2010;


        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();//子弹数目
//        int m = in.nextInt();//颜色数目
//        int[] arr = new int[n];
        int[] mp = new int[m+1];

        boolean flag = false;
        int res = n + 1;
        int colors = 0;
        int j = 0;//  j是前一个指针
        // i是后一个指针


//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }


        for (int i = 0; i < n; i++) {
            if (arr[i]>0 && mp[arr[i]]==0)
                colors++;
            mp[arr[i]]++;

            if (colors == m) {
                flag = true;
                while (arr[j] == 0 || mp[arr[j]] > 1) {
                    mp[arr[j]]--;
                    j++;
                }

                res = (i - j + 1 > res ? res : i - j + 1);
            }

        }
        if (flag){
            System.out.println("res:"+res);
        }else {
            System.out.println(-1);
        }
    }

}

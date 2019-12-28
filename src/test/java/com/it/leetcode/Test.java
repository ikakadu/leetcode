package com.it.leetcode;

import com.it.leetcode.explore.MchtCenEnum;

import static com.it.leetcode.explore.MchtCenEnum.MchtInfEntityType;

/**
 * @Description: TODO
 * @Author: wangruitao
 * @DATE: 2019/12/18
 **/
public class Test {

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
}

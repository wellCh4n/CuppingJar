package com.wellch4n.cuppingjar.test;

import com.wellch4n.cuppingjar.BaseBizUnit;

/**
 * @author wellCh4n
 * @description
 * @create 2020/06/11
 * 找到银弹，然后开枪
 */

public class BizUnitA extends BaseBizUnit {

    public void doBiz(String s1, String s2) {
        System.out.println("s1: " + s1 + "; s2: " + s2);
    }

    @Override
    public String getBizFunction() {
        return "doBiz";
    }
}

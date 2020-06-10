package com.wellch4n.cuppingjar.test;

import com.wellch4n.cuppingjar.BaseBizUnit;

/**
 * @author wellCh4n
 * @description
 * @create 2020/06/11
 * 找到银弹，然后开枪
 */

public class BizUnitB extends BaseBizUnit {

    public void doBizz(Long l1, Integer i1) {
        System.out.println("l1: " + l1 + "; i1:" + i1);
    }

    @Override
    public String getBizFunction() {
        return "doBizz";
    }
}

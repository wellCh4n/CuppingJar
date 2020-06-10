package com.wellch4n.cuppingjar.test;

import com.google.common.collect.Lists;
import com.wellch4n.cuppingjar.BaseBizUnit;
import com.wellch4n.cuppingjar.BizContext;
import com.wellch4n.cuppingjar.BizPoint;

import java.util.List;

/**
 * @author wellCh4n
 * @description
 * @create 2020/06/11
 * 找到银弹，然后开枪
 */

public class MainTest {
    public static void main(String[] args) {
        try {
            BizContext bizContext = new BizContext();

            String s1 = "s1";
            String s2 = "s2";
            bizContext.put("s1", s1);
            bizContext.put("s2", s2);

            List<Class<? extends BaseBizUnit>> bizUnits = Lists.newArrayList(BizUnitA.class, BizUnitB.class);

            BizPoint testPoint = new BizPoint(bizContext, bizUnits);
            testPoint.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

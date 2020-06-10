package com.wellch4n.cuppingjar;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import com.wellch4n.cuppingjar.exception.CuppingJarContextException;

import java.util.Map;

/**
 * @author wellCh4n
 * @description
 * @create 2020/06/11
 * 找到银弹，然后开枪
 */

public class BizContext {

    private final Map<String, Object> param;

    public BizContext() {
        this.param = Maps.newHashMap();
    }

    public void put(String name, Object obj) throws CuppingJarContextException {
        if (param.containsKey(name)) {
            throw new CuppingJarContextException();
        }
        param.put(name, obj);
    }

    public void put(Object obj) throws CuppingJarContextException {
        String name = getContextName(obj);
        put(name, obj);
    }

    public Object get(String name) {
        return param.get(name);
    }

    private String getContextName(Object obj) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, obj.getClass().getSimpleName());
    }

}

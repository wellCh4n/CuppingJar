package com.wellch4n.cuppingjar;

import com.wellch4n.cuppingjar.exception.CuppingJarUnitException;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author wellCh4n
 * @description
 * @create 2020/06/11
 * 找到银弹，然后开枪
 */

public class BizPoint {

    private final BizContext bizContext;

    private final List<Class<? extends BaseBizUnit>> bizUnits;

    public BizPoint(BizContext bizContext, List<Class<? extends BaseBizUnit>> bizUnits) {
        this.bizContext = bizContext;
        this.bizUnits = bizUnits;
    }

    public void run() {
        try {
            for (Class<? extends BaseBizUnit> baseBizUnitClazz : bizUnits) {
                BaseBizUnit baseBizUnit = baseBizUnitClazz.newInstance();
                Method bizMethod = getBizMethod(baseBizUnitClazz, baseBizUnit.getBizFunction());
                Object[] params = getMethodParams(bizMethod);
                bizMethod.invoke(baseBizUnit, params);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Method getBizMethod(Class<? extends BaseBizUnit> clazz, String methodName) throws CuppingJarUnitException {
        Optional<Method> methodOptional = Arrays.stream(clazz.getMethods())
                .filter(method -> method.getName().equals(methodName))
                .findFirst();
        if (!methodOptional.isPresent()) {
            throw new CuppingJarUnitException();
        }

        return methodOptional.get();
    }

    private Object[] getMethodParams(Method method) {
        return Arrays.stream(method.getParameters())
                .map(parameter -> bizContext.get(parameter.getName()))
                .toArray();
    }
}

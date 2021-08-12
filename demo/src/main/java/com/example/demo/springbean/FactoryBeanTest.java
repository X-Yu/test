package com.example.demo.springbean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName : FactoryBeanTest  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-05-06 15:25  //时间
 */
@Component
public class FactoryBeanTest implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new TestImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return TestI.class;
    }
}

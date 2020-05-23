package com.yajad.dubbo.invoker.impl;

import com.yajad.dubbo.config.ReferenceConfig;
import com.yajad.dubbo.config.RegistryConfig;
import junit.framework.TestCase;

/**
 * @author honggenxiang
 * @date 2020/5/23
 **/
public class OldDubboInvokerTest extends TestCase {

    public void test$invoke() {

        OldDubboInvoker oldDubboInvoker = new OldDubboInvoker();
        ReferenceConfig referenceConfig = new ReferenceConfig();
        RegistryConfig registryConfig = new RegistryConfig();
        referenceConfig.setRegistry(registryConfig);
        oldDubboInvoker.config(new ReferenceConfig());
        Object o = oldDubboInvoker.$invoke("", null, null);
    }
}
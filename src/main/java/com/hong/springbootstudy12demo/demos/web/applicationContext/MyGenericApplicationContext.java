package com.hong.springbootstudy12demo.demos.web.applicationContext;

import org.springframework.context.support.GenericApplicationContext;

public class MyGenericApplicationContext extends GenericApplicationContext {

    private Thread shutdownHook = null;

    @Override
    public void registerShutdownHook() {

        if(this.shutdownHook == null) {
            // no shutdown hook registered yet.
            this.shutdownHook = new Thread(SHUTDOWN_HOOK_THREAD_NAME) {

                @Override
                public void run() {
                    System.out.println("容器关闭了，该干啥干啥吧");
                }

            };
            Runtime.getRuntime().addShutdownHook(this.shutdownHook);
        }
    }
}

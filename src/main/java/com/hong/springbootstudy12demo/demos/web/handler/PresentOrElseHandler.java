package com.hong.springbootstudy12demo.demos.web.handler;

import java.util.function.Consumer;

@FunctionalInterface
public interface PresentOrElseHandler<T extends Object> {

    void presentOrElseHandler(Consumer<? super T> action, Runnable falseHandler);

}

package com.hong.springbootstudy12demo.demos.web.function;

import jdk.nashorn.internal.objects.annotations.Function;

@FunctionalInterface
public interface ThrowExceptionFunction {

    void throwMessage(String message);

}

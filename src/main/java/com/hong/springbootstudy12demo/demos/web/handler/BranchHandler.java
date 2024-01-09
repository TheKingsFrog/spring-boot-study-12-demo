package com.hong.springbootstudy12demo.demos.web.handler;

@FunctionalInterface
public interface BranchHandler {

    void trueOrFalseHandler(Runnable trueHandler, Runnable falseHandler);

}

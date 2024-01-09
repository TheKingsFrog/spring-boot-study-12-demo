package com.hong.springbootstudy12demo.demos.web.test.tool;

import com.hong.springbootstudy12demo.demos.web.function.AndOrFunction;
import com.hong.springbootstudy12demo.demos.web.function.DoSomethingFunction;
import com.hong.springbootstudy12demo.demos.web.function.ThrowExceptionFunction;
import com.hong.springbootstudy12demo.demos.web.handler.BranchHandler;
import com.hong.springbootstudy12demo.demos.web.handler.PresentOrElseHandler;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class HclUtils {

    public static ThrowExceptionFunction isTrue(Boolean b) {
        return (errMsg) -> {
            if(!b) {
                throw new RuntimeException(errMsg);
            }
        };
    }

    public static BranchHandler isTrueOrFalse(Boolean b) {
        return (trueHandler, falseHandler) -> {
            if(b) {
                trueHandler.run();
            } else {
                falseHandler.run();
            }
        };
    }

    public static PresentOrElseHandler<?> isPresent(String obj) {
        return ((action, falseHandler) -> {
            if(obj != null) {
                action.accept(obj);
            } else {
                falseHandler.run();
            }
        });
    }


    public static DoSomethingFunction doSomething(Boolean b) {
        return (errMsg) -> {
            if(!b) {
                System.out.println(errMsg);
            }
        };
    }

    public static AndOrFunction andOrExecute(int express) {
        return () -> {
            if(1 == express) {
                System.out.println("execute key = " + 1);



            } else if (0 == express) {

            }
        };
    }

}

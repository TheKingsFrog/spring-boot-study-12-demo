package com.hong.springbootstudy12demo.demos.web.test;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class ExpressionParserTest {

    /**
     * 获取字符串长度
     */
    @Test
    public void testExpressionParser() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'hello'.length");
        System.out.println(expression.getValue());
    }

    /**
     * 获取随机数
     */
    @Test
    public void testExpressionParser2() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("T(java.lang.Math) .random*100.0");
        System.out.println(expression.getValue());
    }

    /**
     * 拿到spring环境的信息
     */
    @Test
    public void testExpressionParser3() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("systemProperties['user'.region]");
        System.out.println(expression.getValue());
    }

}

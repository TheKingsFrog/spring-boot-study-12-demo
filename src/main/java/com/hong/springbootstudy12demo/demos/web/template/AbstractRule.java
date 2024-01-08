package com.hong.springbootstudy12demo.demos.web.template;

import com.hong.springbootstudy12demo.demos.web.RuleDTO;
import com.hong.springbootstudy12demo.demos.web.ruleinterface.BaseRule;

public abstract class AbstractRule implements BaseRule {

    protected <T> T convert(RuleDTO ruleDTO) {
        return (T) ruleDTO;
    }

    @Override
    public boolean execute(RuleDTO ruleDTO) {
        return executeRule(convert(ruleDTO));
    }

    protected <T> boolean executeRule(T t) {
        return true;
    }

}

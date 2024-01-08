package com.hong.springbootstudy12demo.demos.web.ruleinterface;

import com.hong.springbootstudy12demo.demos.web.RuleDTO;

/**
 * @author chenglong.hong@hand-china.com
 * @date 2024/01/08
 */
public interface BaseRule {

    boolean execute(RuleDTO ruleDTO);

}

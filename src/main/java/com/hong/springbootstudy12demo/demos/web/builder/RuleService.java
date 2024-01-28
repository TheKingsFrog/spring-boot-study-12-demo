package com.hong.springbootstudy12demo.demos.web.builder;

import com.hong.springbootstudy12demo.demos.web.RuleDTO;
import com.hong.springbootstudy12demo.demos.web.ruleinterface.BaseRule;
import org.junit.Rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleService {

    private Map<Integer, List<BaseRule>> hashMap = new HashMap<>();

    private static final int AND = 1;

    private static final int OR = 0;

    public static RuleService create() {
        return new RuleService();
    }

    public RuleService and(List<BaseRule> baseRules) {
        hashMap.put(AND, baseRules);
        return this;
    }

    public RuleService or(List<BaseRule> baseRules) {
        hashMap.put(OR, baseRules);
        return this;
    }

    public boolean execute(RuleDTO ruleDTO) {

        for (Map.Entry<Integer, List<BaseRule>> item : hashMap.entrySet()) {

            List<BaseRule> baseRules = item.getValue();

            switch (item.getKey()) {

                case AND:
                    // 如果是and关系，同步执行
                    System.out.println("execute key = " + 1);
                    if (!and(ruleDTO, baseRules)) {
                        return false;
                    }
                    break;
                case OR:
                    // 如果是or关系，并行执行
                    System.out.println("execute key = " + 0);
                    if (!or(ruleDTO, baseRules)) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        return true;

    }

    private boolean and(RuleDTO ruleDTO, List<BaseRule> baseRules) {

        if(!baseRules.stream().anyMatch(baseRule -> baseRule.execute(ruleDTO))) {
            // and关系匹配失败一次，返回 false
            return false;
        }

        return true;

    }

    private boolean or(RuleDTO ruleDTO, List<BaseRule> baseRules) {

        for (BaseRule baseRule : baseRules) {
            boolean execute = baseRule.execute(ruleDTO);
            if (execute) {
                // or 关系匹配到一个就返回 true
                return true;
            }
        }
        // or 关系一个都不匹配就返回false
        return false;

    }



}

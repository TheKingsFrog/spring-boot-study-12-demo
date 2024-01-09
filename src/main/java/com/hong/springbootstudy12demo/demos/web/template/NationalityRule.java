package com.hong.springbootstudy12demo.demos.web.template;

import com.hong.springbootstudy12demo.demos.web.NationalityRuleDTO;
import com.hong.springbootstudy12demo.demos.web.RuleDTO;

import static com.hong.springbootstudy12demo.demos.web.constants.RuleConstants.*;

public class NationalityRule extends AbstractRule {

    @Override
    protected <T> T convert(RuleDTO ruleDTO) {

        NationalityRuleDTO nationalityRuleDTO = new NationalityRuleDTO();

        if(ruleDTO.getAddress().startsWith(MATCH_ADDRESS_START)) {
            nationalityRuleDTO.setNationality(MATCH_NATIONALITY_START);
        }

        return (T) nationalityRuleDTO;

    }

    @Override
    protected <T> boolean executeRule(T t) {

        System.out.println("Nationality Ruke invoke!");

        NationalityRuleDTO nationalityRuleDTO = (NationalityRuleDTO) t;

        if(nationalityRuleDTO.getNationality().startsWith(MATCH_NATIONALITY_START)) {
            return true;
        }

        return false;

    }

}

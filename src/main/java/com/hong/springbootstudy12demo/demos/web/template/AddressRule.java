package com.hong.springbootstudy12demo.demos.web.template;

import com.hong.springbootstudy12demo.demos.web.RuleDTO;

import static com.hong.springbootstudy12demo.demos.web.constants.RuleConstants.*;


public class AddressRule extends AbstractRule {

    @Override
    public boolean execute(RuleDTO ruleDTO) {

        System.out.println("AddressRule invoke!");

        if(ruleDTO.getAddress() == null) {
            throw new RuntimeException("address null!");
        }

        if(ruleDTO.getAddress().startsWith(MATCH_ADDRESS_START)) {
            return true;
        }

        return false;

    }

}

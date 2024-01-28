package com.hong.springbootstudy12demo.demos.web.test;

import com.hong.springbootstudy12demo.demos.web.RuleDTO;
import com.hong.springbootstudy12demo.demos.web.builder.RuleService;
import com.hong.springbootstudy12demo.demos.web.template.AddressRule;
import com.hong.springbootstudy12demo.demos.web.template.NationalityRule;
import org.junit.Test;

import java.util.Arrays;

import static com.hong.springbootstudy12demo.demos.web.constants.RuleConstants.MATCH_ADDRESS_START;

public class RuleServiceTest {

    @Test
    public void execute() {
        // 规则执行器：
        // 优点：比较简单，每个规则可以独立，将规则，数据，执行器拆分出来，调用方法比较规整
        // 缺点：数据依赖公共传输对象 dto

        // 1.定义规则 init rule
        AddressRule addressRule = new AddressRule();
        NationalityRule nationalityRule = new NationalityRule();

        // 2.构建需要的数据 create dto
        RuleDTO ruleDTO = new RuleDTO();
        ruleDTO.setAddress("MATCH_ADDRESS_START_2");
        ruleDTO.setAge(10);

        // 3.通过以链式调用构建和执行 rule execute
        boolean execute = RuleService.create()
                .and(Arrays.asList(addressRule))
                .or(Arrays.asList(nationalityRule))
                .execute(ruleDTO);

        System.out.println("this student rule execute result :" + execute);

    }

}

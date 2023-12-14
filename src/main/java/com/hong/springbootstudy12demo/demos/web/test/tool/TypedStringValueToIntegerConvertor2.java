package com.hong.springbootstudy12demo.demos.web.test.tool;

import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class TypedStringValueToIntegerConvertor2 implements Converter<TypedStringValue, Integer> {


    @Override
    public Integer convert(TypedStringValue source) {
        return Integer.valueOf(Objects.requireNonNull(source.getValue()));
    }
}

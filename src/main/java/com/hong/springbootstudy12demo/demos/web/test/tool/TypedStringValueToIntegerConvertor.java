package com.hong.springbootstudy12demo.demos.web.test.tool;

import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

public class TypedStringValueToIntegerConvertor implements GenericConverter {


    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new GenericConverter.ConvertiblePair(TypedStringValue.class, Integer.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

         TypedStringValue typedStringValue = (TypedStringValue) source;

        return Integer.valueOf(typedStringValue.getValue());
    }
}

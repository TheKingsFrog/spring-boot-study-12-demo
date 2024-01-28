package com.hong.springbootstudy12demo.demos.web.designmodule.builder;

import com.hong.springbootstudy12demo.demos.web.designmodule.builder.Builder;

public class TextBuilder extends Builder {

    private StringBuffer stringBuffer = new StringBuffer();

    @Override
    public Builder buildTitile(String title) {
        stringBuffer.append("==========\n");
        stringBuffer.append("["+title+"]");
        stringBuffer.append("\n");
        return this;
    }

    @Override
    public Builder buildString(String string) {
        stringBuffer.append("^" + string + "\n");
        return this;
    }

    @Override
    public Builder buildItems(String[] items) {
        for (String item : items) {
            stringBuffer.append(item + "\n");
        }
        return this;
    }

    @Override
    public void close() {
        stringBuffer.append("==========");
    }

    public String getResult() {
        return stringBuffer.toString();
    }

}

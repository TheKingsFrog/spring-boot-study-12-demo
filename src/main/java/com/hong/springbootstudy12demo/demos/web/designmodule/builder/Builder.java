package com.hong.springbootstudy12demo.demos.web.designmodule.builder;

import com.sun.org.apache.xpath.internal.operations.Bool;

public abstract class Builder {

    private Boolean initialized = false;

    public Builder makeTitle(String s) {
        if(!initialized) {
            buildTitile(s);
            initialized = true;
        }
        return this;
    }
    public Builder makeString(String s) {
        if(initialized) {
            buildString(s);
        }
        return this;
    }
    public Builder makeItems(String[] s) {
        if(initialized) {
            buildItems(s);
        }
        return this;
    }

    protected abstract Builder buildTitile(String title);

    protected abstract Builder buildString(String string);

    protected abstract Builder buildItems(String[] items);

    public abstract void close();

}

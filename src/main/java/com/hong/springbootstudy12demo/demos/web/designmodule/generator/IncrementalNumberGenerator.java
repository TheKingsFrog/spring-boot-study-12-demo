package com.hong.springbootstudy12demo.demos.web.designmodule.generator;

public class IncrementalNumberGenerator extends NumberGenerator {

    private int start;

    private int end;

    private int upper;

    public IncrementalNumberGenerator(int start, int end, int upper) {
        this.start = start;
        this.end = end;
        this.upper = upper;
    }

    @Override
    public int getNumber() {
        return start;
    }

    @Override
    public void execute() {

        while (start <= end) {
            notifyObservers();
            start += upper;
        }

    }
}

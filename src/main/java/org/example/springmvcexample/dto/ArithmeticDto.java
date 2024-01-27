package org.example.springmvcexample.dto;

public class ArithmeticDto {
    private final double first;
    private final double second;
    private final String result;

    public ArithmeticDto(double first, double second, String result) {
        this.first = first;
        this.second = second;
        this.result = result;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public String getResult() {
        return result;
    }
}

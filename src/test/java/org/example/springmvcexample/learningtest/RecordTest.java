package org.example.springmvcexample.learningtest;

import org.junit.jupiter.api.Test;

record MyRecord(int num) {
    public MyRecord {
        if (num < 0) {
            throw new IllegalArgumentException("num must be positive");
        }
    }
}
public class RecordTest {
    @Test
    public void testRecord() {
        MyRecord myRecord = new MyRecord(-
                1);
        System.out.println(myRecord.num());
    }
}

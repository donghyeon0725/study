package com.studyall.study.jvm;

public class ReferenceClassTest {
    public static class ReferenceClass {
    }

    public static void main(String[] args) {
        ReferenceClassTest instance = new ReferenceClassTest();

        ReferenceClass refer = instance.refer();
        ReferenceClass referenceClass = new ReferenceClass();
    }

    public ReferenceClass refer() {
        ReferenceClass referenceClass = new ReferenceClass();
        return referenceClass;
    }
}

package com.studyall.study;

import java.nio.charset.StandardCharsets;

public class MethodReference {
    interface MakeString {
        String fromBytes(char[] chars);
    }

    interface Thing {
        void doing(String a, String b);
    }

    static class RealThing {

        public void doing(String a, String b) {
            System.out.println(a + " " + b);
        }

        public void other(String a) {

        }
    }

    public static void main(String[] args) {
        MakeString string = String::new;

        String data = "hello world";
        String result = string.fromBytes(data.toCharArray());

        System.out.println(result);

        RealThing realThing = new RealThing();
        Thing thing = realThing::doing;

        thing.doing("hello", "world");
    }
}

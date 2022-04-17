package com.studyall.study.equalsAndHashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapKeyTest {

    static class Key {
        private String key;

        public Key(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public Key setKey(String key) {
            this.key = key;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key1 = (Key) o;
            return Objects.equals(getKey(), key1.getKey());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getKey());
        }
    }

    public static void main(String[] args) {
        Map<Key, String> cache = new HashMap<>();

        Key key1 = new Key("key");
        Key key2 = new Key("key");

        cache.put(key1, "data");

        // key 2 로도 조회가 가능해야함
        System.out.println(cache.get(key2)); // data


        // 데이터 변경
        key1.setKey("new key");

        System.out.println(cache.get(key2)); // null
    }
}

package com.studyall.study.jacksonTest;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CustomObjectMapper {


    public String writeAsString(Object instance) throws IllegalAccessException {
        Field[] declaredFields = instance.getClass().getDeclaredFields();

        StringBuilder sb = new StringBuilder();

        sb.append("{");

        int fieldSize = declaredFields.length;
        int index = 0;

        for (Field field : declaredFields) {

            field.setAccessible(true);

            String value = getJsonValueOfField(field, instance);
            String key = getJsonKeyOfField(field);

            sb.append(key).append(":").append(value);

            if (++index != fieldSize) {
                sb.append(",");
            }
        }

        sb.append("}");

        return sb.toString();
    }

    private String getJsonValueOfField(Field field, Object instance) throws IllegalAccessException {
        Class<?> type = field.getType();

        if (type.isPrimitive()) {
            return String.valueOf(field.get(instance));
        } else {
            return String.format("%s%s%s", "\"", field.get(instance), "\"");
        }
    }

    public <T> T readValue(File file, Class<T> clazz) {
        Map<String, Object> map = convertJsonToMap(file);

        try {

            Constructor<T> constructor = clazz.getDeclaredConstructor();

            T t = constructor.newInstance();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {

                if (field.isAnnotationPresent(JsonIgnore.class)) continue;

                field.setAccessible(true);

                Class<?> type = field.getType();
                String key = field.getName();
                if (type.isPrimitive()) {
                    if (type.equals(int.class)) {
                        field.set(t, Integer.parseInt(map.get(key).toString()));
                    } else if (type.equals(double.class)) {
                        field.set(t, Double.parseDouble(map.get(key).toString()));
                    } else if (type.equals(float.class)) {
                        field.set(t, Float.parseFloat(map.get(key).toString()));
                    } else if (type.equals(short.class)) {
                        field.set(t, Short.parseShort(map.get(key).toString()));
                    } else if (type.equals(byte.class)) {
                        field.set(t, Byte.parseByte(map.get(key).toString()));
                    }
                } else {
                    field.set(t, field.getType().cast(map.get(field.getName())));
                }
            }

            return t;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getJsonKeyOfField(Field field) {
        return String.format("%s%s%s", "\"", field.getName(), "\"");
    }

    private Map<String, Object> convertJsonToMap(File file) {
        String text = readAllText(file);
        text = trim(text);

        Map<String, Object> map = new HashMap<>();

        String[] entryArr = text.split(",");

        for (String s : entryArr) {
            String[] v = s.split(":");
            map.put(v[0], v[1]);
        }
        return map;
    }

    private String trim(String text) {
        return text.replaceAll("[ {}\"]", "");
    }

    private String readAllText(File file) {
        StringBuilder sb = new StringBuilder();

        try (
            BufferedReader br = new BufferedReader(new FileReader(file));
        ) {
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}

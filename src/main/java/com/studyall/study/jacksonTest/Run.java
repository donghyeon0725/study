package com.studyall.study.jacksonTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        ObjectMapper objectMapper = new ObjectMapper();

        Pojo pojo = objectMapper.readValue(new File("data.json"), Pojo.class);

        System.out.println(pojo);

        System.out.println(objectMapper.writer().writeValueAsString(pojo));


        CustomObjectMapper customObjectMapper = new CustomObjectMapper();
        Pojo customPojo = customObjectMapper.readValue(new File("data.json"), Pojo.class);

        System.out.println(customPojo);

        System.out.println(customObjectMapper.writeAsString(customPojo));
    }
}

package com.studyall.study.debug;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final Calculator calculator;

    @GetMapping
    public String helloWorld(
            @RequestParam(name = "left") int left,
            @RequestParam(name = "right") int right
    ) {
        int result = calculator.calculate(left, right);

        return String.format("hello world %d", result);
    }
}

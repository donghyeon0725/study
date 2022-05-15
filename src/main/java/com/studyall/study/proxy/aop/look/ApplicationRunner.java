package com.studyall.study.proxy.aop.look;

import com.studyall.study.proxy.aop.client.MemberService;
import com.studyall.study.proxy.aop.client.MemberServiceImpl;

public class ApplicationRunner {

    public static void main(String[] args) {
        ApplicationContainer applicationContainer = new ApplicationContainer();
        applicationContainer.init(args);

        ApplicationContext context = applicationContainer.getContext();
        MemberService service = context.getBean(MemberServiceImpl.class.getName(), MemberService.class);
        service.createMember("유저1");
    }

}

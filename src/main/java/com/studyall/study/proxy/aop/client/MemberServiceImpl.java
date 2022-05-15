package com.studyall.study.proxy.aop.client;

import com.studyall.study.proxy.aop.look.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private List<Member> repository = new ArrayList<>();

    public void createMember(String name) {
        this.repository.add(new Member(name));

        System.out.println("createMember invoke. repository : " + repository.size());
    }
}

package com.nhnacademy.study.filter;

import com.nhnacademy.study.Member;
import com.nhnacademy.study.request.Request;

import java.util.Objects;

public class AdminPageFilter implements Filter{
    @Override
    public void doFilter(Request request, CustomFilterChain CustomFilterChain) {
        if (request.getPath().equals("/admin")) {
            Member member = (Member) request.get("member");
            if (Objects.nonNull(member)) {
                if (member.hasRole(Member.Role.ADMIN)) {
                    System.out.println("path:" + request.getPath() + " : has ADMIN");
                    CustomFilterChain.doFilter(request);
                } else {
                    System.out.println("path : " + request.getPath() + " : has not ADMIN");
                }
            }
        } else {
            System.out.println("AdminPageCheckFilter : 다음 필터로 넘김!");
            CustomFilterChain.doFilter(request);
        }
    }
}

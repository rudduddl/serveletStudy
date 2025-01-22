package com.nhnacademy.study.filter;

import com.nhnacademy.study.Member;
import com.nhnacademy.study.request.Request;

public class MyPageFilter implements Filter{
    @Override
    public void doFilter(Request request, CustomFilterChain customFilterChain){
        if(request.getPath().equals("/mypage")){
            Member member = (Member) request.get("member");
            if(member.hasRole(Member.Role.USER)){
                System.out.println("path : " + request.getPath() + "member role has USER : true");
                customFilterChain.doFilter(request);
            }else{
                System.out.println("path : " + request.getPath() + "member role has USER : false");
            }

        }else{
            System.out.println("MyPageCheckFilter : 다음 필터로 넘김!");

            //다음 filter로 넘김
            customFilterChain.doFilter(request);
        }
    }
}

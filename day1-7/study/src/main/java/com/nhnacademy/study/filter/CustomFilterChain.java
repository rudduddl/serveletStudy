package com.nhnacademy.study.filter;

import com.nhnacademy.study.request.Request;
import com.nhnacademy.study.response.AdminPageResponse;
import com.nhnacademy.study.response.MyPageResponse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomFilterChain {
    private List<Filter> filters = new LinkedList<>();
    private Iterator<Filter> iterator;

    public void addFilter(Filter filter){
        this.filters.add(filter);
        iterator = filters.iterator();
    }

    public void doFilter(Request request){
        if(iterator.hasNext()){
            Filter nextFilter = iterator.next();
            nextFilter.doFilter(request, this);
        } else {
            // 요청 결과값 출력
            if(request.getPath().equals("/mypage")){
                new MyPageResponse().doResponse(request);
            } else if(request.getPath().equals("/admin")){
                new AdminPageResponse().doResponse(request);
            }
        }
    }
}

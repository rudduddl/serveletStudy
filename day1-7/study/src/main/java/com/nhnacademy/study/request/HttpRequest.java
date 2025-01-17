package com.nhnacademy.study.request;

import com.nhnacademy.study.filter.AdminPageFilter;
import com.nhnacademy.study.filter.CustomFilterChain;
import com.nhnacademy.study.filter.MyPageFilter;
import jakarta.servlet.FilterChain;

public class HttpRequest {
    private final CustomFilterChain filterChain = new CustomFilterChain();

    public HttpRequest(){
        initFilter();
    }

    public void doRequest(Request request){
        filterChain.doFilter(request);
    }

    private void initFilter(){
        filterChain.addFilter(new MyPageFilter());
        filterChain.addFilter(new AdminPageFilter());
    }
}
